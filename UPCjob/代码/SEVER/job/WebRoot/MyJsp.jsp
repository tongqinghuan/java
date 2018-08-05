<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<jsp:useBean id="conn" class="ccc.DBConnection" scope="session" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE2 {font-size: x-large; font-weight: bold; color: #99CC33; }
-->
</style>
</head>

<body>
<table width="755" height="135" border="1" cellpadding="0" cellspacing="0" bordercolor="#99FFFF">
  <tr>
    <td width="149"><div align="center" class="STYLE2">姓名</div></td>
     <td width="135"><div align="center" class="STYLE2">性别</div></td>
      <td width="108"><div align="center" class="STYLE2">专业</div></td>
       <td width="172"><div align="center" class="STYLE2">求职意向</div></td>
        <td width="83"><div align="center" class="STYLE2">生日</div></td>
         <td width="94"><div align="center" class="STYLE2">密码</div></td>
  </tr>
  <tr>
    <td><%
				ResultSet rs = conn
							.executeQuery("select * from user_tb order by name DESC");
					while (rs.next()) {
						//String id = rs.getString("nameID");
						String name = rs.getString("name");
						String sex=rs.getString("sex");
						String professtion=rs.getString("professtion");
						String job_intend=rs.getString("job_intend");
						String birthday=rs.getString("birthday");
						String password=rs.getString("password");
						out.println("<tr align=\"center\">");
						//out.println("<td><a href=\"../show.jsp?id="+id+"&kind=music\" target=\"_blank\">" + name + "</a></td>");
								out.println("<td><a href=\"../show.jsp?id="+name+"&kind=music\" target=\"_blank\">" + sex + "</a></td>");
									out.println("<td><a href=\"../show.jsp?id="+name+"&kind=music\" target=\"_blank\">" + professtion + "</a></td>");
										out.println("<td><a href=\"../show.jsp?id="+name+"&kind=music\" target=\"_blank\">" + job_intend + "</a></td>");
											out.println("<td><a href=\"../show.jsp?id="+name+"&kind=music\" target=\"_blank\">" + birthday + "</a></td>");
												out.println("<td><a href=\"../show.jsp?id="+name+"&kind=music\" target=\"_blank\">" + password + "</a></td>");
										out.println("<td><a href=\"/job/servlet/xuanzhong?id="+name+"&sorting="+professtion+"\">选中</a></td>");		
													
						out.println("</tr>");
					}
			%></td>
  </tr>
</table>
</body>
</html>

