<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%--

int year = Integer.parseInt(dto.getRdate().substring(0, 4));
int month = Integer.parseInt(dto.getRdate().substring(4, 6));
int day = Integer.parseInt(dto.getRdate().substring(6, 8));
int hour = Integer.parseInt(dto.getRdate().substring(8, 10));
int min = Integer.parseInt(dto.getRdate().substring(10, 12));

--%>    

<div align="center">
	<form action="calwriteAf.jsp" method="post">
	
		<table class="table table-bordered" border="1">
			<col width="200"><col width="500">
				<tr>
					<th>ID</th>		
					
					<td><input type="hidden" name="id" value="">${cal.id }</td>
				</tr>
				<tr>
					<th>스케줄 날짜</th>				
					<td><input type="text" id="rdate" name="rdate" readonly="readonly" size="50"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" size="60" name="title" value="${cal.title } " readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="20" cols="60" name="content" readonly="readonly">${cal.content }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="일정삭제" onclick="deleteCal()">
						<input type="button" value="일정수정" onclick="updateCal()">
						<input type="button" value="뒤로" onclick="goBack()">
					</td>
				</tr>
		</table>
	</form>
</div>


<script type="text/javascript">

function deleteCal() {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		 location.href = "calDelete.do?seq=${cal.seq}";
	 }else{   //취소
	     return false;
	 }
}


function updateCal() {
	location.href = "calUpdate.do?seq=${cal.seq}";
}


function goBack() {
	location.href = "callist.do";
}


let year = '${cal.rdate}'.substring(0, 4);
let month = '${cal.rdate}'.substring(4, 6);
let day = '${cal.rdate}'.substring(6, 8);
let hour = '${cal.rdate}'.substring(8, 10);
let min = '${cal.rdate}'.substring(10, 12);


document.getElementById("rdate").value = `\${year}년 \${month}월 \${day}일 \${hour}시 \${min}분`;

</script>

