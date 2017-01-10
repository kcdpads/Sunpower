<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
  		<tiles:insertAttribute name="header"/>
  	</head>
  	<body>
		<tiles:insertAttribute name="top"/>
		<tiles:insertAttribute name="logo"/>
		<tiles:insertAttribute name="nav"/>
		<div class="divide70"></div>
		<tiles:insertAttribute name="content"/>
		<div class="divide40"></div>
	  	<tiles:insertAttribute name="footer"/>
	  	<!--scripts and plugins -->
        <!--must need plugin jquery-->
        <script src="js/bootstrap2/jquery.min.js"></script>
        <script src="js/bootstrap2/jquery-migrate.min.js"></script> 
        <!--bootstrap js plugin-->
        <script src="js/bootstrap2//bootstrap.min.js" type="text/javascript"></script>       
        <!--easing plugin for smooth scroll-->
        <script src="js/bootstrap2/jquery.easing.1.3.min.js" type="text/javascript"></script>
        <!--flex slider plugin-->
        <script src="js/bootstrap2/jquery.flexslider-min.js" type="text/javascript"></script>
        <!--sticky header-->
        <script type="text/javascript" src="js/bootstrap2/jquery.sticky.js"></script>
        <!--parallax background plugin-->
        <script src="js/bootstrap2/jquery.stellar.min.js" type="text/javascript"></script>
        <!--owl carousel slider-->
        <script src="js/bootstrap2/owl.carousel.min.js" type="text/javascript"></script>
        <script src="js/bootstrap2/classie.js" type="text/javascript"></script>
        <script src="js/bootstrap2/selectFx.js" type="text/javascript"></script>
        <!--revolution slider plugins-->
        <script src="js/bootstrap2/rs-plugin/jquery.themepunch.tools.min.js" type="text/javascript"></script>
        <script src="js/bootstrap2/rs-plugin/jquery.themepunch.revolution.min.js" type="text/javascript"></script>
         <script src="js/bootstrap2/tweetie.min.js" type="text/javascript"></script>
        <!--on scroll animation-->
        <script src="js/bootstrap2/wow.min.js" type="text/javascript"></script>
        <!--customizable plugin edit according to your needs-->
        <script src="js/bootstrap2/real-estate-custom.js" type="text/javascript"></script>
  	</body>
</html>