
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 



<div align="center">
	<form action="calWriteAf.do" method="get">
	
		<table border="1">
			<col width="50"><col width="500">
				<tr>
					<th>ID</th>				
					<td>${login.id }<input type="hidden" name="id" value="${login.id }"> </td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" size="60" name="title">
					</td>
				</tr>
				<tr>
					<th>일정</th>
					<td>
					
						<!-- -------연도 선택------- -->
						<c:if test="${param.year != null }">
						<select id="year" name="year">
							<c:forEach begin="${param.year - 5 }" end="${param.year + 5 }" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>년
						</c:if>
						
						
						<!-- -------월 선택------- -->
						<c:if test="${param.month != null }">
						<select id="month" name="month">
							<c:forEach begin="1" end="12" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>월
						</c:if>
						
						
						<!-- -------일 선택------- -->
						<c:if test="${param.month != null }">
						<select id="day" name="day">
							<c:forEach begin="1" end="${maxDay }" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>일
						</c:if>	
						
						
						<!-- 시 선택------- -->
						<c:if test="${param.month != null }">
						<select id="hour" name="hour">
							<c:forEach begin="0" end="23" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>시
						</c:if>		
							
						
						<!-- 분 선택------- -->
						<c:if test="${param.month != null }">
						<select id="min" name="min">
							<c:forEach begin="0" end="59" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>분
						</c:if>		
						
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="20" cols="60" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<br><input type="submit" value="일정추가">
					</td>
				</tr>
		</table>
	</form>
</div>


<script type="text/javascript">

	let now = new Date();
	let hour = now.getHours();
	let minutes = now.getMinutes();
	let lastDay = (new Date(${param.year}, ${param.month}, 0)).getDate();
	
	
	$('#year, #month').on('change', function () {
		let selectYear = $('#year').val();
		let selectMonth = $('#month').val();
		let selectDay = $('#day').val();
		let lastDay = (new Date(selectYear, selectMonth, 0)).getDate();
		$('#day').empty();
		for(i = 0; i < lastDay; i++) {
			$('#day').append("<option value='"+(i+1)+"'>"+(i+1)+"</option>");
		}
		//연월 바뀔 때, 일수 고정
		$('#day > option[value="'+selectDay+'"]').attr('selected', true);
	})
	

	$('#year > option[value="${param.year}"]').attr('selected', true);
	$('#month > option[value="${param.month}"]').attr('selected', true);
	$('#day > option[value="${param.day}"]').attr('selected', true);
	$(`#hour > option[value=\${hour}]`).attr('selected', true);
	$(`#min > option[value=\${minutes}]`).attr('selected', true);


</script>
