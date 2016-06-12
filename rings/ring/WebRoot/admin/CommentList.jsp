<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,bean.*,net.ring.dao.AdminListDao,servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tag = request.getParameter("tag")==null ? "":(String)request.getParameter("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>评论用户列表</title>
</head>
<!--  //by 杨后青-->
<body>
<form action="<%=basePath %>AdminAction?flag=2" method="post"> 
<table id="Usersinfo" border="1px" width="98%" font-align="center"> 
    <tr bgcolor="ff9900" style="font-weight:bold;">
    <th>评论ID</th><th>商品ID</th><th>用户ID</th><th>评论内容</th><th >操作</th></tr>
  <c:forEach items="${list}" var="comment">
  			<tr align="center">
  				<td >${comment.commentId }</td>
  				<td >${comment.ringId }</td>
  				<td >${comment.userId }</td>
  				<td >${comment.content }</td>
  				<td><a href="<%=basePath %>DelServlet?flag=2&commentid=${comment.commentId }" onclick='return confirm("确定要删除评论${comment.commentId }吗?")'
          >删除</a></td>
  			</tr>
  		</c:forEach>
   </table>
  <!-- <input type="submit" values="显示所有评论信息" /> -->
   </form>
</body>
</html>
