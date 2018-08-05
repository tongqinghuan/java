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
	width:570px;
	height:233px;
	z-index:1;
	left: 15px;
	top: 13px;
}
.STYLE1 {
	font-size: x-large;
	font-weight: bold;
	color: #009933;
}
-->
</style>
</head>

<body>
<div id="Layer1">
  <form id="form1" name="form1" method="post" action="http://127.0.0.1:8080/job//servlet/campus">
    <table width="581" height="113" border="1" cellpadding="0" cellspacing="0" bordercolor="#99FFFF">
      <tr>
       
        <td width="88"><div align="center"><span class="STYLE1">名称</span></div></td>
        <td width="104"><div align="center"><span class="STYLE1">发布时间</span></div></td>
        <td width="104"><div align="center"><span class="STYLE1">宣讲地点</span></div></td>
        <td width="90"><div align="center"><span class="STYLE1">宣讲时间</span></div></td>
        <td width="116"><div align="center"><span class="STYLE1">宣讲内容</span></div></td>
      </tr>
      <tr>
        <td height="26"><label>
          <textarea name="textfield" cols="5"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield2" cols="8"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield3" cols="10"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield4" cols="10"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield5" cols="10"></textarea>
        </label></td>
        
      </tr>
      <tr>
        <td height="63" colspan="6"><label> </label>
            <div align="center">
              <input type="submit" name="Submit" value="提交" />
              <input type="submit" name="Submit2" value="取消" />
          </div></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
