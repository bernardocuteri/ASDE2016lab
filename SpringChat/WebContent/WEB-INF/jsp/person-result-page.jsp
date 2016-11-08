<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Result page</title></head>
<body >
<div style="float:left; width:100%; height:10%;">
	<h1>Hello ${personObj.name},</h1>
</div>
<div style="float:left; background-color:#ccc; width:100%; height:70%;">
<c:forEach items = "${chats}" var="contact">
            <c:out value="${contact.firstName}"/>,
            <c:out value="${contact.lastName}"/>
     </c:forEach>
</div>
<div style="float:left;background-color:#000;width:100%; height:20%;">
	<form action="/chat">
		<table style="width:100%">
		    <tr>
		        <td><textarea rows="5" style="width:100%" ></textarea></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		        <td></td>
		        <td></td>
		    </tr>
		</table> 
	</form>
</div>

</body>
</html>