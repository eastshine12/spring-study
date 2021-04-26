<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
MemberDto mem = (MemberDto)session.getAttribute("login");
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>    
    
    

<div align="center">
	<form action="answerAf.do" method="post">
	<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
	<table border="1">
		<col width="200"><col width="500">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" size="50" readonly="readonly"
					value="<%=mem.getId() %>">
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="title" size="50">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="50" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="답글작성완료">
			</td>
		</tr>
	</table>
	</form>
</div>





