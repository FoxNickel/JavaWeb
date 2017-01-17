<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                            <li><a href="NewsInfo" ><span>News</span></a></li>
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
        <div class="content-top">
            <div class="wrap">
                <div class="about">
                    <div class="heading4">
                        <h2>Cars For You</h2>
                    </div>
                    <div class="section group">
                    <!-- 动态获取汽车信息 -->
					<s:iterator value="#request.cars" status="s" var="o">
                    <c:set var="a" value="${s.getIndex() }"></c:set>
                    <div class="grid_1_of_4 images_1_of_4">
							<a href="images/t-pic${a+5 }.jpg" class="swipebox" title="Image Title">
								<img src="images/pic${a+5 }.jpg" alt=""><span class="zoom-icon"></span>
							</a>
							<h4>${cars[a].getCarName() } 车辆编号：${cars[a].getCarID() }</h4>
							<p>租金:${cars[a].getPrice() }/天</p>
							<p>
								是否被租:
								<c:if test="${!cars[a].getIsRented()}">否</c:if>
								<c:if test="${cars[a].getIsRented()}">是</c:if>
							</p>
							<a href="CarDetail" class="link">Read More</a>
					</div>
					</s:iterator>
					<div class="clear"></div>
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