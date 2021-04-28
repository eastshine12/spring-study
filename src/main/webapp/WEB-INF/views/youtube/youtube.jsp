<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	String str = (String)request.getAttribute("yuList");
	if(str == null || str.equals("")) {
		str = "";
	}
%>

<script type="text/javascript">

$(function () {
	
	let str = '<%=str %>';
	//console.log(str);
	
	json = JSON.parse(str);
	//console.log(json);
	
	//JSON 키값으로 들어가서 데이터 가져온다
	let obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents[1].shelfRenderer.content.verticalListRenderer.items;
	   
	$.each(obj, function(i, item) {
		//console.log(item.videoRenderer.videoId);	// 동영상 고유ID		
		//console.log(item.videoRenderer.title.runs[0].text);	// 동영상 제목	
		
		let _title = item.videoRenderer.title.runs[0].text;
		_title = _title.replace('\"', '&quot;');
		
		let s = "<tr>"
				+ "<td>" + (i+1) + "</td>"
				+ "<td style='text-align:left'><a class='c_vname' vname='" + item.videoRenderer.videoId + "'>"
				+ _title + "</a></td>"
				+ "<td>" + item.videoRenderer.videoId + "</td>"
				+ "<td><img src='image/save.png' class='ck_seq' id='" +item.videoRenderer.videoId
				+ "' loginIn='${login.id}' title=\"" + _title + "\"></td>"
				+ "</tr>";
			
		$('#tbody').append(s);	
		
	})
	
	obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents;
	   $.each(obj, function (i, item) {
	      if(item.videoRenderer != undefined){
	    	 
	    	 let _title2 = item.videoRenderer.title.runs[0].text;
	    	 
	    	 _title2 = _title2.replace('\"', '&quot;');
	    	 
	    	// console.log(i +' '+ _title2);
	    	 
	    	  
	         let s = "<tr>"
	            + "<td>" + (i + 1) + "</td>"
	            + "<td style='text-align: left;'><a class='c_vname' vname='" + item.videoRenderer.videoId + "'>" + _title2 + "</a></td>"
	            + "<td>" + item.videoRenderer.videoId + "</td>"
	            + "<td><img src='image/save.png' class='ck_seq' id='" + item.videoRenderer.videoId + "'   loginIn='${login.id}' title=\"" + _title2 + "\"></td>"
	                + "</tr>";
	      
	         $("#tbody").append(s);
	      }
	});
	
});

</script>

<div class="box_order" style="margin-top: 5px; margin-bottom: 10px;">
	<form id="frmForm" action="" method="post">
		<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px;">
		<tr>
			<td>검색</td>
			<td style="padding-left: 5px;">
				<input type="text" id="_s_keyword" name="s_keyword" value="${empty s_keyword? '':s_keyword }">
			</td>
			<td style="padding-left: 5px;">
				<span class="button blue">
					<button type="button" id="_btnSearch">검색</button>
				</span>
			</td>
		</tr>
		</table>
	</form>
</div>


<div id="_youtube_">
	<iframe id="_youtube" width="640" height="360" src="http://www.youtube.com/embed/"
		frameborder="0" allowfullscreen>
	</iframe>
</div>

<table class="list_table" style="width: 85%">
	<colgroup>
		<col style="width:70px"><col style="width:auto"><col style="width:100px"><col style="width:30px">
	</colgroup>
	<thead>
		<tr>
			<th>번호</th><th>제목</th><th>유튜브 고유번호</th><th>저장</th>
		</tr>
	</thead>
	<tbody id="tbody">
	</tbody>
</table>


<script>

$('#_btnSearch').click(function () {
	
	$('#frmForm').attr("action", "youtube.do").submit();	
});


$(document).on("click", ".c_vname", function() {
	
	$('#_youtube').attr("src", "http://www.youtube.com/embed/"+ $(this).attr("vname"));
});


$(document).on("click", ".ck_seq", function() {
	let id = $(this).attr("loginIn");
	let title = $(this).attr("title");
	let url = $(this).attr("id");
	alert(title);
	$.ajax({
		url: "youtubeSave.do",
		type: "post",
		async: true,
		data: {
			"id":id,
			"title":title,
			"url":url
		},
		success:function(msg){
			
		},
		error:function(){
			alert('error');
		}
	});
	
})



</script>