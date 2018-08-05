package ccc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pollgetjobserv extends HttpServlet {
	ArrayList jobname=new ArrayList ();
	ArrayList jobsalary =new ArrayList ();
	ArrayList requir =new ArrayList ();
	ArrayList des =new ArrayList ();
	ArrayList time =new ArrayList ();
	/**
	 * Constructor of the object.
	 */
	public pollgetjobserv() {
		super();
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
doPost(request,response);
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

		String userid=new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		
		String sql="select * from user_tb where name =' "+userid+"'";
		DBConnection db=new DBConnection ();
		System.out.println("aaaaa"+sql);
		ResultSet rs=db.executeQuery(sql);
		try {
			if (rs.next()){
				sql="select * from job_tb where requirement like '"+"%"+rs.getString("professtion")
				+"% '";
				System.out.println("aasssaaa"+sql);
				ResultSet rs1=new DBConnection ().executeQuery(sql);
				while (rs1.next()){
					jobname.add(rs1.getString("jobname"));
					jobsalary.add(rs1.getString("salary"));
					requir.add(rs1.getString("requirement"));
					des.add(rs1.getString("job_description"));
					time.add(rs1.getString("publish_time"));
					
					
					
				}
				
				StringBuilder json= new StringBuilder();
				
				for (int i=0;i<des.size();i++){
					json.append('{');
					json.append("jobnam:\"").append(jobname.get(i).toString()).append("\",");
					json.append("jobsalary:\"").append(jobsalary.get(i).toString()).append("\",");
					json.append("requirment:\"").append(requir.get(i).toString()).append("\",");
					json.append("descript:\"").append(des.get(i).toString()).append("\",");
					json.append("time:\"").append(time.get(i).toString()).append("\"");
					json.append("},");
					
					
					
				}
				
				request.setAttribute("json", json.toString());
				request.getRequestDispatcher("/WEB-INF/page/jsonnewslist.jsp").forward(request, response);

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
