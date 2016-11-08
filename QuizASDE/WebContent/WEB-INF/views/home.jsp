<%@page import="it.unical.quizasde.logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="resources/script/jquery-ui-1.12.1.dark/jquery-ui.min.css">
<script
	src="resources/script/jquery-ui-1.12.1.dark/external/jquery/jquery.js"></script>
<script src="resources/script/jquery-ui-1.12.1.dark/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/home.css">
<script>
	$(document).ready(function() {
		$("#content button").button();
		$("#small-large").click(function() {
			$("#content img").toggleClass("imagessmall");
		});
		$("#content table").table();
	});
</script>
<title>Dr. Override's Chat</title>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="content">
		
		<%
				Chat chat = (Chat) session.getAttribute("chat");
				String nickname = (String) session.getAttribute("nickname");
				if (nickname == null) {
			%>
			<form method="post">
					<input id="nickname" title="Insert nickname" name="nickname"
						class="text">
						<button class="button" type="submit" name="login">Login</button>
			</form>
			<%} else {%>
			<p class="welcome">Welcome ${nickname}</p>
			<img src="resources/images/<%out.print(nickname);%>Img.jpg" class="images">
			<button id="small-large" class="button">Change Avatar Size</button>
			<p class="chatparag">PUBLIC CHAT</p>
			<table style="font-family:Palatino Linotype">
			
<%
for(int i = 0; i < chat.getMessages().size() && i < 20; i++) {
%>
	<tr><th><%out.print(chat.getMessages().get(i).getUser());%></th><td><% out.print(chat.getMessages().get(i).getText()); %></td></tr>
<%
}
%>
			</table>
			<form method="post">
				<div>
					<input id="message" title="Insert sender name" name="message"
						class="text">
				</div>
				<button class="button" type="submit" name="sendMessage">Send</button>
			</form>
			
			<%} %>
		</div>

		<div id="footer">Agile Software Development for the Enterprise -
			Department of Mathematics and Computer Science - University of
			Calabria - Arcavacata di Rende (CS) - Italy</div>
	</div>
</body>
</html>