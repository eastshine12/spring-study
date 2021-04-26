<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="bit.com.a.dao.BbsDao"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;

BbsDto bbs = (BbsDto)request.getAttribute("bbs");
//dao.readcount(seq);

%>
    

<div align="center">
	<table class="table table-bordered" border ="1" >
		<col width="100px"><col width="500px">
		<tr>
			<th>ID</th>
			<td style="padding-left: 10px"><%=bbs.getId() %></td>
		</tr>
		<tr>
			<th>작성날짜</th>
			<td style="padding-left: 10px"><%=bbs.getWdate() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td style="padding-left: 10px"><%=bbs.getTitle() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td style="padding-left: 10px"><%=bbs.getReadcount() %></td>
		</tr>
		<tr>
			<th>정보</th>
			<td style="padding-left: 10px"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea rows="20" cols="100" name="content" readonly><%=bbs.getContent() %></textarea>
			</td>
		</tr>
	
	</table>
	<br><br>
<%if (mem.getId().equals(bbs.getId())) { %>	
	<button type="button" id="repleBtn" class="btn btn-secondary" onclick="answerbbs('<%=bbs.getSeq() %>')">답글</button>
	<input type="button" id="delBtn" class="btn btn-secondary" value="글삭제" onclick="deletePage()">
	<input type="button" id="updateBtn" class="btn btn-secondary" value="글수정" onclick="goUpdate()">
	<input type="button" class="btn btn-secondary" value="글목록" onclick="goList()">
<% } else { %>
	<button type="button" class="btn btn-secondary" onclick="answerbbs('<%=bbs.getSeq() %>')">답글</button>
	<input type="button" class="btn btn-secondary" value="글목록" onclick="goList()">
<% } %>
	
</div>


<script type="text/javascript">

function deletePage() {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		 location.href="delete.do?seq=<%=bbs.getSeq()%>";
	 }else{   //취소
	     return false;
	 }
}

function goUpdate() {
	location.href = "bbsUpdate.do?seq="+<%=bbs.getSeq() %>;
}


function goList() {
	location.href = "bbslist.do";
}


function answerbbs(seq) {
	location.href = "answer.do?seq=" + seq;
}

</script>

