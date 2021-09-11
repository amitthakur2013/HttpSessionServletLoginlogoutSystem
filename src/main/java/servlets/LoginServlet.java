package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name=req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(pass.equals("admin123")) {
			out.print("Welcome, "+name);
			
			HttpSession session=req.getSession();
			session.setAttribute("name", name);
		} else {
			out.print("sorry, username or password invalid!");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		
		out.close();
	}
}
