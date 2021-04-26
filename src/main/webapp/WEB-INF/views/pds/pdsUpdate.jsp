<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<form name="frmForm" id="_frmForm" action="pdsUpdateAf.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${pds.seq }">
	<table class="list_table">
		<tr>
			<th>아이디</th>
			<td style="text-align: left;">
				<input type="text" name="id" readonly="readonly" value="${login.id }" size="50">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td style="text-align: left;">
				<input type="text" name="title" value="${pds.title }" size="50">
			</td>
		</tr>
		<tr>
			<th>파일 업로드</th>
			<td style="text-align: left;">
				${pds.filename}&emsp;
				<input type="file" name="fileload" style="width: 400px">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="50" name="content">${pds.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="height: 50px; text-align: center;">
				<input type="button" id="updateBtn" value="수정하기">
			</td>
		</tr>
	</table>
</form>


<script>

$('#updateBtn').click(function() {
	
	// 제목, 내용 조건 검사 추가
	
	$('#_frmForm').submit();
	
});

</script>

