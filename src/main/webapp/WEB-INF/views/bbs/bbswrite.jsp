<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;
%>

<!-- 글을 작성 -->
<br>
<h2 align="center">글 작성</h2>
<br>
<div align="center">
<form action="bbsWriteAf.do">
	<table class="table table-bordered" border ="1" >
		<tr>
			<th>아이디</th>
			<td style="padding-left: 10px"><%=mem.getId() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
			<input type="text" size="50" id="_title" name="title">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea rows="20" cols="100" id="_content" name="content"></textarea>
			</td>
		</tr>
	
	</table>
	<br><br>
<input type="submit" id="btn" class="btn btn-primary" value="글추가">
<input type="button" class="btn btn-secondary" value="뒤로" onclick="backPage()">
</form>
</div>

<script type="text/javascript">
function backPage() {
	location.href = "bbslist.do";
}
</script>
