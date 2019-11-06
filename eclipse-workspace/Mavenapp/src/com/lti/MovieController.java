package com.lti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieController
 */
@WebServlet("/MovieController")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		  int id = Integer.parseInt(request.getParameter("id"));
		  String name = request.getParameter("name");
		  String actor = request.getParameter("actor");
		  String actress = request.getParameter("actress");
		  String director = request.getParameter("director");
		  int collection = Integer.parseInt(request.getParameter("collection"));
		  String dor = request.getParameter("dor");


//if (fname.isEmpty() || lname.isEmpty() || course.isEmpty() ) {
// RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
// out.println("<font color=red>Please fill all the fields</font>");
// rd.include(request, response);
//} 



//else {

 
 
 Connection con=null;
		try 
		{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String password="hr";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,password);
			System.out.println("connecting..........");

			
//			if(con!=null)
			  
			  
			  String query1= "insert into movie values(?,?,?,?,?,?,?)";
			  PreparedStatement stmt1=con.prepareStatement(query1);
	
			
			    stmt1.setInt(1,id);
				stmt1.setString(2,name);
				stmt1.setString(3,actor);
				stmt1.setString(4,actress);
				stmt1.setString(5,director);
				stmt1.setInt(6,collection);
				stmt1.setString(7,dor);
				
				int ra=stmt1.executeUpdate();	
			
			stmt1.close();
//			String query2="Select * from studentdetails";
//			PreparedStatement stmt2=con.prepareStatement(query2);
//			ResultSet rs=stmt2.executeQuery(query2);
//			System.out.println("rollno \t fname \t lname \t course \t result");
//			while(rs.next())
//			{
//				
//				System.out.println(rs.getInt("rollno")+"\t"+rs.getString("fname")+"\t"+rs.getString("lname")+"\t"+rs.getString("course")+"\t"+rs.getInt("result"));
//			}
//			stmt2.close();
			
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
// RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
// rd.forward(request, response);
}
	}

//}
