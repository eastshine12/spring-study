package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;
import util.PdsUtil;


@Controller
public class PdsController {

	@Autowired
	PdsService service;
	
	@RequestMapping(value = "pdslist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdslist(Model model) {
		model.addAttribute("doc_title", "자료실 목록");
		
		List<PdsDto> list = service.getPdsList();
		model.addAttribute("pdslist", list);
		
		
		return "pdslist.tiles";
	}
	
	
	@RequestMapping(value = "pdsWrite.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsWrite(Model model) {
		model.addAttribute("doc_title", "자료 올리기");
		
		return "pdsWrite.tiles";
	}
	
	
	
	@RequestMapping(value = "pdsUpload.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsUpload(PdsDto pdsdto, @RequestParam(value="fileload", required = false) MultipartFile fileload,
								HttpServletRequest req) {
		
		PdsUtil.fileUpload(pdsdto, fileload, req);
		
		//DB저장
		service.uploadPds(pdsdto);
		
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value = "fileDownload.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String fileDownload(String newFilename, int seq, HttpServletRequest req, Model model) {
		
		
		/* download 경로 설정 */
		// 1. server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 2. folder
//		String fupload = "d:\\tmp";
		
		File downloadFile = new File(fupload + "/" + newFilename);
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		
		return "downloadView";
	}
	
	
	@RequestMapping(value = "pdsDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pdsDetail(Model model, Integer seq, HttpServletRequest req) {
		
		if(seq == null) seq = -1;
		
		service.readCount(seq);
		PdsDto dto = service.getDetail(seq);
		
		model.addAttribute("pds", dto);
		model.addAttribute("doc_title", "글 상세페이지");
		return "pdsDetail.tiles";
	}
	
	
	
	@RequestMapping(value = "pdsDelete.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pdsDelete(Model model, Integer seq) {
		
		if(seq == null) seq = -1;
		
		boolean b = service.deletePds(seq);
		
		if(b) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		return "redirect:/pdslist.do";
		
	}
	
	
	@RequestMapping(value = "pdsUpdate.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pdsUpdate(Model model, Integer seq) {
		
		if(seq == null) seq = -1;
		PdsDto dto = service.getDetail(seq);
		model.addAttribute("pds", dto);
		model.addAttribute("doc_title", "글수정");
		return "pdsUpdate.tiles";
	}
	
	
	@RequestMapping(value = "pdsUpdateAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsUpdateAf(PdsDto pdsdto, @RequestParam(value="fileload", required = false) MultipartFile fileload,
								HttpServletRequest req) {
		
		System.out.println("파일들어왔는지 안들어왔는지. 들어오면 true: "+!fileload.isEmpty());
		
		if(!fileload.isEmpty()) {
			PdsUtil.fileUpload(pdsdto, fileload, req);
		}
		
		System.out.println("수정사항 :" +pdsdto.toString());
		boolean b = service.updatePds(pdsdto);
		
		if(b) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		return "redirect:/pdslist.do";
	}	
	
}
