<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="util.Dbutil"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="bean.Users"%>
<%@page import="bean.Ring"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/jiehun.css" type="text/css" rel="stylesheet" />
<title>婚庆系列</title>
</head>

</body>
<%	HttpSession session1 = request.getSession();
	Users users = (Users)session1.getAttribute("user");

 %>
<div id="main">
  <div id="headmain">
      <p id="log_reg">欢迎您:<%=users.getUserName() %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="Login.jsp">退出</a></p>
      <%-- <span class="gouwuche"><a href="<%=basePath %>JieZhang">我的购物车</a></span> --%>
      <span class="gouwuche"><a href="<%=basePath %>AdminAction?flag=4&userid=<%=users.getUserId()%>">我的订单</a></span>
      
      <p id="web_name">Z  Q  W  Y  Y  L</p>
      <div id="cho_li">
       
        <ul>
           <li>婚庆系列
             <div class="lidiv">
              <div><a href="<%=basePath%>BuyNumServlet">订婚系列</a></div>
              <div><a href="<%=basePath%>BuyNumServlet">结婚系列</a></div>
              <div><a href="<%=basePath%>BuyNumServlet">周年纪念</a></div>
             </div>
           
           </li>
           <li>经典系列
             <div class="lidiv">
              <div><a href="classics.html">设计师系列</a></div>
              <div><a href="classics.html">经典砖石系列</a></div>
              <div><a href="classics.html">炫耀系列</a></div>
             </div>
           </li>
           <li>天然宝石
             <div class="lidiv">
              <div><a href="tianran.html">橄榄石</a></div>
              <div><a href="tianran.html">碧玺</a></div>
              <div><a href="tianran.html">红宝石</a></div>
              <div><a href="tianran.html">海蓝宝</a></div>
              <div><a href="tianran.html">玫瑰石榴石</a></div>
             </div>
           </li>
           <li>认识珠宝
             <div class="lidiv">
              <div><a href="zhubaozhishi.html">珠宝知识</a></div>
              <div><a href="zhubaodapei.html">珠宝搭配</a></div>
              <div><a href="baoyangchangshi.html">保养常识</a></div>
              </div>
           </li>
        </ul></a>
        <!--<div id="hiddendiv"></div> -->
      </div>
    <!--  <div id="hiddendiv"></div> -->
   </div>
   <div id="downall">
   		
        <ul id="ulblock">
        	<li><a href="javascript:void(0)" id="right11" name="right11" onclick="show(0);">订婚系列</a></li>
            <li><a href="javascript:void(0)" id="right11" name="right11" onclick="show(1);">结婚系列</a></li>
            <li><a href="javascript:void(0)" id="right11" name="right11" onclick="show(2);">周年纪念</a></li>
          <!--这样写也可以  <li id="right11" name="right11" onclick="show(0);">订婚系列</li>
            <li id="right11" name="right11" onclick="show(1);">结婚系列</li>
            <li id="right11" name="right11" onclick="show(2);">周年纪念</li>-->
        </ul>  
        
        <%
       int[] num = (int[])request.getAttribute("buynum");
       
        //连接数据库取得数据  By邹娟
       Connection con=Dbutil.getConnection();
		ArrayList<Ring> list=new ArrayList<Ring>();
		String sql="select * from ring"; 
		PreparedStatement pst=null;
		ResultSet rs1=null;
		try {
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs1 = pst.executeQuery();
			int index=0;
			while(rs1.next())
			{
				index++;
				if(index<=6){
				Ring ringjl=new Ring();
				ringjl.setClean(rs1.getString("Clean"));
				ringjl.setColor(rs1.getString("Color"));
				ringjl.setCommentNum(rs1.getInt("commentNum"));
				ringjl.setCut(rs1.getString("Cut"));
				ringjl.setPrice(Integer.parseInt(rs1.getString("Price")));
				ringjl.setQuality(rs1.getString("Quality"));
				ringjl.setRingImage(rs1.getString("RingImage"));
				ringjl.setSaleNum(rs1.getInt("SaleNum"));
				ringjl.setSize(rs1.getInt("Size"));
				ringjl.setWeight(rs1.getString("Weight"));
				list.add(ringjl);
				}
				else break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        int len=list.size(),hang=0;
		if((len%3)!=0)
		{
		hang=(len/3)+1;
		}
		else{
		hang=len/3;
		}    
       %>
        
    	<div id="right1" name="right">
    	<table id="NextPage" border="0"> 
    	 <% 
    	 int qd=0;
    	 for(int xb=0;xb<hang;xb++)
    	 {%>
    	 <tr>
    	  <%for(int p=qd;p<qd+3;p++)
    	   {if(p>=len) break;
    	   %>
    	   <td>
    	   <div id="onezhubao">
    	   
            	<a href="<%=basePath %>JieHunServlet?flag=<%=list.get(p).getRingImage()%>"><div id="onezhubaodiv" class="picture" >
				 <img src="images/<%=list.get(p).getRingImage()%>"  width="150px" height="150px"/>
				 </div></a>                        
                <div id="onezhubaowenzi">
                	<p>$<%=list.get(p).getPrice() %></p>
                    <p>True Love系列&nbsp;典雅&nbsp;40分&nbsp;<%=list.get(p).getColor() %>色</p>
                    <p><div>已售:<%=list.get(p).getSaleNum()%></div></p>
                    <p><div><a href="<%=basePath%>PinLunServlet?flag=<%=list.get(p).getRingImage()%>">评价</a>:</div></p>
                    <div><a href="<%=basePath %>JieHunServlet?flag=<%=list.get(p).getRingImage()%>" id="xiangqing">查看详情</a></div>
                    
                    <!--<p>钻石重量(ct)：0.3</p>  
                  	<p>钻石颜色(color)：F</p>
                    <p>钻石净度(clarity)：VS2</p>
                    <p>钻石切工(cut)：VG</p>-->
                </div>
            </div>
    	   </td>
    	   <%}%>
    	 </tr>
    	<%qd=qd+3;
    	}
    	 %>
         </table>
        </div>	
        
        <div id="right2" name="right">
       <table id="NextPage" border="0"> 
    	 <% 
    	 qd=0;
    	 for(int xb=0;xb<hang;xb++)
    	 {%>
    	 <tr>
    	  <%for(int p=qd;p<qd+3;p++)
    	   {if(p>=len) break;
    	   %>
    	   <td>
    	   <div id="onezhubao">
    	  
            	<a href="<%=basePath %>JieHunServlet?flag=<%=list.get(p).getRingImage()%>"><div id="onezhubaodiv" class="picture" >
				 <img src="images/<%=list.get(p).getRingImage()%>"  width="150px" height="150px"/>
				 </div></a>                        
                <div id="onezhubaowenzi">
                	<p>$<%=list.get(p).getPrice() %></p>
                    <p>True Love系列&nbsp;典雅&nbsp;40分&nbsp;<%=list.get(p).getColor() %>色</p>
                    <p><div>已售:<%=list.get(p).getSaleNum()%></div></p>
                    <p><div><a href="<%=basePath%>PinLunServlet?flag=<%=list.get(p).getRingImage()%>">评价</a>:</div></p>
                    <div><a href="<%=basePath %>JieHunServlet?flag=<%=list.get(p).getRingImage()%>" id="xiangqing">查看详情</a></div>
                    
                    <!--<p>钻石重量(ct)：0.3</p>  
                  	<p>钻石颜色(color)：F</p>
                    <p>钻石净度(clarity)：VS2</p>
                    <p>钻石切工(cut)：VG</p>-->
                </div>
            </div>
    	   </td>
    	   <%}%>
    	 </tr>
    	<%qd=qd+3;
    	}
    	 %>
         </table>
        </div>
        
        <div id="right3" name="right">
    
           <table id="NextPage" border="0"> 
    	 <% 
    	 qd=0;
    	 for(int xb=0;xb<hang;xb++)
    	 {%>
    	 <tr>
    	  <%for(int p=qd;p<qd+3;p++)
    	   {if(p>=len) break;
    	   %>
    	   <td>
    	   <div id="onezhubao">
    	  
            	<a href="<%=basePath %>JieHunServlet?flag=<%=list.get(p).getRingImage()%>"><div id="onezhubaodiv" class="picture" >
				 <img src="images/<%=list.get(p).getRingImage()%>"  width="150px" height="150px"/>
				 </div></a>                        
                <div id="onezhubaowenzi">
                	<p>$<%=list.get(p).getPrice() %></p>
                    <p>True Love系列&nbsp;典雅&nbsp;40分&nbsp;<%=list.get(p).getColor() %>色</p>
                    <p><div>已售:<%=list.get(p).getSaleNum()%></div></p>
                    <p><div><a href="<%=basePath%>PinLunServlet?flag=<%=list.get(p).getRingImage()%>">评价</a>:</div></p>
                    <div><a href="<%=basePath %>JieHunServlet?flag=<%=list.get(p).getRingImage()%>" id="xiangqing">查看详情</a></div>
                    
                    <!--<p>钻石重量(ct)：0.3</p>  
                  	<p>钻石颜色(color)：F</p>
                    <p>钻石净度(clarity)：VS2</p>
                    <p>钻石切工(cut)：VG</p>-->
                </div>
            </div>
    	   </td>
    	   <%}%>
    	 </tr>
    	<%qd=qd+3;
    	}
    	 %>
         </table>
        </div>    <a style="position: absolute; left: 700px; top: 750px;" href="<%=basePath %>NextPage">下一页</a>
        
        <div id="bottom">
        	<div>版权所有©javaweb小组(LQWYYZ)</div>
            <div>公司名称：LQWYYZ设计有限公司</div>
            <div>通讯地址：成都东软学院</div>
            <div>电话：88888888</div>
        </div>
        
   </div>
   
   <script type="text/javascript">
   		var lis=document.getElementsByName("right11");
		var divs=document.getElementsByName("right");
		function show(i){
			for(var j=0;j<lis.length;j++){
				if(i!=j){
					divs[j].style.display="none";	
				}else{
					divs[j].style.display="block";	
				}				
			}
		}
   		
   </script>
   
   
</div>
</html>
