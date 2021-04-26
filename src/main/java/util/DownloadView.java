package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import bit.com.a.service.PdsService;

public class DownloadView extends AbstractView {

	
	@Autowired
	PdsService service;
	
	
	public DownloadView() {
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		File file = (File)model.get("downloadFile");	// getAttribute와 동일
		
		response.setContentType(this.getContentType());
		response.setContentLength((int)(file.length()));
		
		
		
		// IE/chrome (참고)
		String userAgent = request.getHeader("user-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;	// true면 IE, false면 chrome
		
		String fileName = null;
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		
		
		String originalFilename = service.getFileName(fileName);
		
		originalFilename = URLEncoder.encode(originalFilename, "utf-8");
		
		System.out.println("파일 이름 : "+fileName);
		System.out.println("원본 파일 이름 : "+originalFilename);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;"); 
		response.setHeader("Expires", "-1;");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = new FileInputStream(file);
		
		FileCopyUtils.copy(fi, out);
		
		
		/* 다운로드수 증가 */
		int seq = (int) model.get("seq");
		service.downCount(seq);
		
		
		
		
		if(fi != null) {
			fi.close();
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	

}
