<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Calendar cal = Calendar.getInstance();
int tYear = cal.get(Calendar.YEAR);
int tMonth = cal.get(Calendar.MONTH)+1;
int tDay = cal.get(Calendar.DATE);
%>
    

<form action="pollMakeAf.do" method="post">
	<table class="list_table" style="width: 85%">
		<colgroup>
			 <col width="200px"><col width="200px">
		</colgroup>
		<tr>
			<th>아이디</th>
			<td style="text-align: left;">
				${login.id}<input type="hidden" name="id" value="${login.id }">
			</td>
		</tr>
		<tr>
			<th>투표기한</th>
			<td style="text-align: left;">
				<select name="sYear">
					<%
					for(int i = tYear; i < tYear + 6; i++) {
					%>
					<option <%=(tYear+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>	
					<%
					}
					%>
				</select>년
				<select name="sMonth">
					<%
					for(int i = 1; i <= 12; i++) {
					%>
					<option <%=(tMonth+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>	
					<%
					}
					%>
				</select>월
				<select name="sDay">
					<%
					for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
					%>
					<option <%=(tDay+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>	
					<%
					}
					%>
				</select>일
				~
				<select name="eYear">
					<%
					for(int i = tYear; i < tYear + 6; i++) {
					%>
					<option <%=(tYear+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>	
					<%
					}
					%>
				</select>년
				<select name="eMonth">
					<%
					for(int i = 1; i <= 12; i++) {
					%>
					<option <%=(tMonth+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>	
					<%
					}
					%>
				</select>월
				<select name="eDay">
					<%
					for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
					%>
					<option <%=(tDay+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>	
					<%
					}
					%>
				</select>일
			</td>
		</tr>
		<tr>
			<th>투표내용</th>
			<td style="text-align: left;">
				<textarea rows="10" cols="50" name="question"></textarea>
			</td>
		</tr> 
		<tr>
			<th>투표 문항수</th>
			<td style="text-align: left;">
				<select name="itemCount" onchange="pollChange(this)">
					<%
					for(int i = 2; i <= 20; i++) {
					%>
					<option <%= (4+"").equals(i+"")? "selected='selected'":"" %> value="<%=i %>" ><%=i %></option>
					<%	
					}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<th>투표 상세 문항</th>
			<td style="text-align: left;">
			<%
			for(int i = 1; i <=20; i++) {
			%>
			<div id='poll<%=i %>'>
				<%=(i+"") %>번:<input type="text" name="poll<%=i %>" size="60">
			</div>
			<%	
			}
			%>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="투표만들기">
			</td>
		</tr>		
	</table>
</form>


<script>
$(document).ready(function() {
	
	/* 항목들 초기화 */
	for(i = 5; i <= 20; i++) {
		$('#poll'+i).hide();
	}
	
	
});


function pollChange(sel) {
	
	let val = sel.options[sel.selectedIndex].value;	// selected 선택한값 반환
	console.log(val);
	
	for(i = 1; i <= 20; i++) {
		$('#poll'+i).val("");
		$('#poll'+i).hide();
	}
	
	//설정 값만큼 보여준다.
	for(i = 1; i <= val; i++) {
		$('#poll'+i).show();
	}
	
}


</script>