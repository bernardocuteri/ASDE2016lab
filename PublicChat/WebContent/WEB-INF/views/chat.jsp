<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>public chat</title>
</head>
<body>
<h1>
	Chat  
</h1>
        <%
            String jspPath = session.getServletContext().getRealPath("/resources");
            String txtFilePath = jspPath+ "/messages.txt";
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine())!= null){
                sb.append(line+"\n");
                sb.append("\n");
            }
            out.println(sb.toString());
        %>
<form method="post">
    
    <label><b>your message</b></label>
	<textarea name='message' id='message'></textarea><br />
    <button type="submit">SendMessage</button>

</form>

</body>
</html>