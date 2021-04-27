package bit.com.a.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.annotation.NoLogging;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@NoLogging
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		
		return "login.tiles";
	}
	
	@NoLogging
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		
		return "regi.tiles";
	}
	
	
	@ResponseBody	// Ajax 사용시에 반드시 붙여주는 어노테이션
	@RequestMapping(value = "idcheck.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String idcheck(String id) {
		
		String s = memberService.idCheck(id);
		
		return s == null ? "YES" : "NO";
	}	
	
	@NoLogging
	@RequestMapping(value = "regiAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String regiAf(MemberDto dto) {
		
		int i = memberService.addMember(dto);
		
		return i > 0 ? "login.tiles" : "regi.tiles";
	}
	
	@NoLogging
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {
		
		MemberDto login = memberService.login(dto);
		if(login != null && !login.getId().equals("")) {
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60*60*24);
			
			return "redirect:/bbslist.do";
		}
		else {
			return "redirect:/login.do";
		}
	}
	
	@RequestMapping(value = "logout.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(MemberDto dto, HttpServletRequest req) {
		
		//logger.info("MemberController logout() " +new Date());
		if(req.getSession().getAttribute("login") != null) {
			req.getSession().invalidate();
			System.out.println("로그아웃됨");
		}
			
		return "redirect:/login.do";
	}

	
	@RequestMapping(value = "sessionOut.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String sessionOut() {
		return "sessionOut.tiles";
	}
	
	

}
