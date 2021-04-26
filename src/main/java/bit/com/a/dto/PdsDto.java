package bit.com.a.dto;

import java.io.Serializable;

public class PdsDto implements Serializable {
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private String filename;	// 원본이름
	private String newFilename;	// 바뀐이름
	private int readcount;
	private int downcount;
	private String regdate;
	
	
	public PdsDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PdsDto(int seq, String id, String title, String content, String filename, String newFilename, int readcount,
			int downcount, String regdate) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newFilename = newFilename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}



	public PdsDto(String id, String title, String content, String filename) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}



	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public String getNewFilename() {
		return newFilename;
	}



	public void setNewFilename(String newFilename) {
		this.newFilename = newFilename;
	}



	public int getReadcount() {
		return readcount;
	}



	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}



	public int getDowncount() {
		return downcount;
	}



	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	@Override
	public String toString() {
		return "PdsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", filename="
				+ filename + ", newFilename=" + newFilename + ", readcount=" + readcount + ", downcount=" + downcount
				+ ", regdate=" + regdate + "]";
	}
	

	
	
}
