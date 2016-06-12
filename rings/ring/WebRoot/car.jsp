<%@page import="bean.Users"%>
<%@page import="bean.Ring"%>
<%@page import="net.ring.dao.impl.RingDaoImpl"%>
<%@page import="bean.Buy"%>
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
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/car.css">

</head>

<body>
<%!ArrayList<Buy> arrayList=null;
 %>
<%
	HttpSession session1 = request.getSession(false);
	arrayList = (ArrayList<Buy>)session1.getAttribute("arrayList");
	//System.out.println(arrayList.size());
	RingDaoImpl ringDaoImpl = new RingDaoImpl();
	//String buynum=(String)session1.getAttribute("buynum");
	//Ring ring = ringDaoImpl.findByRingId();
 %>
 <%	HttpSession session2 = request.getSession();
	Users users = (Users)session2.getAttribute("user");

 %>
<div id="headmain">
      <p id="log_reg">欢迎您:<%=users.getUserName() %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="Login.jsp">退出</a></p>
      <span class="gouwuche"><a href="<%=basePath %>AdminAction?flag=4&userid=<%=users.getUserId()%>">我的订单</a></span>
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
<div id="main">

  <table id="tableinfo" border="1px" rules=rows> 
   <tr>
      <th><input type="checkbox" name="checks" value="all">全选</th><th >商品信息</th><th>单价(元)</th> <th>数量</th><th>金额(元)</th> <th>操作</th>
    </tr>

	<%for(int i=0;i<arrayList.size();i++){ 
		
	%>
	<form>
    <tr>
      <td><input type="checkbox" onclick="show(this),lastmoney(this,<%=i+1 %>);" name="checks" value="1">订单<%=i+1 %></td>
      <td><a href="<%=basePath%>JieHunServlet?flag=<%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getRingImage()%>"><img src="images/<%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getRingImage() %>" width=100 border=0></a></td>
    <%--  <td style="color:#000;font-size:12px">
     净度:<%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getClean() %>&nbsp
     重量:<%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getWeight() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     颜色:<%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getColor() %>
     切工:<%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getCut() %>
     </td>  --%>
     
      <td name="danjia" id="danjia"><%=ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getPrice() %></td>
      <td>
    
      <input type=button value="-" onClick="dec(<%=i+1%>);">
      <input name="shuzi" style="width:35px;" type=text value=<%=arrayList.get(i).getBuyNum()%>>
      <input type=button value="+" onClick="add(<%=i+1%>);">
    
      </td>
      <td name="allmoney"><%=(ringDaoImpl.findByRingId(arrayList.get(i).getRingId()).getPrice())*arrayList.get(i).getBuyNum() %></td>
      <td><input type="button" value="删除" onclick="deleterow(<%=i %>);" style="border:none;color:#f00; font-size:12px; background-color:transparent;border:0px"/>
      		<input type="hidden" name="shanchu" value="sc"/>
      </td>
    </tr>
    </form>
    <%} %>


	<tr>
		<td><input type="checkbox" onclick="chooseall(this);" id="choosealls" name="check" value="all2">全选</td>
		<td><input type="submit" onclick="tijiao();" value="提交" name="tijiao"/></td>
		<td>已选<span id="chosed"></span>个订单</td>
		<td>合计<span id="heji"></span> 元</td>
		<td>结算:¥共<span id="jiesuan"></span> 元</td>
		
	</tr>

   </table>

 <!-- <table id="footer" border="1px">
   <tr>
    <td><input type="checkbox" name="check" value="all2">全选</td>
    <td>提交</td>
    <td>已选 个订单</td>
    <td>合计 元</td>
    <td>结算:¥共 元</td>
   </tr>
</table> -->
</div>

