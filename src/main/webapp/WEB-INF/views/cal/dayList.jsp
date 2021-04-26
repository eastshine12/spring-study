<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<br><br>
<h2>${param2.year }년 ${param2.month }월 ${param2.day }일 일정</h2>
<br>
<div align="center">
	<form action="calwriteAf.jsp" method="post">
	
		<table class="table table-bordered" border="1">
			<col width="200"><col width="200"><col width="500">
				<tr>
					<th>시간</th>				
					<th>제목</th>				
					<th>내용</th>				
				</tr>
				
				<c:forEach var="list" items="${dayList }">
					<tr>
						<td>${fn:substring(list.rdate,8,10) }시 ${fn:substring(list.rdate,10,12) }분</td>
						<td><a href="calDetail.do?seq=${list.seq }">${list.title }</a></td>
						<td>${list.content }</td>	
					</tr>
				</c:forEach>
				
		</table>
	</form>
</div>


<input type="button" value="뒤로" onclick="goBack()">


<script type="text/javascript">

function goBack() {
	location.href = "callist.do";
}

</script>