<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="polling.do" method="post">
	<table class="list_table" style="width: 95%">
		<colgroup>
			<col width="200px">
			<col width="500px">
		</colgroup>
		<tr>
			<th>투표번호</th>
			<td style="text-align: left;">
				<input type="text" name="pollId" value="${poll.pollId }" size="50" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td style="text-align: left;">
				<input type="text" name="id" value="${login.id}" size="50" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>투표기한</th>
			<td style="text-align: left;">
				${poll.sDate} ~ ${poll.eDate}
			</td>
		</tr>
		<tr>
			<th>투표내용</th>
			<td style="text-align: left;">
				<textarea rows="10" cols="50" name="question" readonly="readonly">${poll.question}</textarea>
			</td>
		</tr>
		<tr>
			<th>보기 개수</th>
			<td style="text-align: left;">
				${poll.itemCount }
			</td>
		</tr>
		<tr>
			<th>보기</th>
			<td style="text-align: left;">
				<c:forEach items="${pollSubList }" var="pSub" varStatus="i">
				${i.count }번
				<input type="radio" name="pollSubId" ${i.count==1?"checked='checked'":"" } value="${pSub.pollSubId }">
				<input type="text" name="answer" size="60" value="${pSub.answer }" readonly="readonly">
				<br>
				</c:forEach>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="투표하기">
			</td>
		</tr>
	</table>
</form>


