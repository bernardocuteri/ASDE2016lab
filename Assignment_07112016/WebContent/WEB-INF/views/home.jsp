<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.unical.assignment.logic.Message"%>
<%@page import="it.unical.assignment.logic.ChatLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Chat4all</h1>
		<p>by Werner Robert Kapferer</p>
	</div>

	<div class="panel panel-default">


		<c:if test="${(!chatLogic.isLoggedIn)}">
			<div class="panel-heading">
				<div class="alert alert-danger">You need to log-in with a
					nickname before proceeding!</div>
			</div>
			<div class="panel-body">
				<form method="post">
					<div class="form-group">
						<label for="username">Nickname:</label> <input
							class="form-control" name="nick"></input>
					</div>
					<button type="submit" class="btn btn-default">Login</button>
				</form>
			</div>
		</c:if>

		<c:if test="${(chatLogic.isLoggedIn)}">
			<div class="panel-heading">
				<div class="alert alert-success">
					<strong>Welcome!</strong> You are logged in as <strong> <%
 	ChatLogic cl = (ChatLogic) session.getAttribute("chatLogic");
 		out.print(cl.getNickname());
 %>
					</strong>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<col width="75">
					<col width="75">
					<tbody>
						<%
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
								int msgCount = cl.getMessages().size();
								for (int i = (msgCount > 20 ? msgCount - 20 : 0); i < msgCount; i++) {
									out.println("<tr>");
									out.println("<td>");
									out.print(sdf.format(cl.getMessages().get(i).getTime()));
									out.println("</td>");
									out.println("<td><strong>");
									out.print(cl.getMessages().get(i).getUser());
									out.println("</strong></td>");
									out.println("<td>");
									out.print(cl.getMessages().get(i).getText());
									out.println("</td>");
									out.println("</tr>");

								}
						%>
					</tbody>
				</table>
			</div>
			<div class="panel-footer">

				<form method="post" action="message">
					<div class="form-group">
						<label for="message">Message:</label>
						<textarea id="message" class="form-control" rows="2"
							name="message"></textarea>
					</div>
					<button type="submit" class="btn btn-default">Send</button>
				</form>
			</div>
		</c:if>

	</div>
</body>
</html>