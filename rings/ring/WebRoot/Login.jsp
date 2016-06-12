<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics2D"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tag = request.getParameter("tag")==null ? "":(String)request.getParameter("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/first.css" type="text/css" rel="stylesheet" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
	
</head>
  
  <body>
  
  <div class="style1">
  <div class="style3">
  
<form action="<%=basePath %>LoginAction" method="post">
  <div style="text-align:center"><h2>欢迎登录</h2></div>
  <div class="style4"><img width=50 src="images/user.png" />
  <input type="text" id="user" name="user" placeholder="请输入用户名" />
  <div id="span1" name="span1" style="color:red; font-size:10pt;"></div>
  </div>
  
  <div class="style5"><img width=50 src="images/pwd.png" />
  <input type="password" id="password" name="password" placeholder="请输入密码" />
  <div id="span2" style="color:red; font-size:10pt;"></div>
  </div>
  
  <div style="width: 300px; margin-left: 30px;">
	   &nbsp;&nbsp;验证码:<input type="text" id="checkcode" name="checkcode" style="width: 110px;">&nbsp;<span style="font-size: 10px; color: red;" id="error"></span>
	  <img src="<%=basePath %>RandomNum" onclick="changeimage(this)" alt="换一换" style="cursor: hand; margin-left: 62px; margin-top: 10px;"><br/>
  </div>
  <%-- <%
	String servernum = (String) request.getSession().getAttribute("randomnum");
	System.out.println(servernum);
	
 %> --%>
  <div class="s10">
      <div class="s11"> <input class="s111" type="submit" onclick="return tans();" value="登录"/></div>
    </div>
    
</form>    

    <div class="s12">
      <a href="Register.jsp"><div class="s11" id="s11"> <span>注册</span></div></a>
    </div>
   <!-- <hr width=250px;> -->
   <div class="style6">璀璨人生，爱你所爱</div>
  </div>
  
  </div>
  
   <div class="style2">
  <span> Copyright © 2006-2015 www.darryring.com 璀璨人生 All Rights Reserved. 粤ICP备11012085号<br/>
  <p>
中国互联网违法信息举报中心 | 中国公安网络110报警服务 | 本网站提供所售商品的正式发票</span>
   </div>
  
  
 	<script type="text/javascript">
 		/* function tan(){
 			if()
 		} */
 		var tag='<%=tag%>';
 		if(tag==1){
 			alert("账号有错");
 		}
 		if(tag==2){
 			//alert("验证码空");
 			document.getElementById('error').innerText="验证码错误";
 		}
 		//document.getElementById('error').innerText="验证码错误";
 		//document.getElementById('error').value="验证码错误";
 		/* if(tag==3){
 			//alert("验证码空");
 			document.getElementById('error').innerText="验证码错误";
 		} */
 		function tans(){
 			var name = document.getElementById('user').value;
 			var pwd = document.getElementById('password').value;
 			if(name=="admin" && pwd=="admin"){
 				//alert();
 				window.open('admin/Admin.jsp',"_self");
 				return false;
 			}
 		}
 		
 		function changeimage(img){
    		img.src=img.src + "?" + new Date().getTime();
    	
    	}
 		
		//document.getElementById('span1')
	</script>
  
  </body>
</html>
