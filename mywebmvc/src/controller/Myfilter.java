package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class Myfilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg1.setContentType("text/html");
		PrintWriter out=arg1.getWriter();
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String address=request.getParameter("address");
		
		if(id==0||fname.equals("")||address.equals(""))
		{  out.println("<p style='color:red'>user please add all fild </p> ");
		   RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
		   dispatcher.include(request, arg1);
		}
		else
		   arg2.doFilter(request, arg1);
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
