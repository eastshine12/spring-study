<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
request.setCharacterEncoding("utf-8");

Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;

BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>


<div align="center">
<form action="bbsUpdateAf.do" method="post">
	<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
	<table class="table" border ="1" >
		<tr>
			<th>아이디</th>
			<td style="padding-left: 10px"><%=bbs.getId() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
			<input type="text" size="50" id="_title" name="title"
			value="<%=bbs.getTitle() %>" >
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea rows="20" cols="100" id="_content" name="content"><%=bbs.getContent() %></textarea>
			</td>
		</tr>
	
	</table>
	<br><br>
<input type="submit" id="updateBtn" class="btn btn-primary" value="글수정">
<input type="button" value="취소" class="btn btn-secondary" onclick="backPage()">
</form>
</div>

<script type="text/javascript">

function backPage() {
	location.href = "bbsDetail.do?seq="+<%=bbs.getSeq() %>;
}

</script>
