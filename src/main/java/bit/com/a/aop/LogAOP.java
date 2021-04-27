package bit.com.a.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.a.dto.MemberDto;


/*어노테이션 추가*/
@Aspect
public class LogAOP {
	
	/* com.dto안의 클래스와 연결 */
	@Around("within(bit.com.a.controller.*)" +
			"&& !@annotation(bit.com.a.annotation.NoLogging)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		//System.out.println(signatureStr + " 시작");
		
		/* 로그인 Session 체크 */
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();	//request안에있는 attribute를 다 꺼낸다.
		
		if(request != null) {
			HttpSession session = request.getSession();
			MemberDto login = (MemberDto)session.getAttribute("login");
			if(login == null) {
				return "redirect:/sessionOut.do";
			}
		}
		
		try {
			Object obj = joinpoint.proceed();	// 실행 시
			
			System.out.println("loggerAOP : "+signatureStr+" 메소드가 실행되었습니다." + new Date());
			
			return obj;
			
		}finally {
			//System.out.println("실행 후 : "+System.currentTimeMillis());
			//System.out.println(signatureStr + " 종료");	//실행 후
		}
		
	}

}
