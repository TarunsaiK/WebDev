<%@ page import="com.wipro.bus.bean.ScheduleBean"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display!!</title>
</head>
<body>
	
			
		<%
			ArrayList<ScheduleBean> list=(ArrayList<ScheduleBean>)request.getAttribute("schedules");
			if(list==null)
			{
				out.println("No matching schedule exists! Please try again!");
			}
			else{
			%>
			<table>
			<tr>
			<th>ScheduleID</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Start Time</th>
			<th>Arrival Time</th>
			</tr>
		
		<%	
				Iterator<ScheduleBean> iterator=list.iterator();
				while(iterator.hasNext())
				{
					ScheduleBean sb=iterator.next();
					out.print("<tr>");
					
					out.println("<td>");
					out.println(sb.getScheduleId());
					out.println("</td>");
					
					out.println("<td>");
					out.println(sb.getSource());
					out.println("</td>");
					
					out.println("<td>");
					out.println(sb.getDestination());
					out.println("</td>");
					
					out.println("<td>");
					out.println(sb.getStartTime());
					out.println("</td>");
					
					out.println("<td>");
					out.println(sb.getArrivalTime());
					out.println("</td>");
					
					out.println("</tr>");
				}
			}
		%>	
		</table>
	
</body>
</html>