package ccc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import java.util.Hashtable;
import java.io.Writer;
import java.io.IOException;
import java.util.Date;
import java.sql.*;
import java.math.*;
import java.util.*;

public class sign extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public sign() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String name=request.getParameter("textfield");
        String password=request.getParameter("textfield2");
        DBConnection  db=new DBConnection();
        ResultSet re=db.executeQuery("SELECT PASSWORD FROM manager WHERE NAME="+"'"+name+"'");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("SELECT PASSWORD FROM manager WHERE NAME="+"'"+name+"'");
        try
        {
        	if(re.next())
        	{
        		
              String str=re.getString("password");
              if(str.equals(password))
              {

            	 System.out.println("您已经成功登录！！");
            	 
            	 /*ServletContext sc = getServletContext();

            	RequestDispatcher rd = null;

            	rd = sc.getRequestDispatcher("/123.jsp"); //瀹氬悜鐨勯〉闈�

            	 rd.forward(request, response);*/
            	 String ss=new String("../frameset.html");
            	 out.print(db.dialog("您已经成功登录！！",ss));
            	 //System.out.println(db.dialog("瀹�",ss));
            	// response.sendRedirect("/job/123.jsp");

              }
              else
              {
            	  out.print(db.dialog("密码不正确！！"," "));
            	  
              }
        		
        	}
        	else
        	{

        		out.print(db.dialog("用户名不存在！！"," "));
        	}
        }
        	catch(Exception e)
        	{

        	}
        
        //System.out.println(name);
		response.setContentType("text/html");
		
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
