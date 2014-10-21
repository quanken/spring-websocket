<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Chatroom App Using Spring 4 WebSocket</title>
    <script src="/js/sockjs-0.3.4.js"></script>
    <script src="/js/stomp.js"></script>
    <script type="text/javascript">
	
        var stompClient = null; 

        function setConnected() {
            document.getElementById('disconnect').disabled = false;
            document.getElementById('chatroomDiv').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/chat');
			stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected();
                console.log('Connected: ' + frame);
                stompClient.subscribe('/chat/chatroom', function(chatResult){
                	showResult(JSON.parse(chatResult.body));
                    var chat_input = document.getElementById("chat_input");
                    chat_input.value = "";
                    chat_input.focus();
                }, {id:'<%=session.getAttribute("username")%>'});
            });
        }

        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }

        function send() {
            var word = document.getElementById('chat_input').value;
            stompClient.send("/chatroom/chat", {}, JSON.stringify({ 'content': word,
                'personName': '<%=session.getAttribute("username")%>' , 'time': new Date()}));
        }

        function showResult(message) {
            var response = document.getElementById('chatroomDiv');
            var p_who = document.createElement('p');
            p_who.style.wordWrap = 'break-word';
            var date = new Date(message.time);
            p_who.appendChild(document.createTextNode(message.personName + "  "
                    + date.getHours() + ":" + date.getMinutes() ));
            var p_what = document.createElement('p');
            p_what.style.wordWrap = 'break-word';
            p_what.appendChild(document.createTextNode("    " + message.content));
            response.appendChild(p_who);
            response.appendChild(p_what);
        }

    </script>
</head>
<body onload="connect()">
<noscript><h2>Enable Java script and reload this page to run Spring Websocket Demo</h2></noscript>
<h1>Chatroom App Using Spring 4 WebSocket</h1>
<div>
    <div>
        Welcome <%=session.getAttribute("username")%> !
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button><br/><br/>
    </div>
    <div id="chatroomDiv" width="100%" height="400px">
    </div>
    <div id="chatArea">
        <input id="chat_input" type="text"/> <input type="button" value="send" onclick="send()"/>
    </div>
</div>
</body>
</html>