<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Gallery</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!------ Light Box ------>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" href="css/swipebox.css">
<script src="js/ios-orientationchange-fix.js"></script> 
<script src="js/jquery.swipebox.min.js"></script> 
<script type="text/javascript">
		jQuery(function($) {
			$(".swipebox").swipebox();
		});
	</script>
	<!------ Eng Light Box ------>	
	<style type="text/css">
	.main {
	
    background: #252425;
    height:50%;
    
    
}
.main-box
{
margin-left:10%;}
	</style>
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
                            <li><a href="index.jsp"><span>Home</span></a></li>
                            <li><a href="NewsInfo"><span>News</span></a></li>
                            <li class="active"><a href="CarInfo"><span>Gallery</span></a></li>
                            <li><a href="ShowAllMessages"><span>Messages</span></a></li>
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
    <div class="main-box">
        <!--car box-->
			<div class="car-box">
				<em style="display: none;"></em>
				<div class="car-img">

					<img src="images/pic${index+5 }.jpg" alt="这是一两车的图片">
				</div>
				<form action="Rent" method="Post" id="form0" method="post">
					<div class="car-info">
						<div class="car-name" style="color:white;">${carName }</div>
						<div class="car-name" style="color:white;">${carID }</div>
						<input type="hidden" name="carName" value="${carName }">
						<input type="hidden" name="carID" value="${carID }">
						<p style="color:white;">
							<span><b>取车城市：</b> 
							<input type="text" name="rentedplace" value="上海">
						</p>
						<p style="color:white;">
							<span><b>取车时间：</b> <input value="20161218"  name="rantedDay" ></span> 
							<span><b>还车时间：</b> <input value="20161219"   name="circulateDay" ></span>
							 <input type="submit" value="确认">
						</p>
					</div>
				</form>
			</div>

			<div class="store-box" id="J_StoreBoxe">
        </div>
        <!--store box-->
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
                        <li><a href="AccountInfo">Your Account</a></li>
						<li><a href="ChargeInfo">Charge Info</a></li>
						<li><a href="UserLogout">Log out</a></li>
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