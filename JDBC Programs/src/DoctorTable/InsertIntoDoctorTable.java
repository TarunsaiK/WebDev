package DoctorTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoDoctorTable {
	public static void main(String[] args) {
		
		
		try {
			
			//Load and Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Class Loaded");
			
			//Create a connection
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sujith-25");
			System.out.println("Connection established");
			
			Statement stmt=conn.createStatement();
			
			String insertQuery="insert into Doctor values(736,'lalitha','godavari')";
			stmt.executeUpdate(insertQuery);
			
			insertQuery="insert into Doctor values (656,'tarun','guntur')";
			stmt.executeUpdate(insertQuery);
			
			String selectQuery="select * from Doctor";
			
			ResultSet rs=stmt.executeQuery(selectQuery);
			System.out.println("DoctorID\tDoctorName\tCity");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
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
