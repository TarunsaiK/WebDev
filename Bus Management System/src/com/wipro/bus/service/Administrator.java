package com.wipro.bus.service;

import java.util.ArrayList;

import com.wipro.bus.bean.*;
import com.wipro.bus.dao.*;


public class Administrator {
	public String addSchedule(ScheduleBean scheduleBean)
	{
		if(scheduleBean==null || scheduleBean.getSource()==null || scheduleBean.getDestination()==null 
				|| scheduleBean.getSource().length()<2  || scheduleBean.getDestination().length()<2 )
		return "INVALID INPUT";
		if(scheduleBean.getSource().equals(scheduleBean.getDestination()))
			return "Source and Destination Same";
		
		ScheduleDAO scheduleDAO=new ScheduleDAO();
		
		String schid=scheduleDAO.generateID(scheduleBean.getSource(), scheduleBean.getDestination());
		
		scheduleBean.setScheduleId(schid);
		return scheduleDAO.createSchedule(scheduleBean);
		
	//	return null;
	}
	
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination)
	{
		ScheduleDAO scheduleDAO=new ScheduleDAO();
		return scheduleDAO.viewSchedule(source, destination);
	}

}
