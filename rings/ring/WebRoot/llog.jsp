<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'login.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
  
  </head>  
  <%  
   // String incode = (String)request.getParameter("code");  
   // System.out.println(incode); 
    String rightcode = (String)session.getAttribute("rCode");  
    
    System.out.println(rightcode); 
    //if(incode != null && rightcode != null){  
    //    if(incode.equals(rightcode)){  
     //       out.println("验证码输入正确！");  
     //   }else{  
     //       out.println("验证码输入不正确，请重新输入！");  
     //   }  
    //}  
  %>  
    
  <body>  
    <form action="Login.jsp" method="post">  
    用户名：  
    <input type="text" name="username"/><br/>  
    密码：  
    <input type="password" name="password"/><br/>  
    验证码：  
    <img src="yanzhengma.jsp"/>  
    <input type="text" id="code" name="code"/>  
    <input type="submit" value="登录" onclick=" return check();"/>
    </form> 
    
    <script type="text/javascript">
  		function check(){
  			//alert(document.getElementById('code').value);
  			
  			if(document.getElementById('code').value==(<%=rightcode%>)){
  				alert("等");
  			}
  			return false;
  		}
  		
  	</script> 
  </body>  
</html>