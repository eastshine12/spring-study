package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;


/*
  
DROP TABLE POLL
CASCADE CONSTRAINTS;

DROP SEQUENCE POLL_SEQ;


CREATE TABLE POLL(
    POLLID NUMBER NOT NULL,
    ID VARCHAR2(50) NOT NULL,
    QUESTION VARCHAR2(1000) NOT NULL,
    SDATE DATE NOT NULL,
    EDATE DATE NOT NULL,
    ITEMCOUNT NUMBER NOT NULL,
    POLLTOTAL NUMBER NOT NULL,
    REGDATE DATE NOT NULL,
    CONSTRAINT POLL_PK PRIMARY KEY(POLLID)
);

CREATE SEQUENCE POOL_SEQ
START WITH 1
INCREMENT BY 1;


ALTER TABLE POLL
ADD CONSTRAINT POLL_FK
FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
  
 
 */




/* 투표 주제(질의) */
public class PollDto implements Serializable {

	private int pollId;			//	sequence 투표번호
	private String id;			//	투표 만든 사람 ID
	private String question;	//	투표 질문 제목
	private Date sDate;			//	투표 시작일
	private Date eDate;			//	투표 종료일
	private Date regDate;		// 	투표 만든 날
	private int itemCount;		//	보기 수 -> 2~10개
	private int pollTotal;		//	해당 항목을 투표한 사람의 수
	private boolean vote;		//	투표를 했는지 안했는지 체크
	
	
	public PollDto() {
	}


	public PollDto(int pollId, String id, String question, Date sDate, Date eDate, Date regDate, int itemCount,
			int pollTotal, boolean vote) {
		this.pollId = pollId;
		this.id = id;
		this.question = question;
		this.sDate = sDate;
		this.eDate = eDate;
		this.regDate = regDate;
		this.itemCount = itemCount;
		this.pollTotal = pollTotal;
		this.vote = vote;
	}

	
	

	public PollDto(String id, String question, Date sDate, Date eDate, int itemCount, int pollTotal) {
		this.id = id;
		this.question = question;
		this.sDate = sDate;
		this.eDate = eDate;
		this.itemCount = itemCount;
		this.pollTotal = pollTotal;
	}


	public int getPollId() {
		return pollId;
	}


	public void setPollId(int pollId) {
		this.pollId = pollId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Date getsDate() {
		return sDate;
	}


	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}


	public Date geteDate() {
		return eDate;
	}


	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getItemCount() {
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}


	public int getPollTotal() {
		return pollTotal;
	}


	public void setPollTotal(int pollTotal) {
		this.pollTotal = pollTotal;
	}


	public boolean isVote() {
		return vote;
	}


	public void setVote(boolean vote) {
		this.vote = vote;
	}


	@Override
	public String toString() {
		return "PollDto [pollId=" + pollId + ", id=" + id + ", question=" + question + ", sDate=" + sDate + ", eDate="
				+ eDate + ", regDate=" + regDate + ", itemCount=" + itemCount + ", pollTotal=" + pollTotal + ", vote="
				+ vote + "]";
	}
	
	

}
