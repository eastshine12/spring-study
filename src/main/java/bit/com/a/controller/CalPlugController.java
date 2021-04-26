package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.CalendarPlugDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.CalPlugService;


@Controller
public class CalPlugController {
	
	@Autowired
	CalPlugService service;
	
	
	@RequestMapping(value = "calendarPlugList.do", method = RequestMethod.GET)
	public String calendarPlugList(Model model, HttpSession session) {
		model.addAttribute("doc_title", "일정목록 plug");
		
		MemberDto dto = (MemberDto)session.getAttribute("login");
		CalendarPlugDto cal = new CalendarPlugDto();
		cal.setId(dto.getId());
		
		List<CalendarPlugDto> list = service.getCalendarPlugList(cal);
		
		model.addAttribute("callist", list);


		
		return "calendarPlugList.tiles";
	}
	

}
