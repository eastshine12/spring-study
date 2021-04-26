package bit.com.a.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.CalParam;
import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.CalService;
import util.UtilEx;

@Controller
public class CalController {
	
	
	@Autowired
	CalService calService;
	
	
	@RequestMapping(value = "callist.do", method = RequestMethod.GET)
	public String callist(Model model) {
		
		model.addAttribute("doc_title", "일정관리");
		
		return "callist.tiles";
	};
	
	
	@ResponseBody
	@RequestMapping(value = "callistData.do", method = RequestMethod.GET)
	public List<CalendarDto> callistData(String year, String month, HttpServletRequest req) {
		System.out.println("year : "+year+ " month : "+month);
		MemberDto mDto = (MemberDto)req.getSession().getAttribute("login");
		CalParam param = new CalParam(mDto.getId(), year+UtilEx.two(month));
		List<CalendarDto> list = calService.getCalList(param);
		
		return list;
	}
	
	
	@RequestMapping(value = "calDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String calDetail(Model model, Integer seq) {
		
		if(seq == null) seq = 0;
		System.out.println("seq : "+seq);
		CalendarDto dto = calService.calDetail(seq);
		model.addAttribute("cal", dto);
		model.addAttribute("doc_title", "일정 상세페이지");
		return "calDetail.tiles";
	}
	
	@RequestMapping(value = "calWrite.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String calWrite(Model model, CalParam param) {
		model.addAttribute("doc_title", "일정쓰기");
		model.addAttribute("param", param);
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(param.getYear());
		int month = Integer.parseInt(param.getMonth());
		cal.set(year, month-1, 1);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println(year+"년 "+month+"월의 일수 : "+maxDay);
		model.addAttribute("maxDay", maxDay);
		
		
		
		
		
		return "calWrite.tiles";
	}
	
	
	
	@RequestMapping(value = "calWriteAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String calWriteAf(CalendarDto dto, CalParam param) {
		
		String rdate = param.getYear()+UtilEx.two(param.getMonth())
						+UtilEx.two(param.getDay())+UtilEx.two(param.getHour())+UtilEx.two(param.getMin());
		System.out.println("글쓴시간 : "+rdate);
		System.out.println(dto.toString());
		dto.setRdate(rdate);

		int write = calService.calWrite(dto);
		if(write > 0 ) {
			System.out.println("글쓰기 성공");
			return "redirect:/callist.do";
		} else {
			System.out.println("글쓰기 실패");
			return "redirect:/calWrite.do";
		}
	}
	
	
	@RequestMapping(value = "calDelete.do", method = RequestMethod.GET) 
	public String calDelete(int seq) {
		
		int del = calService.calDelete(seq);
		
		if(del > 0 ) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		return "redirect:/callist.do";
	}
	
	
	@RequestMapping(value = "calUpdate.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String calUpdate(Model model, int seq) {
		model.addAttribute("doc_title", "일정수정");
		
		CalendarDto dto = calService.calDetail(seq);
		CalParam param = new CalParam(null, null, 
									dto.getRdate().substring(0, 4),
									dto.getRdate().substring(4, 6),
									dto.getRdate().substring(6, 8),
									dto.getRdate().substring(8, 10),
									dto.getRdate().substring(10, 12));
		//System.out.println(param.toString());
		//System.out.println(dto.toString());
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(param.getYear());
		int month = Integer.parseInt(param.getMonth());
		cal.set(year, month-1, 1);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println(year+"년 "+month+"월의 일수 : "+maxDay);
		model.addAttribute("maxDay", maxDay);
		model.addAttribute("param1", param);
		model.addAttribute("cal", dto);
		
		return "calUpdate.tiles";
	}

	
	@RequestMapping(value = "calUpdateAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String calUpdateAf(CalendarDto dto, CalParam param) {
		
		String rdate = param.getYear()+UtilEx.two(param.getMonth())
						+UtilEx.two(param.getDay())+UtilEx.two(param.getHour())+UtilEx.two(param.getMin());
		System.out.println("글쓴시간 : "+rdate);
		dto.setRdate(rdate);
		System.out.println(dto.toString());

		int update = calService.calUpdate(dto);
		if(update > 0 ) {
			System.out.println("수정 성공");
			return "redirect:/callist.do";
		} else {
			System.out.println("수정 실패");
			return "redirect:/calWrite.do";
		}
	}
	
	
	@RequestMapping(value = "calDayList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String calDayList(Model model, @ModelAttribute("param2")CalParam param, HttpSession session) {
		model.addAttribute("doc_title", "하루 일정");
		MemberDto mDto = (MemberDto)session.getAttribute("login");
		
		param.setId(mDto.getId());
		param.setYyyyMMdd(param.getYear()+UtilEx.two(param.getMonth())+UtilEx.two(param.getDay()));
		
		System.out.println(param.toString());
		List<CalendarDto> list = calService.getDayList(param);
		
		model.addAttribute("dayList", list);
		
		return "calDayList.tiles";
	}
	
	
	

}
