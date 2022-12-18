package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emp;
import model.EmpDao;



public class RegServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	int id=Integer.parseInt(request.getParameter("id"));
	String fname=request.getParameter("fname");
	String address=request.getParameter("address");
	
	
	Emp e=new Emp(id, fname, address);
	
	try {
		
		int a=new EmpDao().save(e);
	
		if(a>0)
			{
			out.print("data inserted! ");
		    //out.print("<a href='show'>Show Emp</a>");
            request.getRequestDispatcher("mypage").forward(request, response);
			response.sendRedirect("mypage");
			}
		else
			out.print("data not inserted!");
		
		
	} catch (ClassNotFoundException|SQLException ex) {

		ex.printStackTrace();
		
	}

	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
