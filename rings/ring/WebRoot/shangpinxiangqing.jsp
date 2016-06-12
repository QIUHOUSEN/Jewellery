<%@page import="bean.Users"%>
<%@page import="bean.Ring"%>
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
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="css/shangpinxiangqing.css">
	
	
	
  </head>
  
  <body>
  <!-- 头部 -->
<%!Ring ring=null; %>
<%
	HttpSession session2 = request.getSession(false);
	Ring ring = (Ring)session2.getAttribute("ring");
	//ring=(Ring)request.getAttribute("ring");
	//HttpSession sessions = request.getSession();//下面以及这里是得到登录的用户，然后将用户对象封装
	//Ring ring = (Ring)application.getAttribute("ring");
	//ring = (Ring) sessions.getAttribute("ring");
	
 %>
  
 <%	HttpSession session1 = request.getSession();
	Users users = (Users)session1.getAttribute("user");

 %> 
  <div id="headmain">
      <p id="log_reg">欢迎您:<%=users.getUserName() %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="Login.jsp">退出</a></p>
      <span class="gouwuche"><a href="<%=basePath %>JieZhang">我的购物车</a></span>
      
      <p id="web_name">Z  Q  W  Y  Y  L</p>
      <div id="cho_li">
       
        <ul>
           <li>婚庆系列
             <div class="lidiv">
              <div><a href="jiehun.html">订婚系列</a></div>
              <div><a href="jiehun.html">结婚系列</a></div>
              <div><a href="jiehun.html">周年纪念</a></div>
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
  <!-- 正文部分 -->
    <div class="style1">
    <div class="s1">
    
  <span class="s4">&nbsp;<br/>Darry Ring ☛ 求婚钻戒</span><br/>
  <a href="<%=basePath%>BuyNumServlet"><img src="images/<%=ring.getRingImage() %>" /></a>
  <div class="s5">
  <span class="s6">Believe系列 典雅[A07001]</span><br/>
  <span class="s7">&nbsp;<%=ring.getPrice() %></span><br/>
  <font face="宋体" size="3px" color="#6B6B6B">
  最近售出：<%=ring.getSaleNum() %> &nbsp;
  用户评论：<%=ring.getCommentNum() %>&nbsp;
  收藏人气：3514
  </font>
  <hr align="left" size="1" width=400px></hr>
  <div class="s8">
  砖石重量(ct):<%=ring.getWeight() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;钻石颜色(color)：<%=ring.getColor() %><br/>
  <p>
  钻石净度(clarity):<%=ring.getClean() %> &nbsp;&nbsp;&nbsp;钻石切工(cut):<%=ring.getCut() %><br/>
  </div>
  <div class="s9">
  材质:<%=ring.getQuality() %><br/><p/>
  手寸:<select id="select1" name="size">
  <option value="choice">-请选择-</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  </select><br/><p/>
  <form >
  数量：
  <input  type=button value="-" onClick="javascript:this.form.amount.value--;">
  <input id="inputnum" style="width:40px;" type=text name=amount value=1>
  <input  type=button value="+" onClick="javascript:this.form.amount.value++;">
  
  </form>
  
  <p>
  <font size="2px">中国大陆用户付款后15个工作日内可收到货品,其它地区请咨询客服。</font>
  </div>
    <div class="s10">
    <a href="javaScript:getNum()"><div class="s11"> <span>加入购物车</span></div></a>
    
     <%--  <a href="<%=basePath %>CarServlet?flag=<%=ring.getRingImage()%>&flag1"><div class="s11"> <span>加入购物车</span></div></a> --%>
    </div>
    <!--<div class="s12">
      <a href="#"><div class="s11"> <span>立即购买</span></div></a>
    </div>  -->
    
    </div>
    <div id="s13"><img src="images/aixin.png" />只为求你，做我的唯一</div>
    <div style="text-align:center;margin-top:100px;font-size: 15px;color:#A3A3A3;"> @成都东软学院 753382249@qq.com</div>
	
  </div>
    </div>
    <script type="text/javascript">
    
		 function getNum(){
			var num=document.getElementById('inputnum').value;
			var myselect=document.getElementById('select1');
			var myindex=myselect.selectedIndex;
			var size=myselect.options[myindex].value;
			//alert(size);
			var url="<%=basePath %>CarServlet?flag="+num+"&flag1=<%=ring.getRingImage()%>&flag2="+size+"";
			if(size=="choice"){
				alert("请选择尺寸");
				return;
			}
			window.location.href=url;
		} 
		/* function tiaozhuan(){
			var url="/ring/JieZhang";
			window.location.href=url;
		} */
		
		<%-- var tag=<%=tag %>;
		alert(tag); --%>
		/* if(tag==true){
			alert("已添加到购物车");
		} */
		
		
	</script>
    <script type="text/javascript">
		var tag=<%=tag %>;
		//alert(tag);
		if(tag==true){
			alert("已加到购入车，请查看我的购物车！");
		}
		
	</script>
    
  </body>
</html>
