
<%@page import="bit.com.a.dto.CalParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<div align="center">
	<form action="calUpdateAf.do" method="get">
	<input type="hidden" name="seq" value="${cal.seq }">
	
<table border="1">
			<col width="50"><col width="500">
				<tr>
					<th>ID</th>				
					<td>${login.id }<input type="hidden" name="id" value="${login.id }"> </td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" size="60" name="title" value="${cal.title }">
					</td>
				</tr>
				<tr>
					<th>일정</th>
					<td>
					
					
						<!-- -------연도 선택------- -->
						<c:if test="${param1.year != null }">
						<select id="year" name="year">
							<c:forEach begin="${param1.year - 5 }" end="${param1.year + 5 }" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>년
						</c:if>
						
						
						<!-- -------월 선택------- -->
						<c:if test="${param1.month != null }">
						<select id="month" name="month">
							<c:forEach begin="1" end="12" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>월
						</c:if>
						
						
						<!-- -------일 선택------- -->
						<select id="day" name="day">
							<c:forEach begin="1" end="${maxDay }" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>일
						
						
						<!-- 시 선택------- -->
						<c:if test="${param1.hour != null }">
						<select id="hour" name="hour">
							<c:forEach begin="0" end="23" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>시
						</c:if>		
							
						
						<!-- 분 선택------- -->
						<c:if test="${param1.min != null }">
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
						<textarea rows="20" cols="60" name="content">${cal.content }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<br><input type="submit" value="수정">
					</td>
				</tr>
		</table>
	</form>
</div>

<script type="text/javascript">

function goBack() {
	location.href = "callist.do";
}

let now = new Date();


/* 앞에 0 없애는 정규식 */
let year = '${param1.year}';
let month = '${param1.month}'.replace(/(^0+)/, "");
let day = '${param1.day}'.replace(/(^0+)/, "");
let hour = '${param1.hour}'.replace(/(^0+)/, "");
let min = '${param1.min}'.replace(/(^0+)/, "");



/* 년, 월에 맞게 일수 조정 */
$('#year, #month').on('change', function () {
	let selectYear = $('#year').val();
	let selectMonth = $('#month').val();
	let selectDay = $('#day').val();
	//마지막날
	let lastDay = (new Date(selectYear, selectMonth, 0)).getDate();
	//option 초기화
	$('#day').empty();
	//option 뿌리기
	for(i = 0; i < lastDay; i++) {
		$('#day').append("<option value='"+(i+1)+"'>"+(i+1)+"</option>");
	}
	//연월 바뀔 때, 일수 고정
	$('#day > option[value="'+selectDay+'"]').attr('selected', true);
})


/* select option 기본값 selected 세팅 */
$('#year > option[value="${param1.year}"]').attr('selected', true);
$('#month > option[value="'+month+'"]').attr('selected', true);
$('#day > option[value="'+day+'"]').attr('selected', true);
$('#hour > option[value="'+hour+'"]').attr('selected', true);
$('#min > option[value="'+min+'"]').attr('selected', true);



</script>
