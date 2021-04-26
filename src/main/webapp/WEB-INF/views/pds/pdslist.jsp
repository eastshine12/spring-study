<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<table class="list_table" style="width:85%">
	<colgroup>
		<col width="50">
		<col width="100">
		<col width="300">
		<col width="50">
		<col width="50">
		<col width="50">
		<col width="100">
		<col width="50">
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>다운로드</th>
			<th>조회수</th>
			<th>다운로드수</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach var="pds" items="${pdslist }" varStatus="i">
			<tr>
				<th>${i.count }</th>
				<td>${pds.id }</td>
				<td style="text-align: left;"><a href="pdsDetail.do?seq=${pds.seq}">${pds.title }</a></td>
				<td><input type="button" name="btnDown" value="다운로드" onclick="fileDown('${pds.newFilename}','${pds.seq }')"></td>
				<td>${pds.readcount }</td>
				<td>${pds.downcount }</td>
				<td><font size="1">${pds.regdate }</font></td>
				<td><img alt="" src="image/del.png" data_file_seq="${pds.seq }" class="btn_fileDelete" onclick="deletePage(${pds.seq })"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<div id="button.wrap">
	<span class="button blue">
		<button type="button" id="_btnAdd">자료추가</button>
	</span>
</div>



<!-- 다운로드 버튼 클릭 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="newFilename">
	<input type="hidden" name="seq">
</form>


<script>

	$('#_btnAdd').click(function() {
		location.href = "pdsWrite.do";
	});
	

/* hidden form을 만들어 POST 방식으로 전달할 수 있다. (JS는 기본적으로 GET방식만 가능하기 때문)*/
function fileDown(newFilename, seq) {
	let doc = document.file_Down;
	doc.newFilename.value = newFilename;
	doc.seq.value = seq;
	doc.submit();
}	
	
	
function deletePage(seq) {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		 location.href="pdsDelete.do?seq="+seq;
	 }else{   //취소
	     return false;
	 }
}	

	
</script>