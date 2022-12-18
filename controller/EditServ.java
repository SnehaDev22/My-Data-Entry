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


@WebServlet("/edit")
public class EditServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
	    
		try {
			Emp e=new EmpDao().getOneEmp(id);
			if(e!=null)
			{
				out.print("<form action='update' >");
				out.print("<input type='text' name='id' value='"+e.getId()+"'   readonly='readonly'>");
				out.print("<input type='text' name='fname' value='"+e.getFname()+"'>");
				out.print("<input type='text' name='address' value='"+e.getAddress()+"'>");
				out.print("<input type='submit' value='Update'>");
				out.print("</form>");

			}
			else
			{
				out.print("id is not in database");
			}
			
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
