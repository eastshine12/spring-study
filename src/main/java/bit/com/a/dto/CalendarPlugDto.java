package bit.com.a.dto;

import java.io.Serializable;


/*
  
 --테이블 생성 쿼리문--
  
DROP TABLE CALENDARPLUG
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_CALPLUG;

CREATE TABLE CALENDARPLUG(
    SEQ NUMBER(8) PRIMARY KEY,
    ID VARCHAR2(50) NOT NULL,
    SLEVEL NUMBER(8),
    TITLE VARCHAR2(200) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    STARTDATE VARCHAR2(20) NOT NULL,
    ENDDATE VARCHAR2(20),
    WDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_CALPLUG
START WITH 1
INCREMENT BY 1;

ALTER TABLE CALENDARPLUG
ADD CONSTRAINT FK_CALPLUG_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);


INSERT INTO calendarplug(SEQ,ID,SLEVEL,TITLE,CONTENT,STARTDATE,ENDDATE,WDATE)
VALUES (SEQ_CALPLUG.nextval, 'aaa', 1, '사업 미팅', '제품 계약서 건', '2021-04-05T12:30', '', SYSDATE);


INSERT INTO calendarplug(SEQ,ID,SLEVEL,TITLE,CONTENT,STARTDATE,ENDDATE,WDATE)
VALUES (SEQ_CALPLUG.nextval, 'aaa', 1, '국내 여행', '대포항', '2021-04-26T08:30', '2021-04-30T16:00', SYSDATE);



INSERT INTO calendarplug(SEQ,ID,SLEVEL,TITLE,CONTENT,STARTDATE,ENDDATE,WDATE)
VALUES (SEQ_CALPLUG.nextval, 'aaa', 1, '연수', '워크숍', '2021-05-02', '', SYSDATE);

 
 */




public class CalendarPlugDto implements Serializable {

	private int seq;
	private String id;
	private int slevel;			//중요도: 1,2,3
	private String title;
	private String content;
	private String startDate;	//시작일
	private String endDate;		//종료일(생략가능)
	private String wdate;		//작성일
	
	public CalendarPlugDto() {
		// TODO Auto-generated constructor stub
	}

	public CalendarPlugDto(int seq, String id, int slevel, String title, String content, String startDate,
			String endDate, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.slevel = slevel;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.wdate = wdate;
	}

	public CalendarPlugDto(String id, int slevel, String title, String content, String startDate, String endDate) {
		super();
		this.id = id;
		this.slevel = slevel;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public int getSlevel() {
		return slevel;
	}

	public void setSlevel(int slevel) {
		this.slevel = slevel;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "CalendarPlugDto [seq=" + seq + ", id=" + id + ", slevel=" + slevel + ", title=" + title + ", content="
				+ content + ", startDate=" + startDate + ", endDate=" + endDate + ", wdate=" + wdate + "]";
	}
	
	
	
}
