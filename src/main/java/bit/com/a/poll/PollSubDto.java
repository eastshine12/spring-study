package bit.com.a.poll;

import java.io.Serializable;


/*
 
DROP TABLE POLLSUB
CASCADE CONSTRAINTS;

DROP SEQUENCE POLLSUB_SEQ;


CREATE TABLE POLLSUB(
    POLLSUBID NUMBER NOT NULL,
    POLLID NUMBER NOT NULL,
    ANSWER VARCHAR2(1000) NOT NULL,
    ACOUNT NUMBER NOT NULL,
    CONSTRAINT POLLSUB_PK PRIMARY KEY(POLLSUBID)
);

CREATE SEQUENCE POLLSUB_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE POLLSUB
ADD CONSTRAINT POLLSUB_FK
FOREIGN KEY(POLLID)
REFERENCES POLL(POLLID);
 
 
 */




/* 투표 보기 */
public class PollSubDto implements Serializable {
	
	
	private int pollSubId;	// 보기 번호
	private int pollId;		// 투표번호 (FK)
	private String answer;	// 보기 각항목 이름
	private int aCount;		// 이 보기를 선택한 사람 수
	
	
	public PollSubDto() {
	}


	public PollSubDto(int pollSubId, int pollId, String answer, int aCount) {
		super();
		this.pollSubId = pollSubId;
		this.pollId = pollId;
		this.answer = answer;
		this.aCount = aCount;
	}


	public int getPollSubId() {
		return pollSubId;
	}


	public void setPollSubId(int pollSubId) {
		this.pollSubId = pollSubId;
	}


	public int getPollId() {
		return pollId;
	}


	public void setPollId(int pollId) {
		this.pollId = pollId;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getaCount() {
		return aCount;
	}


	public void setaCount(int aCount) {
		this.aCount = aCount;
	}


	@Override
	public String toString() {
		return "PollSubDto [pollSubId=" + pollSubId + ", pollId=" + pollId + ", answer=" + answer + ", aCount=" + aCount
				+ "]";
	}
	
	
	

}
