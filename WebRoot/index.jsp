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
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
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
                    <div class="col_1_of_2 span_1_of_2">
                        <p class="title1">Rent</p>
                        <p class="title2">Cars Rental Service</p>
                        <a href="login.jsp" class="btn">Login in</a>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- End MainContent -->
    <!------ Slider ------------>
    <div class="slider">
        <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="images/banner2.jpg" alt="" />
                <img src="images/banner1.jpg" alt="" />
                <img src="images/banner3.jpg" alt="" />
                <img src="images/banner4.jpg" alt="" />
                <img src="images/banner5.jpg" alt="" />
            </div>
        </div>
    </div>
    <!------End Slider ------------>
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