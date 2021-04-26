<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
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
				<input type="text" name="title" readonly="readonly" value="${pds.title }" size="50">
			</td>
		</tr>
		<tr>
			<th>파일</th>
			<td style="text-align: left;">
				<img alt="" src="./upload/${pds.newFilename }">
				${pds.filename}&emsp;
				<input type="button" name="btnDown" value="다운로드" onclick="fileDown('${pds.newFilename}','${pds.seq }')">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="50" name="content" readonly="readonly">${pds.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="height: 50px; text-align: center;">
				<input type="button" id="updateBtn" value="수정" onclick="updatePage()">
				<input type="button" id="deleteBtn" value="삭제" onclick="deletePage()">
			</td>
		</tr>
	</table>



<!-- 다운로드 버튼 클릭 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="newFilename">
	<input type="hidden" name="seq">
</form>


<script>


/* hidden form을 만들어 POST 방식으로 전달할 수 있다. (JS는 기본적으로 GET방식만 가능하기 때문)*/
function fileDown(newFilename, seq) {
	let doc = document.file_Down;
	doc.newFilename.value = newFilename;
	doc.seq.value = seq;
	doc.submit();
}	

function updatePage() {
	location.href="pdsUpdate.do?seq=${pds.seq}";
}



function deletePage() {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		 location.href="pdsDelete.do?seq=${pds.seq}";
	 }else{   //취소
	     return false;
	 }
}




</script>

