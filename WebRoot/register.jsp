<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Home</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--slider-->
<link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    function check(){
        var userName=document.getElementById("userName").value;
        if(userName==""||userName.length>=11)
        {
           alert("提示\n\n昵称不能为空且长度不能超过11位");
           return false;
        }
        var tel=document.getElementById("tel").value;
        var myreg1=/^1[0-9]{10}$/;
        if(!myreg1.test(tel))
        {
           alert("提示\n\n电话形式为1xxx-xxxx-xxx，x代表数字");
           return false;
        }   
        var email=document.getElementById("email").value;
        var myreg2= /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!myreg2.test(email))
        {
           alert("提示\n\n请输入有效的E_mail!");
           return false;
        }
        var psd=document.getElementById("password").value;
        var psdc=document.getElementById("passConfirm").value;
        if(psd!=psdc||psd.length>=16||psdc.length>=16)
        {
           alert("提示\n\n两次输入密码不相同且密码长度不能超过16");
           return false;
        }
        else if(psd==""||repsd=="")
        {
           alert("提示\n\n输入密码不能为空");
           return false;
        }   
    }
    
    </script>
</head>
<body>
    <!-- NavBar -->
    <div class="header">
      <div class="wrap">
        <div class="header-top">
             <div class="logo">
                 <a href="home_after_login.jsp"><img src="images/logo.png" alt=""></a>
             </div>
             <div class="menu">
                <div id="cssmenu">
                    <ul>
                       <li class="active"><a href="home_after_login.jsp"><span>Home</span></a></li>
                       <li class="has-sub"><a href="NewsInfo" ><span>News</span></a></li>
                       <li><a href="CarInfo"><span>Gallery</span></a></li>
                       <li class="last"><a href="ShowAllMessages"><span>Messages</span></a></li>
                    </ul>
                </div>
              </div>
              <div class="clear"></div>
           </div>
       </div>
    </div>
    <!-- End NavBar -->
    <!-- MainContent -->
    <div class="main">
    <div class="content-top">
        <div class="wrap">
            <div class="about">
                <div class="section group">
                        <p align="center"><font color="#ffffff" size="6">欢迎注册租车系统:</font></p><br>
                        <form action="UserRegister"   method="post" onsubmit="return check();">
                        <p align="center"><font color="#ffffff">昵称：</font><input type="text" name="userName" id="userName"></p><br>
                        <p align="center"><font color="#ffffff">姓名：</font><input type="text" name="realName" id="realName"></p><br>
                        <p align="center"><font color="#ffffff">手机号：</font><input type="text" name="tel" id="tel"></p><br>
                        <p align="center"><font color="#ffffff">邮箱：</font><input type="text" name="email" id="email"></p><br>
                        <p align="center"><font color="#ffffff">密码：</font><input type="password" name="password" id="password"></p><br>
                        <p align="center"><font color="#ffffff">确认密码：</font><input type="password" name="passConfirm" id="passConfirm"></p><br>
                        <p align="center"><input class="login1" type="submit" name="passConfirm" value="注册" onclick="check()"></p><br>

                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
    <!-- End MainContent -->
    <!-- Footer -->
    <div class="footer">
        <div class="wrap">
            <div class="footer-top">
                <div class="col_1_of_4 span_1_of_4">
                    <h3>INFORMATION</h3>
                    <ul class="first">
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Terms and conditions</a></li>
                        <li><a href="#">Legal Notice</a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4">
                    <h3>CATEGORIES</h3>
                    <ul class="first">
                        <li><a href="#">New products</a></li>
                        <li><a href="#">top sellers</a></li>
                        <li><a href="#">Specials</a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4">
                    <h3>My ACCOUNT</h3>
                    <ul class="first">
                        <li><a href="login.jsp">Your Account</a></li>
                        <li><a href="login.jsp">Charge Info</a></li>
                        <li><a href="login.jsp">Prices</a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4 footer-lastgrid">
                    <h3>CONTACT US</h3>
                    <ul class="last">
                            <li><span>+91-123-456789</span></li>
                            <li><span>+00-123-000000</span></li>
                        </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div class="copy">
                <p>Copyright &copy; 2016.Company All rights reserved.</p>
            </div>
        </div>
    </div>
    <!-- End Footer -->
</body>
</html>