<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<jsp:useBean id="conn" class="ccc.DBConnection" scope="session" />
<%
String path = request.getContextPath();
String id=request.getParameter("id");
String sorting=request.getParameter("sorting");
System.out.println(sorting);
ResultSet rs = conn
							.executeQuery("SELECT * FROM job_tb  WHERE sorting="+"'"+sorting+"'"+"");
							System.out.println("SELECT * FROM job_tb  WHERE sorting="+sorting+"");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chulituisong.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<table width="755" height="135" border="1" cellpadding="0" cellspacing="0" bordercolor="#99FFFF">
  <tr>
    <td width="149"><div align="center" class="STYLE2">名称</div></td>
     <td width="135"><div align="center" class="STYLE2">工资</div></td>
      <td width="108"><div align="center" class="STYLE2">工作要求</div></td>
       <td width="172"><div align="center" class="STYLE2">工作描述</div></td>
        <td width="83"><div align="center" class="STYLE2">发布时间</div></td>
         <td width="94"><div align="center" class="STYLE2">地点</div></td>
         <td width="94"><div align="center" class="STYLE2">工作类型</div></td>
  </tr>
  <tr>
    <td><%
				 
					while (rs.next()) {
						//String idd = rs.getString("jobID");
						String name = rs.getString("jobname");
						String sex=rs.getString("salary");
						String professtion=rs.getString("requirement");
						String job_intend=rs.getString("job_description");
						String birthday=rs.getString("publish_time");
						String password=rs.getString("palace");
						String sort=rs.getString("sorting");
						out.println("<tr align=\"center\">");
						out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + name + "</a></td>");
								out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + sex + "</a></td>");
									out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + professtion + "</a></td>");
										out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + job_intend + "</a></td>");
											out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + birthday + "</a></td>");
												out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + password + "</a></td>");
												out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" +sort + "</a></td>");
												
													
						out.println("</tr>");
					}
			%></td>
  </tr>
</table>
<a href=\"/job/servlet/xuanzhong?id="+id+"&sorting="+professtion+"\">选中</a>
</body>
</html>
