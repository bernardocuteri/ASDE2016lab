<%@page import="test.asde.model.ChatBean"%>
<%@page import="test.asde.model.PairS"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/resources/libs/jquery-ui-custom/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery-ui-custom/external/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery-ui-custom/jquery-ui.min.js"></script>


	<script>
		$(document).ready(function() 
		{
			$("#login").button();
			$("#send").button();
		});
	</script>

<title>Chat Test</title>

</head>

<body>

<h1>Chat test - ASDE 2016</h1>

	<% 
	if((String)session.getAttribute("username") == null)
	{ %>
	
		<form method="POST">
		<input id="userinput" name="username" placeholder="Enter your username"/> 
		<br><br>
		<button id="login" type="submit">Login</button>
		</form>
		
	<%}
	else{%>
		
		<h2>Welcome ${username}</h2>
		
		<div id="messageDiv">
		
		<%ChatBean chat = (ChatBean)session.getAttribute("chatBean");
		
		for(PairS s: chat.getMessages())
		{
			out.print("<label class=\"userLab\" for="+ s.getUser() +">" + s.getUser() + ": </label>");
			out.print("<label for="+ s.getMessage() +">" + s.getMessage() + " </label>");
			out.print("<br>");
		}		
	%>
		</div>
	
		<br>
		<form method="POST">
		
		<textarea rows="4" cols="50" name="message" placeholder="Put your text here"></textarea>
		<br><br>
		<button id="send" type="submit">Send</button>
		</form>
	<%} %>

</body>
</html>