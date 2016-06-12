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
<title>管理员主页面</title>
</head>

<body bgcolor="#33FFCC">
<div style="font-family:'华文行楷';font-size:24px;" align="center">
欢迎来到管理员界面！
</div>
</body>
</html>
