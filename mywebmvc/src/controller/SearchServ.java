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


@WebServlet("/search")
public class SearchServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String address=request.getParameter("city");
		
try {
			
			
			List<Emp> le=new EmpDao().getAllCityData(address);
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
		doGet(request, response);
	}

}