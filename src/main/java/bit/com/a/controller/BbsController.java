package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	
	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model) {
		model.addAttribute("doc_title", "글목록");
		return "bbslist.tiles";
	};
	
	
	@ResponseBody
	@RequestMapping(value = "bbslistData.do", method = RequestMethod.GET)
	public List<BbsDto> bbslistData(@ModelAttribute("bbsParam") BbsParam bbsParam) {
		
		List<BbsDto> list = bbsService.getBbsPagingList(bbsParam);
		
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "bbslistCount.do", method = RequestMethod.GET)
	public int bbslistCount(BbsParam bbsParam) {
		int count = bbsService.getAllBbs(bbsParam);
		System.out.println("count : "+count);
		return count;
	}
	
	
	@RequestMapping(value = "bbsWrite.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbsWrite(Model model) {
		model.addAttribute("doc_title", "글쓰기");
		return "bbswrite.tiles";
	}
	
	
	@RequestMapping(value = "bbsWriteAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbsWriteAf(String title, String content, HttpServletRequest req) {
		//logger.info("BbsController bbsWriteAf() " + new Date());
		
		MemberDto mDto = (MemberDto) req.getSession().getAttribute("login");
		BbsDto dto = new BbsDto(mDto.getId(), title, content);
		int write = bbsService.writeBbs(dto);
		if(write > 0 ) {
			System.out.println("글쓰기 성공");
			return "redirect:/bbslist.do";
		} else {
			System.out.println("글쓰기 실패");
			return "redirect:/bbsWrite.do";
		}
	}
	
	
	@RequestMapping(value = "bbsDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbsDetail(Model model, Integer seq) {
		
		if(seq == null) seq = 0;
		
		BbsDto dto = bbsService.getDetail(seq);
		model.addAttribute("bbs", dto);
		model.addAttribute("doc_title", "글 상세페이지");
		return "bbsDetail.tiles";
	}
	
	
	
	@RequestMapping(value = "delete.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(Model model, Integer seq) {
		
		if(seq == null) seq = -1;
		
		boolean b = bbsService.delete(seq);
		
		if(b) {
			System.out.println("삭제 성공");
			return "redirect:/bbslist.do";
		} else {
			System.out.println("삭제 실패");
			return "redirect:/bbsDetail.do";
		}
	}
	
	
	
	@RequestMapping(value = "bbsUpdate.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbsUpdate(Model model, Integer seq) {
		//logger.info("BbsController bbsUpdate() " + new Date());
		
		if(seq == null) seq = -1;
		BbsDto dto = bbsService.getDetail(seq);
		model.addAttribute("bbs", dto);
		model.addAttribute("doc_title", "글수정");
		return "bbsUpdate.tiles";
	}
	
	
	@RequestMapping(value = "bbsUpdateAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String bbsUpdateAf(Integer seq, String title, String content) {
		//logger.info("BbsController bbsUpdateAf() " + new Date());
		
		if(seq == null) seq = -1;
		BbsDto dto = new BbsDto(seq, title, content);
		boolean b = bbsService.update(dto);
		if(b) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		return "redirect:/bbslist.do";
	}	
	
	
	
	@RequestMapping(value = "answer.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String answer(Model model, Integer seq) {
		//logger.info("BbsController answer() " + new Date());
		
		if(seq == null) seq = -1;
		BbsDto dto = bbsService.getDetail(seq);
		model.addAttribute("bbs", dto);
		model.addAttribute("doc_title", "글 답변");
		return "answer.tiles";
	}
	
	
	@RequestMapping(value = "answerAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String answerAf(Integer seq, String title, String content, HttpServletRequest req) {
		//logger.info("BbsController answerAf() " + new Date());
		
		if(seq == null) seq = -1;
		MemberDto mDto = (MemberDto) req.getSession().getAttribute("login");
		BbsDto dto = new BbsDto(seq, mDto.getId(), title, content);
		
		bbsService.answerUpdate(seq);
		bbsService.answerInsert(dto);
		
		return "redirect:/bbslist.do";
	}	
	

}
