
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>

  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Public Chat</title>
  </head>

  <body>
    <c:if test="${pageContext.request.method=='POST'}">
      <c:choose>
        <c:when test="${param.send!=null}">
          <c:set var="chat"
          value="${chat}<b>${param.uid}:</b>${param.text}<br />"
           scope="application" />
        </c:when>

        <c:when test="${param.clear!=null}">
          <c:set var="chat" value="" scope="application" />
        </c:when>
      </c:choose>
    </c:if>

    <table border="0">
      <tbody>
        <tr>
          <td>
            <h3>User: 
            <c:out value="${loggedUser} " />
            </h3>

            <hr />
          </td>
        </tr>

        <tr>
          <td>
            <c:out value="${chat}" escapeXml="false" />
          </td>
        </tr>

        <tr>
          <td>
            <hr />

            <form method="post">Message:
            <input type="text" name="text" size="20" />

            <input type="submit" name="message" value="Send" />

            <input type="submit" name="refresh" value="Refresh" />

            <input type="submit" name="clear" value="Clear" />

            <input type="hidden" name="uid"
            value="<c:out value="${param.uid}"/>" />

            <br />
            </form>
          </td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
