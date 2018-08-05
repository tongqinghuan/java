<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
#Layer1 {
	position:absolute;
	width:408px;
	height:216px;
	z-index:1;
	left: 20px;
	top: 20px;
}
.STYLE2 {color: #009933; font-size: x-large;}
.STYLE3 {
	font-size: x-large;
	font-weight: bold;
	color: #009933;
}
-->
</style>
</head>

<body>
<div id="Layer1">
  <form id="form1" name="form1" method="post" action="http://127.0.0.1:8080/job/servlet/information">
    <table width="405" height="215" border="1" cellpadding="0" cellspacing="0" bordercolor="#99FFFF">
      <tr>
       
        <td width="84"><div align="center" class="STYLE2">标题</div></td>
        <td width="109"><div align="center" class="STYLE3">内容</div></td>
        <td width="134"><div align="center"><span class="STYLE3">发布时间</span></div></td>
      </tr>
      <tr>
        <td height="31"><label>
          <textarea name="textfield" cols="5"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield2" cols="7"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield3" cols="10"></textarea>
        </label></td>
        
      </tr>
      <tr>
        <td colspan="4"><label>
          <div align="center">
            <input type="submit" name="Submit" value="提交" />
          </div>
        </label>
          <label>
          <div align="center">
            <input type="reset" name="Submit2" value="取消" />
          </div>
        </label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
