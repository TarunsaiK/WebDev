package com.wipro.bus.dao;
import java.sql.*;
import java.util.ArrayList;

import com.wipro.bus.bean.*;
import com.wipro.bus.util.*;
public class ScheduleDAO {
	public String createSchedule(ScheduleBean scheduleBean)
	{
		Connection connection=DBUtil.getDBConnection();
	
		try {
			PreparedStatement ps=connection.prepareStatement("insert into SCHEDULE_TBL VALUES(?,?,?,?,?)");
			
			
			ps.setString(1, scheduleBean.getScheduleId());
			ps.setString(2, scheduleBean.getSource());
			ps.setString(3, scheduleBean.getDestination());
			ps.setString(4, scheduleBean.getStartTime());
			ps.setString(5, scheduleBean.getArrivalTime());
			
			
			
			int a=ps.executeUpdate();
			//ps.close();
			
		//	connection.close();
			
			if(a>0)
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "FailedUpdate";
	}
	public String generateID(String source,String destination)
	{
		
		try {
			String generatedId=source.substring(0,2).toUpperCase()+destination.substring(0,2).toUpperCase();
			
			
			
			Connection connection=DBUtil.getDBConnection();
			
			PreparedStatement ps=connection.prepareStatement("select SCHEDULE_SEQ.nextval from dual");
			
			ResultSet rs=ps.executeQuery();
			
			
			//generatedId=generatedId.toUpperCase();
			
			if(rs.next())
			{
				generatedId+=rs.getInt(1);
			}
			return generatedId;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination)
	{
		try {
			Connection connection=DBUtil.getDBConnection();
			PreparedStatement ps=connection.prepareStatement("select * from SCHEDULE_TBL where source=? and destination=?");
			
			ps.setString(1, source);
			ps.setString(2, destination);
			
			ResultSet rs=ps.executeQuery();
			
			
			
			ArrayList<ScheduleBean> scheduleList=new ArrayList<ScheduleBean>();
			ScheduleBean sbobj;
		
			while(rs.next())
			{
				sbobj=new ScheduleBean();
				
				sbobj.setScheduleId(rs.getString(1));
				sbobj.setSource(rs.getString(2));
				sbobj.setDestination(rs.getString(3));
				sbobj.setStartTime(rs.getString(4));
				sbobj.setArrivalTime(rs.getString(5));
				
				
				//out.println
				scheduleList.add(sbobj);
			}
			if(scheduleList.size()==0)
				return null;
			return scheduleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
