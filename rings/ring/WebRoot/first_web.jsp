<%@page import="bean.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/first.css" type="text/css" rel="stylesheet" />
<title>璀璨人生 </title>
<script defer='defer'>
<!--
    var curOpac = 0;
    var filterTimer;
    var isIE = /internet explorer/i.test(window.navigator.appName);
    function MyScroll(cnt, control){
        this.data = [];  // 存放图片路径
    this.interval = 3000;  // 过渡一次的间隔时间(过渡时间+图片显示时间)
        this.timer;  // 定时器：控制当前显示的图片
    this.container = cnt;
        this.curFrame = 0;
        this.oldFrame = 0;
        this.controls = control;  // 按钮集合
    Global = this;          // 获取对象的指针
    this.run = function(){
         this.timer = window.setInterval("Global.showFrame()", this.interval);
        }
        // 按钮的处理程序
        this.go = function(i){
            curOpac = 0; // 透明度归0
            this.curFrame = i;  // 当前要过渡的图片
            this.stop();  // 清空计时器
            this.showFrame();  // 当前图片过渡
            this.run();  // 循环播放
        }
        this.stop = function(){
            window.clearInterval(this.timer);
            window.clearInterval(filterTimer);
        }
        this.showFrame = function(){
            // 设置当前按钮样式
      this.controls[this.oldFrame].style.backgroundColor = "white";
            this.controls[this.curFrame].style.backgroundColor = "gray";
            if(isIE) this.container.style.filter = "alpha(opacity=0)";
            else this.container.style.cssText = "-moz-opacity:0";
            this.container.innerHTML = this.data[this.curFrame];
            filterTimer = window.setInterval("blend()", 100);
            this.oldFrame = this.curFrame;
            this.curFrame ++;
            if(this.curFrame == this.data.length){
                this.curFrame = 0;
            }            
        }
    }
     // 增加透明度
    function blend(){
        curOpac+=10;
        if(isIE) Global.container.style.filter='alpha(opacity=' + curOpac + ')';
        else Global.container.style.cssText = "-moz-opacity:" + curOpac/100.0;

        if(curOpac == 100){
            curOpac = 0;
            window.clearInterval(filterTimer);
        }
    }
    //开始
    function startIt(){
        var imgArr = [];
        // 创建4个图片对象保存图片路径
        for(var i=0;i<4;i++){
            imgArr[i] = new Image();
            imgArr[i].src = "images/1_" + (i + 7) + ".jpg";
        }
        var controlArr = $("mainTb").getElementsByTagName("span");
        for(var i=0;i<controlArr.length;i++){
            controlArr[i].tag = i;
            controlArr[i].onclick = function(){
                myScroll.go(this.tag);
            }
        }
        var myScroll = new MyScroll($("cnt"), controlArr);
        myScroll.data.push("<img src='" + imgArr[0].src + "'>");
        myScroll.data.push("<img src='" + imgArr[1].src + "'>");
        myScroll.data.push("<img src='" + imgArr[2].src + "'>");
        myScroll.data.push("<img src='" + imgArr[3].src + "'>");
        myScroll.go(0);
    }
    window.onload = startIt;
    function $(id){ return document.getElementById(id);}
//-->
</script>
</head>

<body>
<%	HttpSession session1 = request.getSession();
	Users users = (Users)session1.getAttribute("user");

 %>

<div in="main">
   <div id="headmain">
      <p id="log_reg">欢迎您:<%=users.getUserName() %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="Login.jsp">退出</a></p>
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
   <div id="lunbo_picture">
           
           <div id="cnt"></div>
           <table width="300" height="30" id="mainTb">
                  <tr id="button">
                   <td><span class="ctrl">&nbsp;1&nbsp;</span></td>
                   <td><span class="ctrl">&nbsp;2&nbsp;</span></td>
                   <td><span class="ctrl">&nbsp;3&nbsp;</span></td>
                   <td><span class="ctrl">&nbsp;4&nbsp;</span></td>
                   <td><span class="ctrl">&nbsp;5&nbsp;</span></td>
                   <td><span class="ctrl">&nbsp;6&nbsp;</span></td>
                  </tr>
          </table>
   </div>
   <div id="info">
       <p class="new_name">ZQWYYL系列</p>
       <div id="dian_lun">
           <img class="pic" src="images/zhuan_1.png" width="180px" height="180px" />
           <img class="pic" src="images/zhuan_2.png" width="180px" height="180px" />
           <img class="pic" src="images/zhuan_3.png" width="180px" height="180px" />
           <img class="pic" src="images/zhuan_4.png" width="180px" height="180px" />
           <img class="pic" src="images/zhuan_5.png" width="180px" height="180px" />
       </div>
       <p id="pic_info">
       <span>幸运之星系列</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span>好望角系列</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span>戴安娜系列</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span>vava系列</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span>银河系列</span></p>
       <div id="pic_left">
          <img id="leftjpg" src="images/pic_left.jpg" width="400px" height="350px"/>
          <p class="pic_leftinfo"><b>世间最迷人的色彩，来自彩虹落点</b></p>
       </div>
       <div id="pic_right">
          <img id="rightjpg1" src="images/pic_right1.jpg" width="400px" height="150px"/>
          <p class="pic_rightinfo"><b>璀璨如你，唯有绝世之钻</b></p>
          <img id="rightjpg2" src="images/pic_right2.jpg" width="400px" height="150px"/>
          <p class="pic_rightinfo"><b>国际知名设计师倾情巨献</b></p>
       </div>
       
       <div id="footer">
            <div>版权所有©javaweb小组(LQWYYZ)</div>
            <div>公司名称：LQWYYZ设计有限公司</div>
            <div>通讯地址：成都东软学院</div>
            <div>电话：88888888</div>
       </div>
   </div>
   
</div>
</body>
</html>
