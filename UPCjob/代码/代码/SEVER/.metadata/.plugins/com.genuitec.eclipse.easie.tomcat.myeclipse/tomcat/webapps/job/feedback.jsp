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
.STYLE4 {color: #99CC33; font-size: x-large; font-weight: bold; }
-->
</style>
</head>

<body>
<table width="570" height="135" border="1" cellpadding="0" cellspacing="0" bordercolor="#99FFFF">
  <tr>
    <td width="211"><div align="center" class="STYLE4">标题</div></td>
    <td width="131"><div align="center" class="STYLE4">内容</div></td>
    <td width="220"><div align="center" class="STYLE4">提交时间</div></td>
  </tr>
  <tr>
    <td><%
				ResultSet rs = conn
							.executeQuery("select * from feedback order by title DESC");
					while (rs.next()) {
						//String id = rs.getString("feedbackID");
						String title = rs.getString("title");
						String content=rs.getString("content");
						String publish_time=rs.getString("publish_time");
						out.println("<tr align=\"center\">");
						out.println("<td><a href=\"../show.jsp?id="+title+"&kind=music\" target=\"_blank\">" + title + "</a></td>");
								out.println("<td><a href=\"../show.jsp?id="+title+"&kind=music\" target=\"_blank\">" + content + "</a></td>");
									out.println("<td><a href=\"../show.jsp?id="+title+"&kind=music\" target=\"_blank\">" + publish_time + "</a></td>");
										
												
													
						out.println("</tr>");
					}
			%></td>
  </tr>
</table>
</body>
</html>

