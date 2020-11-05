package DoctorTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintDoctorTable {
	public static void main(String[] args) {
		
		try {	
			//Load and Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Successfully");
			
			//Create a Connection
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tarunsai");
			
			String sqlQuery="select * from Boats";
			
			//prepare a SQL statement
			Statement stmt=conn.createStatement();
			
			//execute the Query
			ResultSet rs = stmt.executeQuery(sqlQuery); 
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
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
