<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,bean.*,net.ring.dao.AdminListDao,servlet.AdminAction" pageEncoding="UTF-8"%>
<%													
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tag = request.getParameter("tag")==null ? "":(String)request.getParameter("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>所有商品列表</title>
</head>
<!--  //by 杨后青-->
<body>
<form name="myform" action="<%=basePath %>AdminAction?flag=3" method="post"> 
 <%
    ArrayList<Ring> list=new ArrayList<Ring>();
    list=(ArrayList<Ring>)request.getAttribute("list");
 %> 
<table id="Usersinfo" border="1px" width="98%" font-align="center"> 
    <tr bgcolor="ff9900" style="font-weight:bold;">
    <th>戒指ID</th><th>戒指图片</th><th >操作</th></tr>  
    <%
    for(int i=0;i<list.size();i++)
    {%>
    <form action="<%=basePath %>XiajiaServlet" method="post" name="myform">
    <tr>
    <td name="ID"><%=list.get(i).getRingId() %></td>
    <td><img width="100px" src="images/<%=list.get(i).getRingImage() %>" /></td>
    <!--  <td><input type="submit" value="下架商品" /></td>-->
     <td><a href="<%=basePath %>XiajiaServlet?flag=<%=list.get(i).getRingId()%>">下架商品</a></td>
    <%//HttpSession session1 = request.getSession();
	 //session1.setAttribute("RingID",list.get(i).getRingId()); %>
    </tr>
    </form>
    <%}%>
   </table>
  <br /><br /> 
   </form>
   
   <!-- By 邹娟 -->
   选择上架商品号:
   <%
   int Getid[]=new int[100];
   Getid=(int[])request.getAttribute("IDs");
   int a= Integer.parseInt(request.getAttribute("len").toString());
    %>
   <form name="IDs" action="<%=basePath %>ShangjiaServlet" method="post">
   <select name="ID">
   <%
     for(int i=0;i<a;i++)
     {%>
      <option value="<%=Getid[i]%>"><%=Getid[i]%></option>
     <%}%> 
   </select> 
   <input type="submit" value="确定上架"/>
   </form>
</body>
</html>
