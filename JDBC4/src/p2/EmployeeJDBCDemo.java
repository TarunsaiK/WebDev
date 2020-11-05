package p2;
import java.sql.*;
import java.util.*;

import p1.Employee;
public class EmployeeJDBCDemo {

	public static List<Employee> getEmployeeList()
	{
		List<Employee> e1=new ArrayList<Employee>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tarunsai");
			PreparedStatement ps=con.prepareStatement("select empno,ename,job,sal from emp");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				e1.add(emp);
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return e1;
	}
}
