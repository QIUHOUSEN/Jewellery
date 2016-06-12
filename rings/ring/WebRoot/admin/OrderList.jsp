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
<title>管理订单列表</title>
</head>
<!--  //by 杨后青-->
<body>
<form action="<%=basePath %>AdminAction?flag=4" method="post"> 
<table id="Usersinfo" border="1px" width="98%" font-align="center"> 
    <tr bgcolor="ff9900" style="font-weight:bold;">
    <th>订单号</th><th>用户ID</th><th>戒指ID</th><th>商品图片</th><th>商品信息</th><th>单价(元)</th> <th>数量</th><th>金额(元)</th>
  <c:forEach items="${list}" var="orderlist">
  			<tr align="center">
  				<td >${orderlist.buy_OrderId }</td>
  				<td >${orderlist.buy_UserId }</td>
  				<td >${orderlist.buy_RingId }</td>
  				<td ><img width="100px" src="images/${orderlist.ringImage }" /></td>
  				<td >重量：${orderlist.weight}；颜色：${orderlist.color }；净度：${orderlist.clean }；切割：${orderlist.cut}；质量：${orderlist.quality }；大小：${orderlist.size }</td>
  				<td >${orderlist.price }</td>
  				<td >${orderlist.buyNum }</td>
  				<td >${orderlist.orderAllPrice }</td>
  			</tr>
  		</c:forEach>
   </table>
  <!-- <input type="submit" values="显示所有评论信息" /> -->
   </form>
</body>
</html>
