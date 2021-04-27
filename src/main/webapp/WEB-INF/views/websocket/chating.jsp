<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table class="list_table" style="width: 85%">
	<colgroup>
		<col width="200px"><col width="500px">
	</colgroup>
	<tr>
		<th>채팅명</th>
		<td style="text-align: left;">
			<input type="text" id="name"> 
			<input type="button" id="enterBtn" value="입장" onclick="connect()">
			<input type="button" id="exitBtn" value="나가기" onclick="disconnect()">
		</td>
	</tr>
	
	<tr>
		<th>아이디</th>
		<td style="text-align: left;">
			<input type="text" id="id" value="${login.id }" readonly="readonly">
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<textarea rows="10" cols="70" id="messageArea"></textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="text" id="message" size="50">
			<input type="button" id="sendBtn" value="전송" onclick="send()">
		</td>
	</tr>
	
	
</table>


<script>

	let wSocket;
	
	// 접속	
	function connect() {
		
		if(wSocket != undefined && wSocket.readyState != WebSocket.CLOSED) {
			alert('이미 입장하셨습니다.');
			return;
		}
		
		//WebSocket 생성
		wSocket = new WebSocket("ws://192.168.0.231:8090/sample10/echo.do");
		
		
		wSocket.onopen = onOpen;
		wSocket.onmessage = onMessage;
		wSocket.close = onClose;
		
		
	}
	
	// 접속을 중단
	function disconnect() {
		wSocket.close();
		location.href = "chating.do";
	}
	
	// 연결이 되었을 때
	function onOpen(evt) {
		appendMessage("연결되었습니다.");
		
	}
	
	//수신이 되었을 때
	function onMessage(evt) {
		let data = evt.data;
		if(data.substring(0, 4) == "msg:") {
			appendMessage(data.substring(4));
		}
	}
	
	// 끊겼을 때
	function onClose() {
		appendMessage("연결이 끊겼습니다.");
	}
	
	// 메시지 송신
	function send() {
		let id = $('#id').val();
		let msg = $('#message').val();
		
		wSocket.send("msg:"+id+":"+msg);
		$("#message").val("");
	}
	
	// 추가 문자열을 기입
	function appendMessage(msg) {
		//메시지를 추가 하고 개행
		$("#messageArea").append(msg+"\n");
		
		// 스크롤을 위로 이동 시킨다
		const top = $('#messageArea').prop("scrollHeight");
		
		$("#messageArea").scrollTop(top);
		
	}
	


</script>