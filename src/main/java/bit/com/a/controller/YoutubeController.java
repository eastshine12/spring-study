package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.dto.YoutubeDto;
import bit.com.a.service.impl.YoutubeServiceImpl;
import bit.com.a.util.YoutubeParser;


@Controller
public class YoutubeController {
	
	
	@Autowired
	YoutubeParser youtubeParser;
	
	@Autowired
	YoutubeServiceImpl service;
	
	@RequestMapping(value = "youtube.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String youtube(@ModelAttribute("s_keyword")String s_keyword, Model model) {
		
		model.addAttribute("doc_title", "유튜브");
		
		if(s_keyword != null && !s_keyword.equals("")) {
			String getTitles = youtubeParser.search(s_keyword);
			model.addAttribute("yuList", getTitles);
		}
		
		return "youtube.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "youtubeSave.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String youtubeSave(YoutubeDto you) {
		System.out.println(you.toString());
		
		boolean b = service.addYou(you);
		
		if(b) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	
	@RequestMapping(value = "youtubeList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String youtubeList(HttpSession session, Model model) {
		model.addAttribute("doc_title", "유튜브 목록");
		
		String id = ((MemberDto)session.getAttribute("login")).getId();
		
		YoutubeDto dto = new YoutubeDto();
		dto.setId(id);
		
		List<YoutubeDto> list = service.getYoutubeList(dto);
		
		model.addAttribute("youList", list);
		
		return "youtubeList.tiles";
	}
	
	
	

}
