package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emp;
import model.EmpDao;

@WebServlet("/show")
public class ShowServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		out.print("  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js'></script>");
		out.print("  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");

		
		//search start
		out.print("<form action='search' >");
		out.print("<input type='text' name='city' placeholder='Enter City' >");
		out.print("<input type='submit' value='Search'>");
		out.print("</form>");
		//search endSS
		
		
		try {
			
			
			List<Emp> le=new EmpDao().getAllData();
			out.print("<table class='table table-striped'>");
			out.print("<tr><th>Id</th><th>Name</th><th>Address</th><th>Action</th></tr>");
			for(Emp e:le)
			{
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFname()+"</td><td> "+e.getAddress()+
					"</td><td><a href='edit?id="+e.getId()+"' class='btn btn-primary'>Edit</a> <a href='delete?id="+e.getId()+"' class='btn btn-danger'>Delete</a></td></tr>");
			}
			
			out.print("</table>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
