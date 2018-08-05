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

public class Profession_zixun extends HttpServlet {
	ArrayList title=new ArrayList ();
	ArrayList type =new ArrayList ();
	ArrayList content =new ArrayList ();
	ArrayList pub_time =new ArrayList ();
	/**
	 * Constructor of the object.
	 */
	public Profession_zixun() {
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

		//String userid="本";//new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8"); 
		//System.out.println("ddddddddddd"+userid);
		
		String sql="select * from xuanjiang ";
		DBConnection db=new DBConnection ();
		ResultSet rs=db.executeQuery(sql);
		try {
			if (true){
				sql="select * from profession_news ";
				System.out.println("sssss"+sql);
				ResultSet rs1=new DBConnection ().executeQuery(sql);
				
				while (rs1.next()){
					
					title.add(rs1.getString("title"));
					type.add(rs1.getString("type"));
					content.add(rs1.getString("content"));
					pub_time.add(rs1.getString("publish_time"));
					
					//time.add(rs1.getString("content"));
					
					
					
				}
				
				StringBuilder json= new StringBuilder();
				System.out.println("ssqqqsss1111"+sql);
				json.append('[');
				for (int i=0;i<title.size();i++){
					json.append('{');
					System.out.println("ssqqqsss1111"+sql);
					json.append("title:\"").append(title.get(i).toString()).append("\",");
					System.out.println("ssqqqsss1111"+sql);
					json.append("time:\"").append(type.get(i).toString()).append("\",");
					System.out.println("ssqqqsss1111"+sql);
					json.append("place:\"").append(content.get(i).toString()).append("\",");
					json.append("content:\"").append(pub_time.get(i).toString()).append("\",");
					System.out.println("ssqqqsss1111"+sql);
					json.append("pub_time:\"").append(pub_time.get(i).toString()).append("\"");
					System.out.println("ssqqqsss1111"+sql);
					json.append("},");
					
					
					
				}
				System.out.println("ssqqqsss1111"+sql+title.size());
				if (json.length()==0){
					
					response.getOutputStream().println("failed get ");
				System.out.println("ssssssss"+json.length());}
				else {
					System.out.println(json);
					json.deleteCharAt(json.length() - 1);
					json.append(']');
				request.setAttribute("json", json.toString());
				request.getRequestDispatcher("/WEB-INF/page/jsonnewslist.jsp").forward(request, response);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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
