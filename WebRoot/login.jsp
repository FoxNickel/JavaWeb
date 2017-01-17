<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>login</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<!-- NavBar -->
<div class="header">
    <div class="wrap">
        <div class="header-top">
            <div class="logo">
                <a href="index.jsp"><img src="images/logo.png" alt=""></a>
            </div>
            <div class="menu">
                <div id="cssmenu">
                    <ul>
                        <li class="active"><a href="index.jsp"><span>Home</span></a></li>
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
    <div class="content-middle">
        <div class="wrap">
            <div class="section group example">
                <div class="col_1_of_2 span_1_of_2">
                    <div class="thumb-pad3">
                        <figure><img src="images/pic3.jpg" alt=""><em class="sp1"></em></figure>
                    </div>
                </div>
                <div class="col_1_of_2 span_2_of_2">
                    <div class="form">
                        <form class="login" name="login" action="UserLogin" method="post">
                            用户名：<input class="name1" type="text" name="userName"><br>
                            密&nbsp;码：<input class="name1" type="password" name="password">
                            <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" class="login1" name="login" value="登录">&nbsp;&nbsp;&nbsp;
                            <input type="submit" class="login1" name="login" value="注册" onclick="register()">
                        </form>
                        <script language="JavaScript"> 
							function register() 
							{ 
								document.login.action="register.jsp"; 
								document.login.submit();
							} 
						</script>
                    </div>
                </div>
                <div class="clear"></div>
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