<script type="text/javascript">
	<%-- var tag=<%=tag%>;
	if(tag){
		alert("购买成功，请在我的订单查看");
	} --%>
	
	

	function tijiao(){
		//alert(document.getElementById('choosealls').checked);
		if(!document.getElementById('choosealls').checked){
			alert("请选中所有商品");
		}
		if(document.getElementById('choosealls').checked){
			var money=document.getElementById('jiesuan').innerText;
			
			var url="<%=basePath %>OrderServlet?flag="+money+"";
			window.location.href=url;
		}
	}
	
	

	var alllastmoney=0;
	function lastmoney(obj,i){
		var table = document.getElementById('tableinfo');
		if(obj.checked){
			var temp = table.rows[i].cells[4].innerText;
			var money1=parseInt(temp);
			alllastmoney=alllastmoney+money1;
		}
		document.getElementById('heji').innerText=alllastmoney;
		document.getElementById('jiesuan').innerText=alllastmoney;
		if(!obj.checked){
			var temp = table.rows[i].cells[4].innerText;
			var money1=parseInt(temp);
			alllastmoney=alllastmoney-money1;
		}
		document.getElementById('heji').innerText=alllastmoney;
		document.getElementById('jiesuan').innerText=alllastmoney;
	}

	var num=0;
	function show(obj){
		//document.getElementById('chosed').innerText=5;
		/* var num=0;
		if(table.rows[n].cells[0].getElementsByTagName("input")[0].checked==true){
			num++;
			alert(num);
		}
		if(table.rows[n].cells[0].getElementsByTagName("input")[0].checked==false){
			num--;
		}
		document.getElementById('chosed').innerText=num; */
		
		if(obj.checked){
			num++;
			document.getElementById('chosed').innerText=num;
		}
		if(!obj.checked){
			num--;
			document.getElementById('chosed').innerText=num;
		}
		
	}
	
	function chooseall(obj){
		var table = document.getElementById('tableinfo');
		var rowes=table.rows.length;//5
		//alert(rowes);
		//alert(obj.checked);
		if(obj.checked){
			alllastmoney=0;
			for(var i=1;i<=rowes-2;i++){
				table.rows[i].cells[0].getElementsByTagName("input")[0].checked=true;
				var temp = table.rows[i].cells[4].innerText;
				var money1=parseInt(temp);
				alllastmoney=alllastmoney+money1;
			}  document.getElementById('heji').innerText=alllastmoney;
			document.getElementById('jiesuan').innerText=alllastmoney;
			document.getElementById('chosed').innerText=rowes-2;
			num=rowes-2;
			
		}
		if(!obj.checked){
			alllastmoney=0;
			for(var i=1;i<=rowes-2;i++){
				table.rows[i].cells[0].getElementsByTagName("input")[0].checked=false;
			}  document.getElementById('heji').innerText=0;
			document.getElementById('jiesuan').innerText=alllastmoney;
			document.getElementById('chosed').innerText=0;
			num=0;
		}
		
	}
	
	
	function deleterow(i){//删除某行
		var table = document.getElementById('tableinfo');
		table.deleteRow(i);
		//location.reload();
		var n=i;
		var url="<%=basePath %>DeleteBuy?flag="+n+"";
		window.location.href=url;
		//location.reload();
	}
	
	function add(i){//增加购买数量
		
		var table = document.getElementById('tableinfo');
		var num=table.rows[i].cells[3].getElementsByTagName("input")[1].value;
		var num1=parseInt(num);
		table.rows[i].cells[3].getElementsByTagName("input")[1].value=num1+1;//点击按钮后先+1
		var renum=table.rows[i].cells[3].getElementsByTagName("input")[1].value;
		var truenum=parseInt(renum);
		//var num=table.rows[i].cells[3].childNodes[3].value;
		var danjia=table.rows[i].cells[2].innerText;
		table.rows[i].cells[4].innerText=truenum*danjia;
		if(truenum<=0){
			//alert("请选择");
			table.rows[i].cells[3].getElementsByTagName("input")[0].disabled=true;
			/* if(truenum>1){
				table.rows[i].cells[3].getElementsByTagName("input")[0].disabled=false;
			} */
		}
		if(truenum>0){
		table.rows[i].cells[3].getElementsByTagName("input")[0].disabled=false;
		}
		
	}
	function dec(i){//减少购买数量
		var table = document.getElementById('tableinfo');
		var num=table.rows[i].cells[3].getElementsByTagName("input")[1].value;
		var num1=parseInt(num);
		table.rows[i].cells[3].getElementsByTagName("input")[1].value=num1-1;//点击按钮后先+1
		var renum=table.rows[i].cells[3].getElementsByTagName("input")[1].value;
		var truenum=parseInt(renum);
		//var num=table.rows[i].cells[3].childNodes[3].value;
		var danjia=table.rows[i].cells[2].innerText;
		table.rows[i].cells[4].innerText=truenum*danjia;
		if(truenum<=0){
			//alert("请选择");
			table.rows[i].cells[3].getElementsByTagName("input")[0].disabled=true;
			/* if(truenum>1){
				table.rows[i].cells[3].getElementsByTagName("input")[0].disabled=false;
			} */
		}
		if(truenum>0){
		table.rows[i].cells[3].getElementsByTagName("input")[0].disabled=false;
		}
		
	}
	
	
	// alert(tag); 
	 //if(tag==true){
		//alert("购买成功，请在我的订单查看");
	// }  

</script>
<script type="text/javascript">
		var tag=<%=tag %>;
		//alert(tag);
		if(tag==true){
			alert("下单成功，请查看我的订单");
			var url="<%=basePath%>AdminAction?flag=4&userid=<%=users.getUserId()%>";
			window.location.href=url;
		}
		
	</script>

</body>
</html>
