package DoctorTable;

import java.sql.*;

public class DeleteRowDoctorTable {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded");
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tarunsai");
			
			Statement stmt=conn.createStatement();
			
			String deleteQuery="delete from Doctor where doctorId=736";
			stmt.executeQuery(deleteQuery);
			
			deleteQuery="delete from Doctor where doctorId=656";
			stmt.executeQuery(deleteQuery);
			
			String selectQuery="select * from Doctor";
			ResultSet rs=stmt.executeQuery(selectQuery);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3));
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
