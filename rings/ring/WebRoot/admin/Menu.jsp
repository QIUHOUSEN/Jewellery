<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tag = request.getParameter("tag")==null ? "":(String)request.getParameter("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>菜单</title>
<link rel="stylesheet" href="Admin.css" type="text/css">
</head>
<body bgcolor="#CCFFFF">
<div>
<ul>
  <li>
  <a  href="../AdminAction?flag=1" target="MainF"  style="border:none;color:#33F; font-size:25px; background-color:transparent;border:0px;text-decoration:none;">管理用户</a>
  </li>
  <li>
  <a  href="../AdminAction?flag=3" target="MainF"  style="border:none;color:#33F; font-size:25px; background-color:transparent;border:0px;text-decoration:none;">管理商品</a>
  </li>
  <li>
  <a  href="../AdminAction?flag=2" target="MainF"  style="border:none;color:#33F; font-size:25px; background-color:transparent;border:0px;text-decoration:none;">管理评论</a>
  </li>
  <li>
  <a  href="#" onclick="change();" style="border:none;color:#F00; font-size:20px; background-color:transparent;border:0px;text-decoration:none;">退出系统</a>
  </li>
 </ul>
<!--
  <ul>
  <li>
  <input type="button" value="管理用户">
  </li>
  <li>
  <input type="button" value="管理商品">
  </li>
  </ul>
  -->
</div>
<script type="text/javascript">
	function change(){
		var url="<%=basePath%>Login.jsp";
		window.open('/ring/Login.jsp',"_blank");	
		
	}
</script>

</body>
</html>
