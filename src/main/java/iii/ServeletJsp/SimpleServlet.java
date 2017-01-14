package iii.ServeletJsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FirstSimpleProgram")
public class SimpleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>這是程示標頭</title>");
		out.println("</head><body>");
		out.println("<h2>這是doGet()送出的訊息</h2>");
		out.println("打字打的很累");
		out.println("<hr>");
		out.println("Request URL:  "+ req.getRequestURL() +"<br>");
		out.println("Request URI:  "+ req.getRequestURI() +"<br>");
		out.println("Query String: "+ req.getQueryString() +"<br>");
		out.println("Context Path: "+ req.getContextPath() +"<br>");
		out.println("Servlet Path: "+ req.getServletPath() +"<br>");
		out.println("Path Info:    "+ req.getPathInfo() +"<br>");
		out.println("您的IP為:    "+ req.getRemoteAddr() +"<br>");
		out.println("<hr>");
		out.println("遊覽器送來的請求標頭有:<hr>");
		Enumeration<String> e =req.getHeaderNames();
		while(e.hasMoreElements()){
			String header = e.nextElement();
			String value = req.getHeader(header);
			out.println(value + "==>" + header +"<br>");
		}
		out.println("</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("這是doPost()送出的訊息");
		
	}
	
	
}
