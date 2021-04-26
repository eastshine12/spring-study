package bit.com.a.poll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.MemberDto;

@Controller
public class PollController {

	@Autowired
	PollService service;
	
	
	@RequestMapping(value = "pollList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pollList(Model model, HttpServletRequest req) {
		model.addAttribute("doc_title", "투표 목록");
		
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		
		List<PollDto> list = service.getPollAllList(id);
		model.addAttribute("pLists", list);
		
		return "pollList.tiles"; 
	}
	
	
	@RequestMapping(value = "pollMake.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pollMake(Model model) {
		model.addAttribute("doc_title", "투표 만들기");
		
		return "pollMake.tiles";
	}
	
	
	@RequestMapping(value = "pollMakeAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pollMakeAf(PollBean pBean) {
		
		service.makePoll(pBean);
		
		return "redirect:/pollList.do";
	}
	
	
	@RequestMapping(value = "pollDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pollDetail(PollDto poll, Model model) {
		model.addAttribute("doc_title", "투표 내용");
		
		PollDto dto = service.getPoll(poll);
		List<PollSubDto> list = service.getPollSubList(poll);
		model.addAttribute("poll", dto);
		model.addAttribute("pollSubList", list);
		
		return "pollDetail.tiles";
	}
	
	
	@RequestMapping(value = "polling.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String polling(Voter voter) {
		service.polling(voter);
		
		return "redirect:/pollList.do";
	}
	
	
	
	
}
