package DoctorTable;

import java.sql.*;

public class UpdateDoctorTable {
	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Class Loaded");
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sujith-25");
			System.out.println("Connection established");
			
			Statement stmt=conn.createStatement();
			String updateQuery="update Doctor set city='west-godavari' where doctorId=736";
			stmt.executeUpdate(updateQuery);
			
			String selectQuery="select * from Doctor";
			ResultSet rs=stmt.executeQuery(selectQuery);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"-----"+rs.getString(2)+"-----"+rs.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
