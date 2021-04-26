<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="bit.com.a.dto.BbsParam"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
request.setCharacterEncoding("utf-8");
Object ologin = session.getAttribute("login");	//로그인 되어있는 유저 dto
MemberDto mem = null;
if(ologin == null) { 	//로그인이 안되어있으면
	%>
	<script>
	
	alert("로그인 해 주십시오");
	location.href = "login.do";
	
	</script>
	
<%	
}
mem = (MemberDto)ologin;	//로그인이 되면 MemberDto에 유저dto 담기
%>


<jsp:useBean id="arw" class="util.Arrow"/>



<!-- 검색 -->
<div class="row" style="float: right;">
	<select name="choice" id="_choice" class="form-control"  style="width: 100px">
		<option value="" selected="selected">선택</option>	
		<option value="TITLE">제목</option>
		<option value="CONTENT">내용</option>
		<option value="ID">작성자</option>
	</select>&nbsp;
	
	<div class="col-xs-3">
 	<input type="search" class="form-control" name="search" id="_search">
	</div>&nbsp;
	<input type="button" value="검색" class="btn btn-primary" id="btnSearch">

</div>
<br><br>


<table class="table table-hover" id="_list_table" style="width: 1000px">
	<colgroup>
		<col style="width:70px">
		<col style="width:auto">
		<col style="width:100px">
	</colgroup>	
	
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th>
	</tr>
	
</table>
 
 
 
<!-- Pagination -->
<div class="container">
	<nav aria-label="Page navigation">
		<ul class="pagination" id="pagination" style="justify-content:center;"></ul>
	</nav>
</div>
 
 


<!-- 글쓰기, 목록보기 버튼 -->
<br><br>

<div class="row text-center" style="width:100%">
	<div style="width: 30%; float: none; margin: 0 auto">
		<input type="button" class="btn btn-secondary" value="글쓰기" onclick="goWrite()">
		<input type="button" class="btn btn-secondary" value="전체목록" onclick="goMain()">
	</div>	
</div>




<script>


getbbsListData(0);
getBbsListCount();


$(document).on("click", "#btnSearch", function () {
	
	getbbsListData(0);
	getBbsListCount();
});


// bbslist를 취득
function getbbsListData(pNumber) {
	
	$.ajax({
		url:"./bbslistData.do",
		type:"get",
		data:{
			choice:$('#_choice').val(),
			search:$('#_search').val(),
			page:pNumber
		},
		success:function(list){
			//alert('success');
			
			$('.list_col').remove();
			
			let app = ""
		 	
			if (Object.keys(list).length == 0) {	// JSON형식의 길이
			
				app += "<tr class='list_col'>"
				       +"<td colspan='3'>검색 결과가 없습니다.</td>"
				       + "</tr>";
				       
				$("#_list_table").append(app);
				
			} else {
				
				$.each(list, function (i, val) {
			
					app += "<tr class='list_col'>"
								+ "<td>" + (i + 1) + "</td>"
								+ "<td style='text-align:left'>"
								+ getArrow(val.depth)
								+ " <a href='bbsDetail.do?seq=" + val.seq + "'>" + val.title + "</a>"
								+ "</td>"
								+ "<td>" + val.id + "</td>"
								+ "</tr>";
								
				}); 
					
				$("#_list_table").append(app);
			}
			
		},
		error:function(){
			alert('error');
		}
	});
};



// 글의 총수를 취득
function getBbsListCount() {
	
 	$.ajax({
		url:"./bbslistCount.do",
		type:"get",
		data:{
			choice:$('#_choice').val(),
			search:$('#_search').val(),
			page:0
		},
		success:function(count){
			bbsCount = count;
			loadPage(count);
		},
		error:function(){
			alert('error');
		}
	}); 
	
};

// paging 처리
function loadPage(totalCount) {
	
	let pageSize = 10;
	let nowPage = 1;
	let _totalPages = Math.floor(totalCount / pageSize);
	if(totalCount % pageSize > 0){
		_totalPages++;
	}

	$("#pagination").twbsPagination('destroy');	// 데이터가 갱신되면 페이징 갱신
	
	
 	$("#pagination").twbsPagination({
	//	startPage: 1,
		totalPages: _totalPages,
		visiblePages: 10,
		first:'<span aria-hidden="true">«</span>',
		prev:"이전",
		next:"다음",
		last:'<span aria-hidden="true">»</span>',
		initiateStartPageClick:false,		// onPageClick 자동 실행되지 않도록 한다
		onPageClick:function(event, page){
			nowPage = page;
			getbbsListData( page - 1 );
		},
	});	
 	
 	//$("#pagination").twbsPagination('changeTotalPages', _totalPages, nowPage);
	
};


function goWrite() {
	location.href = "bbsWrite.do";
};

function goMain() {
	location.href = "bbslist.do";
};



function getArrow(depth) {
	
	var rs = "<img src='./image/arrow.png' width='12px' heiht='12px'/>";
	var nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";	// 여백
	
	var ts = "";
	for(var i = 0;i < depth; i++){
		ts += nbsp;
	}
	
	return depth==0?"":ts + rs;	
};





</script>
