<%@ page contentType="text/html;charset=GBK"%>
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
	width:780px;
	height:141px;
	z-index:1;
	left: 27px;
	top: 13px;
}
.STYLE1 {
	font-size: x-large;
	color: #009933;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<div id="Layer1">
  <form id="form1" name="form1" method="post" action="http://127.0.0.1:8080/job//servlet/jobadd">
    <table width="765" height="320" border="1" cellpadding="0" cellspacing="0" bordercolor="#99FFFF">
      <tr>
       
        <td width="87"><div align="center"><span class="STYLE1">职位名称</span></div></td>
        <td width="52"><div align="center"><span class="STYLE1">薪资</span></div></td>
        <td width="108"><div align="center"><span class="STYLE1">工作要求</span></div></td>
        <td width="143"><div align="center"><span class="STYLE1">职位介绍</span></div></td>
        <td width="122"><div align="center"><span class="STYLE1">发布时间</span></div></td>
        <td width="178"><div align="center"><span class="STYLE1">工作地点</span></div></td>
        <td width="178"><div align="center"><span class="STYLE1">工作类型</span></div></td>
      </tr>
      <tr>
        <td height="31"><label>
          <textarea name="textfield" cols="6"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield2" cols="20"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield3" cols="5"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield4" cols="15"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield5" cols="15"></textarea>
        </label></td>
        <td><label>
          <textarea name="textfield6" cols="15"></textarea>
        </label></td>
        <td><label></label>
          <label>
          <textarea name="textfield7" cols="20"></textarea>
        </label></td>
        <td><label></label>
         
      </tr>
      <tr>
        <td height="224" colspan="7"><label></label>
          <label>
          <div align="center">
            <input type="submit" name="Submit2" value="提交" />
            <input type="reset" name="Submit" value="取消" />
          </div>
        </label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>