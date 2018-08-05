package ccc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	person person1=new person();
	public register() {
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
			throws ServletException, IOException 
			{
               
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
			throws ServletException, IOException 
			{
		person1.setName(new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8")) ;
        person1.setStudentnumber(new String(request.getParameter("studentnumber").getBytes("ISO-8859-1"),"utf-8")) ;
        person1.setGrade(new String(request.getParameter("grade").getBytes("ISO-8859-1"),"utf-8")) ;
        person1.setMajor(new String(request.getParameter("major").getBytes("ISO-8859-1"),"utf-8")) ;
        person1.setPassword(new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8")) ;
        System.out.println(new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8"));//这是为了测试是否接受了数据
        DBConnection  db=new DBConnection();
        String  sql=new String("INSERT INTO user (username,studentnumber,major,pwd,grade) VALUES ("+"'"+person1.getName()+"'"+","+"'"+person1.getStudentnumber()+"'"+","+"'"+person1.getPassword()+"'"+","+"'"+person1.getGrade()+"'"+","+"'"+person1.getMajor()+"'"+")");   
        System.out.println("sql 语句"+sql);
	
		if (db.execute(sql)){	
		response.getOutputStream().print("success");
			System.out.println("成功插入");	
		}else {
			response.getOutputStream().print("faild");
			System.out.println("插入失败");
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
