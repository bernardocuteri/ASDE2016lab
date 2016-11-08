<%@page import="it.unical.asde.businessLogic.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Public Chat</title>
<script src="resources/jquery-3.1.1.min.js"></script>
</head>
<body>
	<form name="myform" method="get" action="/PublicChat2/login">
		<%
			User usr = new User();
		%>
		<div>
			<em>User Name:</em><br> 
			<input type="text" name="nickName" placeholder="Enter nickname" required/><br>
			<button type="submit" >Login</button>
		</div>
	</form>
</body>
</html>