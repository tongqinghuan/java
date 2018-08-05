<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
<!--
body {
	background-image: url(201312022034319925_meitu_1.jpg);
	background-color: #CCCCCC;
}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
#Layer1 {
	position:absolute;
	width:345px;
	height:230px;
	z-index:1;
	left: 243px;
	top: 60px;
	background-image: url(image/201312022034319925_meitu_2.jpg);
}
.STYLE4 {
	font-size: x-large;
	color: #CC0000;
	font-weight: bold;
}
.STYLE5 {
	color: #CC0000;
	font-size: x-large;
}
-->
</style>
</head>

<body>
<div id="Layer1">
  <form id="form1" name="form1" method="post" action="../job/servlet/sign">
    <table width="346" height="230" border="0">
      <tr>
        <td><label><span class="STYLE4">用户名</span><span class="STYLE5">：</span>
          <input type="text" name="textfield" />
        </label></td>
      </tr>
      <tr>
        <td><label><span class="STYLE4">密 码：</span>
            <input type="text" name="textfield2" />
        </label></td>
      </tr>
      <tr>
        <td><table width="343" height="103" border="0">
          <tr>
            <td width="137"><label>
              <input type="submit" name="Submit" value="提交" />
            </label></td>
            <td width="112"><label>
              <input type="reset" name="Submit2" value="取消" />
            </label></td>
            <td width="72">&nbsp;</td>
          </tr>
        </table>          <label></label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
