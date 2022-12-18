package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emp;
import model.EmpDao;


@WebServlet("/update")
public class UpdateServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String address=request.getParameter("address");
		
		
		Emp e=new Emp(id, fname, address);
		
		try {
			
			int a=new EmpDao().update(e);
		
			if(a>0)
				{
				out.print("data Update! ");
			    out.print("<a href='show'>Show Emp</a>");
				}
			else
				out.print("data not Update!");
			
			
		} catch (ClassNotFoundException|SQLException ex) {

			ex.printStackTrace();
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
