<%@page import="bit.com.a.poll.PollSubDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- https://codepen.io/pen/ '하이차트' -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

    
<%
	List<PollSubDto> list = (List<PollSubDto>)request.getAttribute("pollSubList");
	
	String jsonData = "[";
	for(PollSubDto p : list) {
		jsonData += "{name:'" +p.getAnswer()+ "', y:" +p.getaCount()+ "}, ";
	}
	jsonData = jsonData.substring(0, jsonData.length()-1);
	jsonData += "]";
	System.out.println(jsonData);
	
	request.setAttribute("jsonData", jsonData);

%>  


<table class="list_table" style="width: 95%">
	<colgroup>
		<col width="200px"><col width="500px">
	</colgroup>
	<tr>
		<th>투표번호</th>
		<td style="text-align: left;">
			<input type="text" value="${poll.pollId }" size="50" readonly="readonly">
		</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td style="text-align: left;">
			<input type="text" value="${login.id }" size="50" readonly="readonly">
		</td>
	</tr>
	<tr>
		<th>투표기한</th>
		<td style="text-align: left;">
			${poll.sDate } ~ ${poll.eDate }
		</td>
	</tr>
	<tr>
		<th>투표내용</th>
		<td style="text-align: left;">
			<textarea rows="10" cols="50" readonly="readonly">${poll.question }</textarea>
		</td>
	</tr>
	<tr>
		<th>투표결과</th>
		<td>
			<figure class="highcharts-figure">
			  <div id="container"></div>
			</figure>
		</td>
	</tr>



</table> 

<script type="text/javascript">

Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '투표 결과'
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  accessibility: {
	    point: {
	      valueSuffix: '%'
	    }
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: '투표율',
	    colorByPoint: true,
	    data: <%=jsonData %>
	  }]
	});
	
</script> 