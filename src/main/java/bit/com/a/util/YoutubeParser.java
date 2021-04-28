package bit.com.a.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;



//IoC 컨테이너에 Bean을 등록하도록 한다. Autowired 어노테이션을 이용하여 의존성 주입 가능.
@Component
public class YoutubeParser {
	
	String urls = "https://www.youtube.com/results?search_query=";
	
	public String search(String s) {
		
		BufferedReader br = null;
		String str = "";
		try {
			String ss = URLEncoder.encode(s, "utf-8");
		
			URL url = new URL(urls + ss);
			br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			
			String msg = "";
			String text = "";
			
			while((msg = br.readLine()) != null) {
				text += msg.trim();
			}
			
			//System.out.println("text : "+ text);
			
			// 시작위치
			int pos = text.trim().indexOf("\"responseContext\"");
			
			// 끝위치
			int endpos =  text.indexOf("};", pos);	// pos 다음에 있는 위치
			
			str = text.substring(pos-1, endpos+1);
			
			//System.out.println("str : "+str);
			
			str = str.replace("\"", "\\\"");	// "를 \"로 바꿈
			str = str.replace("\'", "\\\'");	// '를 \'로 바꿈
			
				
		}	
		catch (MalformedURLException e) {
			e.printStackTrace();
	
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
}
