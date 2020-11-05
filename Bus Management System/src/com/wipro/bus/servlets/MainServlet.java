package com.wipro.bus.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.service.Administrator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation=request.getParameter("operation");
		if(operation.equals("newSchedule"))
		{
			String result=addSchedule(request);
			if(result=="SUCCESS")
			{
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("errorInsertion.html");
				rd.forward(request,response);
			}
		}
		else if(operation.equals("viewSchedule"))
		{
			
			
			ArrayList<ScheduleBean> scheduleList=viewSchedule(request);
			
			if(scheduleList!=null)
			request.setAttribute("schedules", scheduleList);
			
			RequestDispatcher rd=request.getRequestDispatcher("displaySchedule.jsp");
			rd.forward(request,response);
			
		}
//		String res=addSchedule(request);
	}
	
	public String addSchedule(HttpServletRequest request)
  	{
	    	
	    	String source=request.getParameter("source");
	    	String destination =request.getParameter("destination");
	    	String startTime=request.getParameter("starttime");
	    	String arrivalTime=request.getParameter("arrivaltime");
	    	
	    	ScheduleBean scheduleBean=new ScheduleBean();
	    	scheduleBean.setSource(source);
	    	scheduleBean.setDestination(destination);
	    	scheduleBean.setStartTime(startTime);
	    	scheduleBean.setArrivalTime(arrivalTime);
	    	
	    	Administrator admin=new Administrator();
	
	    	return admin.addSchedule(scheduleBean);
	    	
	 	
  	}
	
	
	public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request)
	{
		
		Administrator admin=new Administrator();
		return admin.viewSchedule(request.getParameter("source"), request.getParameter("destination"));
		
		
	}
	
	    
	    

}
