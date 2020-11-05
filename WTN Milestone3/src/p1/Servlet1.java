package p1;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
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
	//	doGet(request, response);
		
		PrintWriter out=response.getWriter();
/*		
		String u=request.getParameter("uname");
		String p=request.getParameter("pwd");
		String gen=request.getParameter("gen");
		String h=request.getParameter("hobby");
		String[] hobbies=request.getParameterValues("hobby");
		String lang=request.getParameter("lang");
		out.println("Values received from client-- "+u+"---"+p+"---"+gen);
		for(int i=0;i<hobbies.length;i++)
		out.println(hobbies[i]);
		
		
		out.println(lang);
		
		
		*/
		
		String u=request.getParameter("uname");
		String p=request.getParameter("pwd");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","tarunsai");
			PreparedStatement ps=con.prepareStatement
					("insert into wtnusers values(?,?)");
			ps.setString(1, u);
			ps.setString(2, p);
			int a=ps.executeUpdate();
			out.println("Record Inserted");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
