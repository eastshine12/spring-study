package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;


/* 투표자 */
public class Voter implements Serializable {

	private int voterId;
	private int pollId;		// 투표번호 ID		FK
	private int pollSubId;	// 투표 보기 ID	FK
	private String id;		// 투표한 사람 ID	FK
	private Date regDate;	// 언제 투표했는지
	
	
	public Voter() {
	}


	public Voter(int voterId, int pollId, int pollSubId, String id, Date regDate) {
		super();
		this.voterId = voterId;
		this.pollId = pollId;
		this.pollSubId = pollSubId;
		this.id = id;
		this.regDate = regDate;
	}
	


	public Voter(int pollId, int pollSubId, String id) {
		super();
		this.pollId = pollId;
		this.pollSubId = pollSubId;
		this.id = id;
	}


	public int getVoterId() {
		return voterId;
	}


	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}


	public int getPollId() {
		return pollId;
	}


	public void setPollId(int pollId) {
		this.pollId = pollId;
	}


	public int getPollSubId() {
		return pollSubId;
	}


	public void setPollSubId(int pollSubId) {
		this.pollSubId = pollSubId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", pollId=" + pollId + ", pollSubId=" + pollSubId + ", id=" + id
				+ ", regDate=" + regDate + "]";
	}
	
	

}
