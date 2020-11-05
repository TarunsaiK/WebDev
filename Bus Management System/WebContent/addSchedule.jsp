<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Schedule</title>
</head>
<body>
<h2>ENter Schedule Details</h2>
	<form method="post" action="MainServlet">
		Source <input type="text" name="source" value=""><br>
		Destination <input type="text" name="destination" value=""><br>
		Start Time <input type="text" name="starttime" value=""><br>
		Arrival Time <input type="text" name="arrivaltime" value=""><br>
		
		<input type="submit" name="submit" value="Create Schedule">
		<input type="hidden" name="operation" value="newSchedule">
		
	</form>
</body>
</html>