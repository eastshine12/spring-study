package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.PdsDto;

public class PdsUtil {

	/* 파일명 변경(time) */
	// ex) myfile.txt --> 2646718454.txt
	
	
	// myfile.txt -> indexOf('.') -> 6
	// '.'의 위치를 구하여 파일명, 확장자명 나눈다.
	// substring(0, 6) -> 파일명. 0부터 6 전까지
	// substring(6) -> 확장자명(.txt). 6부터 끝까지
	
	public static String getNewFileName(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) {	// 도트가 있을 때(확장자명이 있을때),
			fpost = f.substring(f.indexOf('.'));	//확장자명 (.txt)
			filename = new Date().getTime() + fpost;
		}
		else {
			filename = new Date().getTime()+ ".back";	//임의의 확장자명을 붙여둠
		}
		
		return filename;
	}
	
	
	public static PdsDto fileUpload(PdsDto pdsdto, MultipartFile fileload, HttpServletRequest req) {
		
		/* filename 취득 */
		String filename = fileload.getOriginalFilename();
		pdsdto.setFilename(filename);	//원본 파일명
		
		/* upload 경로 설정 */
		// 1. server(tomcat)
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 2. folder(디렉토리)
//		String fupload = "d:\\tmp";
		
		System.out.println("경로 : "+fupload);
		
		/* 파일명 변경 */
		String newFilename = PdsUtil.getNewFileName(pdsdto.getFilename());
		pdsdto.setNewFilename(newFilename);
		
		
		File file = new File(fupload + "/" + newFilename);	// c:~~/~~/43253244214.jpg
		//import org.apache.commons.io.FileUtils;
		try {
			//실제 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pdsdto;
	}
	
	
}
