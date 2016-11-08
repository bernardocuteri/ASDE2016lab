<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/home.css">
<link rel="stylesheet"
	href="resources/script/jquery-ui-1.12.1.dark/jquery-ui.min.css">
<script
	src="resources/script/jquery-ui-1.12.1.dark/external/jquery/jquery.js"></script>
<script src="resources/script/jquery-ui-1.12.1.dark/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$("#log").button();

	});
</script>
 
<title>Public chat</title>
</head>
<body>
<form method="post">
<div id="wrapper">
		<div id="header"></div>
    <input type="text" placeholder="Enter Username" name="username" required>
    <button id="log" type="submit" >Login</button>
</form>

</div>
</body>
</html>