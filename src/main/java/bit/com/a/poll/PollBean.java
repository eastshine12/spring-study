package bit.com.a.poll;

import java.util.Arrays;
import java.util.Date;

import util.UtilEx;

/* 투표 작성자가 작성해서 넘겨준 경우, 받은 데이터들 (PollDto + PollSubDto) */
public class PollBean {

	private String id;	// 작성자
	private int sYear;	// 시작 년도
	private int sMonth;	// 시작 월
	private int sDay;	// 시작 일
	private int eYear;	// 종료 년도
	private int eMonth;	// 종료 월
	private int eDay;	// 종료 일
	private Date sDate;
	private Date eDate;
	private String question;	// 투표 질문 제목
	private int itemCount;		// 보기 수 -> 2~10개
	
	private String poll1;	// 보기 각 항목 이름
	private String poll2;
	private String poll3;
	private String poll4;
	private String poll5;
	private String poll6;
	private String poll7;
	private String poll8;
	private String poll9;
	private String poll10;
	private String poll11;
	private String poll12;
	private String poll13;
	private String poll14;
	private String poll15;
	private String poll16;
	private String poll17;
	private String poll18;
	private String poll19;
	private String poll20;
	
	private String pollNum[] = new String[20];
	
	// 보기묶음
	public String[] getPollNum() {
		pollNum[0] = poll1;
		pollNum[1] = poll2;
		pollNum[2] = poll3;
		pollNum[3] = poll4;
		pollNum[4] = poll5;
		pollNum[5] = poll6;
		pollNum[6] = poll7;
		pollNum[7] = poll8;
		pollNum[8] = poll9;
		pollNum[9] = poll10;
		pollNum[10] = poll11;
		pollNum[11] = poll12;
		pollNum[12] = poll13;
		pollNum[13] = poll14;
		pollNum[14] = poll15;
		pollNum[15] = poll16;
		pollNum[16] = poll17;
		pollNum[17] = poll18;
		pollNum[18] = poll19;
		pollNum[19] = poll20;
		
		return pollNum;
	}
	
	
	public PollBean() {
	}


	public Date getsDate() {
		return UtilEx.toDate(sYear, sMonth, sDay);
	}


	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}


	public Date geteDate() {
		return UtilEx.toDate(eYear, eMonth, eDay);
	}


	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getsYear() {
		return sYear;
	}


	public void setsYear(int sYear) {
		this.sYear = sYear;
	}


	public int getsMonth() {
		return sMonth;
	}


	public void setsMonth(int sMonth) {
		this.sMonth = sMonth;
	}


	public int getsDay() {
		return sDay;
	}


	public void setsDay(int sDay) {
		this.sDay = sDay;
	}


	public int geteYear() {
		return eYear;
	}


	public void seteYear(int eYear) {
		this.eYear = eYear;
	}


	public int geteMonth() {
		return eMonth;
	}


	public void seteMonth(int eMonth) {
		this.eMonth = eMonth;
	}


	public int geteDay() {
		return eDay;
	}


	public void seteDay(int eDay) {
		this.eDay = eDay;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public int getItemCount() {
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}


	public String getPoll1() {
		return poll1;
	}


	public void setPoll1(String poll1) {
		this.poll1 = poll1;
	}


	public String getPoll2() {
		return poll2;
	}


	public void setPoll2(String poll2) {
		this.poll2 = poll2;
	}


	public String getPoll3() {
		return poll3;
	}


	public void setPoll3(String poll3) {
		this.poll3 = poll3;
	}


	public String getPoll4() {
		return poll4;
	}


	public void setPoll4(String poll4) {
		this.poll4 = poll4;
	}


	public String getPoll5() {
		return poll5;
	}


	public void setPoll5(String poll5) {
		this.poll5 = poll5;
	}


	public String getPoll6() {
		return poll6;
	}


	public void setPoll6(String poll6) {
		this.poll6 = poll6;
	}


	public String getPoll7() {
		return poll7;
	}


	public void setPoll7(String poll7) {
		this.poll7 = poll7;
	}


	public String getPoll8() {
		return poll8;
	}


	public void setPoll8(String poll8) {
		this.poll8 = poll8;
	}


	public String getPoll9() {
		return poll9;
	}


	public void setPoll9(String poll9) {
		this.poll9 = poll9;
	}


	public String getPoll10() {
		return poll10;
	}


	public void setPoll10(String poll10) {
		this.poll10 = poll10;
	}


	public String getPoll11() {
		return poll11;
	}


	public void setPoll11(String poll11) {
		this.poll11 = poll11;
	}


	public String getPoll12() {
		return poll12;
	}


	public void setPoll12(String poll12) {
		this.poll12 = poll12;
	}


	public String getPoll13() {
		return poll13;
	}


	public void setPoll13(String poll13) {
		this.poll13 = poll13;
	}


	public String getPoll14() {
		return poll14;
	}


	public void setPoll14(String poll14) {
		this.poll14 = poll14;
	}


	public String getPoll15() {
		return poll15;
	}


	public void setPoll15(String poll15) {
		this.poll15 = poll15;
	}


	public String getPoll16() {
		return poll16;
	}


	public void setPoll16(String poll16) {
		this.poll16 = poll16;
	}


	public String getPoll17() {
		return poll17;
	}


	public void setPoll17(String poll17) {
		this.poll17 = poll17;
	}


	public String getPoll18() {
		return poll18;
	}


	public void setPoll18(String poll18) {
		this.poll18 = poll18;
	}


	public String getPoll19() {
		return poll19;
	}


	public void setPoll19(String poll19) {
		this.poll19 = poll19;
	}


	public String getPoll20() {
		return poll20;
	}


	public void setPoll20(String poll20) {
		this.poll20 = poll20;
	}


	public void setPollNum(String[] pollNum) {
		this.pollNum = pollNum;
	}


	@Override
	public String toString() {
		return "PollBean [id=" + id + ", sYear=" + sYear + ", sMonth=" + sMonth + ", sDay=" + sDay + ", eYear=" + eYear
				+ ", eMonth=" + eMonth + ", eDay=" + eDay + ", sDate=" + sDate + ", eDate=" + eDate + ", question="
				+ question + ", itemCount=" + itemCount + ", poll1=" + poll1 + ", poll2=" + poll2 + ", poll3=" + poll3
				+ ", poll4=" + poll4 + ", poll5=" + poll5 + ", poll6=" + poll6 + ", poll7=" + poll7 + ", poll8=" + poll8
				+ ", poll9=" + poll9 + ", poll10=" + poll10 + ", poll11=" + poll11 + ", poll12=" + poll12 + ", poll13="
				+ poll13 + ", poll14=" + poll14 + ", poll15=" + poll15 + ", poll16=" + poll16 + ", poll17=" + poll17
				+ ", poll18=" + poll18 + ", poll19=" + poll19 + ", poll20=" + poll20 + ", pollNum="
				+ Arrays.toString(pollNum) + "]";
	}
	
	
	

}
