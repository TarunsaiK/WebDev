<%@ page import = "java.io.*,java.util.*"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Refresh...</title>
</head>
<body>
<center>
<h2>Timer Refresh</h2>
<%

	response.setIntHeader("Refresh", 1);
	
Calendar calendar=new GregorianCalendar();
String am_pm;

int hour = calendar.get(Calendar.HOUR);
int minute = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);

if(calendar.get(Calendar.AM_PM) == 0)
   am_pm = "AM";
else
   am_pm = "PM";
String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
out.println("Current Time: " + CT + "\n");

%>




</center>


</body>
</html>