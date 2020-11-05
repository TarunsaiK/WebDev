<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Welcome <%= request.getParameter("uname") %>

<br>
<%="Tarun Sai" %>
<%out.print("<h3> JSP BufferInformation</h3>");%>

Current date time:<%java.util.Date now= new java.util.Date(); %>


Current date time:<%= now %>

<%  if( now.getHours()<12) {%>
		Good Morning!
		<%} else if(now.getHours()<17){ %>
		Good Afternoon!
		<%}else{ %>
		GoodEvening! <%} %>
</body>
</html>