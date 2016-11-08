<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Public Chat</title>
</head>
<body>
	<form action="/PublicChat2/login" method="GET">
		<table>
			<tr>
				<td>Welcome: ${user.getName()}</td>
			</tr>
			<tr>
				<td>Public Chat:</td>
				<td>${chat.getMsgs().get(0) }</td>
			</tr>
			<tr>
				<td><input type="text" name="comment"></td>
			</tr>
			<tr>
				<td><button type="submit">Send</button></td>
			</tr>
		</table>
	</form>
</body>
</html>