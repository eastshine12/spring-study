<%@page import="util.PollUtil"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.poll.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	List<PollDto> pLists = (List<PollDto>)request.getAttribute("pLists");
	MemberDto mem = (MemberDto)session.getAttribute("login");
%>


<!-- 관리자 -->
<%
if(mem.getAuth() == 1) {
%>
	<table class="list_table" style="width: 95%;">
		<col width="50"><col width="50"><col width="300"><col width="100">
		<col width="100"><col width="50"><col width="50"><col width="100">	
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>투표제목</th>
			<th>시작일</th>
			<th>종료일</th>
			<th>보기 개수</th>
			<th>투표횟수</th>
			<th>등록일</th>
		</tr>
		<%
		for(int i = 0; i < pLists.size(); i++) {
			PollDto poll = pLists.get(i);
			%>
			<tr bgcolor="#aabbcc">
				<td><%=i+1 %></td>
				<td><%=poll.getId() %></td>
				<td><%=poll.getQuestion() %></td>
				<td><%=poll.getsDate() %></td>
				<td><%=poll.geteDate() %></td>
				<td><%=poll.getItemCount() %></td>
				<td><%=poll.getPollTotal() %></td>
				<td><%=poll.getRegDate() %></td>
			</tr>
		<%
		}
		%>
	</table>

<!-- 사용자 -->
<% 
} else { 
%>

	<table class="list_table" style="width: 95%;">
		<col width="50"><col width="50"><col width="300"><col width="100"><col width="100">
		<col width="100"><col width="50"><col width="50"><col width="100">	
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>투표제목</th>
			<th>결과</th>
			<th>시작일</th>
			<th>종료일</th>
			<th>보기 개수</th>
			<th>투표횟수</th>
			<th>등록일</th>
		</tr>
		<%
		for(int i = 0; i < pLists.size(); i++) {
			PollDto poll = pLists.get(i);
			%>
			<tr bgcolor="#aabbcc">
				<td><%=i+1 %></td>
				<td><%=poll.getId() %></td>
				<%	// 투표 주제
				boolean isS = poll.isVote();
				
				//투표했음			기간만료
				if(isS || PollUtil.isEnd(poll.geteDate())) {
				%>
				<td>[마감]<%=poll.getQuestion() %></td>
				<%
				} else {	// 투표를 안했으며, 기간이 아직 만료되지 않음
				%>
				<td>
					<a href="pollDetail.do?pollId=<%=poll.getPollId() %>"><%=poll.getQuestion() %></a>
				</td>
				<%	
				}
				%>
				
				<td>
				<%
				if(isS || PollUtil.isEnd(poll.geteDate())) {
				%>
					<a href="pollResult.do?pollI<%=poll.getPollId() %>">결과</a>
				<%	
				} else {
				%>
				<img alt="" src="image/pen.gif">
				<%	
				}
				%>
				</td>
				
				<td><%=poll.getsDate() %></td>
				<td><%=poll.geteDate() %></td>
				<td><%=poll.getItemCount() %></td>
				<td><%=poll.getPollTotal() %></td>
				<td><%=poll.getRegDate() %></td>
			</tr>
		<%
		}
		%>
	</table>

<% 
}
%>


<%
if(mem.getAuth() == 1) {
%>
<a href="pollMake.do">투표 만들기</a>
<%	
}
%>














