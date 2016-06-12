<%@ page language="java" import="java.util.*,bean.Comment,java.util.ArrayList" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tag = request.getParameter("tag")==null ? "":(String)request.getParameter("tag");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评论</title>

<style type="text/css">
	.div1{
		margin: 0 auto;
		width:900px;
	}
	tr{
		width:900px;
		height:50px;
	}
	
	.text{
		width:900px;
		height:100px;
		position:fixed;
		z-index:9999;
		margin-top:0px;
		background-color:#FFFACD;
		text-align:left;
	}
	.fabiao{
		position:fixed;
		z-index:9999;
		margin-top:110px;
	}
	
	#test{
	width:900px;
		height:100px;
		position:absolute;
		margin-top:1000px;
	}
</style>

</head>

<body>
	<div class="div1">
	  
	 <!--<form action="CommentServlet?flag=1" method="post">-->
	<form action="<%=basePath%>CommentServlet" method="post">
	<p><input type="hidden" name="hidringid" value="<%=request.getAttribute("ringid")%>"/></p>
        <table rules="rows" frame="hsides" width="900px">
         <%
         	ArrayList<Comment> list = (ArrayList<Comment>)request.getAttribute("list");
        // Iterator it = list.iterator();//迭代器指向集合
         for(int i=0;i<list.size();i++){%>
         <tr><td>用户id:<%=list.get(i).getUserId()%>&nbsp;<%=list.get(i).getContent()%></td></tr>
        	 
         <% }%>
         
         
         
 		
         
         
  
		
        </table>
        
      
        <textarea class="text" name="pinlun">
        
   		</textarea>
      
        <div class="fabiao">
       	 	<input type="submit" value="发表" style="width:100px;height:35px"/>
        </div>
      </form>
    </div>  
    <div id="test"></div>
        	
   
        
	
		
</body>
</html>
