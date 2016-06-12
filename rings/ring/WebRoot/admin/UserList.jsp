<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,bean.Users,net.ring.dao.AdminListDao,servlet.AdminAction" pageEncoding="UTF-8"%>
<%													
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tag = request.getParameter("tag")==null ? "":(String)request.getParameter("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>用户列表</title>
</head>
<!--  //by 杨后青-->
<body>
<form action="<%=basePath %>AdminAction?flag=1" method="post"> 
<table id="Usersinfo" border="1px" width="98%" font-align="center"> 
    <tr bgcolor="ff9900" style="font-weight:bold;">
    <th>用户ID</th><th>用户姓名</th><th>用户订单</th><th width="100" colspan="2">操作</th></tr>
  <c:forEach items="${list}" var="stu">
  			<tr align="center">
  				<td >${stu.userId }</td>
  				<td >${stu.userName }</td>
  				<td ><a href="<%=basePath %>AdminAction?flag=4&userid=${stu.userId }">用户订单</a></td>
  				<td><a href="<%=basePath %>DelServlet?flag=1&userid=${stu.userId }" onclick='return confirm("确定要删除用户${stu.userId }吗?")'
          >删除</a></td>
  			</tr>
  		</c:forEach>
   </table>
  <!-- <input type="submit" values="提交查询内容" /> -->
   </form>
</body>
</html>
