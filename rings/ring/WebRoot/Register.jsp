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
<title>注册</title>
   <link rel="stylesheet" type="text/css" href="css/register.css">
	<script type="text/javascript">
		function check(){
			var name=document.getElementById('num1').value;
			var pwd=document.getElementById('num2').value;
			var repwd=document.getElementById('num3').value;
			//var regexp=/^[\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-z]|[A-Z]+$/;
			//var temp=/^[^`~!@#$%^&*()+=|\\\][\]\{\}:;'\,.<>/?]{1}[^`~!@$%^&()+=|\\\][\]\{\}:;'\,.<>?]{0,10}$/; 
			//var regexp=/^(\s\,$/;
			/* if(regexp.test(name)){
				document.getElementById('span1').innerText='用户名过长sfdsd';
				return false;
			} */
			if(/\s/.test(name)){
				document.getElementById('span1').innerText='用户名不能有空格';
				document.getElementById('num1').value="";
				return false;
			}
			if(/[!@#$%\^&*(),.\/\\\^\-_]/.test(name)){
				document.getElementById('span1').innerText='不能有非法字符';
				document.getElementById('num1').value="";
				return false;
			}
			
			if(name.length>10){
				document.getElementById('span1').innerText='用户名过长';
				document.getElementById('num1').value="";
				return false;
			}
			if(pwd!=repwd){
				document.getElementById('num3').value="";
				document.getElementById('span3').innerText='确保密码一致';
				return false;
			}
			if(name.replace(/\s/g,"")==""){
				document.getElementById('span1').innerText='用户名不能为空';
				
				return false;
			}
			if(pwd.replace(/\s/g,"")==""){
				document.getElementById('span2').innerText='密码不能为空';
				return false;
			}
			if(name=="" || pwd==""){
				document.getElementById('span2').innerText='用户名不能为空';
				return false;
			}
				
			//document.getElementById('daojishi').style.display="block";	
		}
	</script>
	
 </head>
  
  <body>
  
  <div class="style1" >
   <div id="daojishi" class="daojishi">
  	<p>还有<span id="jishishu">5</span>秒进入登录页面</p>
  	手动点击<a href="Login.jsp">登录</a>按钮
  	</div>
  <div class="style3">
  
<form name="form1" action="<%=basePath %>RegiserAction" method="post">
	  <div style="text-align:center"><h2>欢迎注册</h2></div>
	  
	  <div class="style4"><img width=50 src="images/user.png" />
	  <input type="text" id="num1" name="user" placeholder="请输入用户名" /><div id="span1" name="span1" style="color:red; font-size:8pt;"></div></div>
	  
	  <div class="style5"><img width=50 src="images/pwd.png" />
	  <input type="password" id="num2" name="password" placeholder="请输入密码" /><div id="span2" style="color:red; font-size:8pt;"></div></div>
	  
	  <div class="style6"><img width=50 src="images/pwd.png" />
	  <input type="password" id="num3" name="pwdagain" placeholder="请确认密码" /><div id="span3" style="color:red; font-size:8pt; margin-left: 80px;"></div></div>
	  
	  <div class="s10">
	      <div class="s11"><input class="s111" type="submit" onclick="return check();" value="注册"/></div>
	    </div>
	    <div class="s12">
	      <a href="Login.jsp"><div class="s11" id="s11"> <span>返回登录</span></div></a>
	    </div>
	   <!-- <hr width=250px;> -->
	   <div class="style7">璀璨人生，爱你所爱</div>
	  </div>
	  
	  </div>
	  
</form> 
 
   <div class="style2">
  <span> Copyright © 2006-2015 www.darryring.com 璀璨人生 All Rights Reserved. 粤ICP备11012085号<br/>
  <p>
中国互联网违法信息举报中心 | 中国公安网络110报警服务 | 本网站提供所售商品的正式发票</span>
   </div>
 

  <script type="text/javascript">
		function tan(){
			var tag= <%=tag %>;
			if(tag=='1'){
				//document.getElementById('daojishi').style.display="block";
				//alert(tag);
				//alert();
				//document.form1.user.value="哈哈哈";
				//document.getElementById('span1').innerText="哦哦哦";
				//document.form1.user.span1.innerText="哈哈哈";
				document.getElementById('daojishi').style.display="block";
				//document.getElementById('num1').value="hhhh";
				//document.getElementById('span1').innerText='用户名不能有空格';
			}
			if(tag=='2'){
				
				alert("请重新注册用户名");
			}
		}
		
		//tan();
		
		//window.setTimeout("tiaozhuan()",5000);
		function tiaozhuan(){
			window.clearInterval(xuliehao);
			window.open("Login.jsp","_self");
		}
		function change(){
			var val = document.getElementById('jishishu').innerHTML;
			document.getElementById('jishishu').innerHTML=val-1;
		}
		
		var tag= <%=tag %>;
		if(tag=='2'){
			tan();
			
		}if(tag=='1'){
			tan();
			window.setTimeout("tiaozhuan()",5000);
			var xuliehao = window.setInterval("change()", 1000);
		}
		
		
	</script>
  </body>
</html>
