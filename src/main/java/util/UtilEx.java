package util;

import java.sql.Date;
import java.util.List;

import bit.com.a.dto.CalendarDto;



public class UtilEx {

	
	
	
	/* 날짜를 클릭하면 그 날의 일정을 모두 볼 수 있는 callist.jsp로 이동하는 url 만드는 메소드 */
	public static String callist(int year, int month, int day) {
		String str = "";
		
		str += String.format("&nbsp;<a href='%s?year=%d&month=%d&day=%d'>", "callist.jsp", year, month, day);
		
		str += String.format("%2d", day);
		str += "</a>";
		
		// ex) <a href='callist.jsp?year=2021&month=3&day=19'>19</a>
		
		return str;
		
	}
	
	
	
	/* 일정을 추가하기 위해서 pen 이미지를 클릭하면 calwrite.jsp로 이동하는 url 만드는 메소드 */
	public static String showPen(int year, int month, int day) {
		
		String str = "";
		String image = "<img src='image/pen2.png' width='18px' height='18px'>";
		
		str = String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>", "calwrite.jsp", year, month, day, image);
		
		// ex)	<a href='calwrite.jsp?year=2021&month=3&day=19'><img src='image/pen2.png' width='18px' height='18px'></a>
		
		return str;
		
	}
	
	
	
	/* 한 문자를 두 문자로 변경해주는 메소드 (ex 3월 - > 2021319 가 아닌 20210319로 만든다) */
	public static String two(String msg) {
		return msg.trim().length() < 2 ? "0"+msg.trim() : msg.trim();
		//길이가 2보다 작으면 앞에 0을 붙여준다.
	}
	
	
	/* nvl 함수역할 메소드 : 문자열이 비어있는지 확인 */
	public static boolean nvl(String msg) {
		return msg == null || msg.trim().equals("") ? true : false;
		//비어있거나 null이면 true 리턴
	}
	
	
	
	/* 달력의 날짜 별로 스케줄을 설정할 테이블을 작성하는 메소드 */
	public static String makeTable(int year, int month, int day, List<CalendarDto> list) {	//검색할 년,월,일과 list?
		String str = "";
		String dates = (year+"") + two(month+"") + two(day+"");	//월과 일은 한자리일때 두자리로 바꿔줌
		
		str += "<table>";
		str += "<col width='100'>";
		
		for(CalendarDto dto : list) {
			if(dto.getRdate().substring(0, 8).equals(dates)) {	//'list안의 날짜'가 '입력하는 날짜'와 같을 때,
				str += "<tr>";
				str += "<td style='line-height: 3px; overflow: hidden; border-collapse:collapse;'>";
				str += "<a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";
				str += "<font style='font-size:13px; color:blue'>";
				str += dot3(dto.getTitle());
				str += "</font>";
				str += "</a>";
				str += "</td>";
				str += "</tr>";
			}
		}
		
		str += "</table>";
		
		return str;
		
	}
	
	
	
	
	/* 일정의 제목이 길 때 ... 으로 처리하는 메소드 (ex 5글자 제한일 때, CGV에서 데이트 -> CGV에서... ) */
	public static String dot3(String msg) {
		String str = "";
		if(msg.length() > 5) {
			str = msg.substring(0, 5); // ex) CGV에서 데이트 -> CGV에서
			str += "...";
		}
		else {
			str = msg.trim();
		}
		return str;
	}
	
	
	/* 2021-04-26 -> java.sql.Date로 변경 */
	public static Date toDate(int year, int month, int day) {
		String s = year + "-" + two(month+"") + "-" + two(day+"");
		Date d = Date.valueOf(s);	// SQL Date형으로 변경
		return d;
	}
	

	
	
	
	
	
	
}
