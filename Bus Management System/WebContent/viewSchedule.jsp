<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Schedule</title>
</head>
<body>
	<form action="MainServlet" method="post">
	Enter Source<input type="text" name="source" value=""><br>
	Enter Destination<input type="text" name="destination" value=""><br>
	
	<input type="submit" name="submit" value="Search Schedule"><br>
	<input type="hidden" name="operation" value="viewSchedule">
	</form>
</body>
</html>