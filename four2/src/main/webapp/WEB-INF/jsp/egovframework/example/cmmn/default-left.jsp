<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	var left = {
		pageSubmitFn : function(pageName) {

			$("#pageName").val(pageName);

			$("#signTrgNo").val("test");

			if (pageName == "welcomeWebMenu") {

				// form 태그의 속성중 anction 속성은 입력한 데이터를 해당 주소로 지정하는 역할
				$("#frm").attr("action", "welcomeWeb.do");
			} else if (pageName == "mainMenu") {

				$("#frm").attr("action", "main.do");
			} else if (pageName == "jqgridMenu") {

				$("#frm").attr("action", "jqgridP2.do");
			} else if (pageName == "uploadMenu") {

				$("#frm").attr("action", "uploadStart.do");
			} else if (pageName == "fourFree") {

				$("#frm").attr("action", "fourFree.do");
			} else if (pageName == "fourCh") {

				$("#frm").attr("action", "fourCh.do");
			} else if (pageName == "fourCh2") {

				$("#frm").attr("action", "fourCh2.do");
			} else if (pageName == "registerMenu") {

				$("#frm").attr("action", "register.do");
			}

			// 입력한 데이터를 전송하는 역할
			$("#frm").submit();
		}
	}

	$(document).ready(function() {

		var pageName = "<c:out value="${param.pageName}"/>";

		$("[prop=menu]").removeClass("active");

		$("#" + pageName).addClass("active");
		
		alert( "<c:out value="${param.signTrgNo}"/>");
	});
</script>

<form id="frm" name="frm">
	<input type="hidden" id="pageName" name="pageName" /> <input
		type="hidden" id="signTrgNo" name="signTrgNo" />
</form>

<div class="sidebar" data-color="orange"
	data-image="images/bootstrap/full-screen-image-3.jpg">
	<!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->

	<div class="logo">
		<a href="http://www.creative-tim.com" class="logo-text"> HANQ TEAM
		</a>
	</div>
	<div class="logo logo-mini">
		<a href="http://www.creative-tim.com" class="logo-text"> Ct </a>
	</div>

	<div class="sidebar-wrapper">

		<div class="user">
			<div class="photo">
				<img src="images/bootstrap/default-avatar.PNG" />
			</div>
			<div class="info">
				<a data-toggle="collapse" href="#collapseExample" class="collapsed">
					HANQ <b class="caret"></b>
				</a>
				<div class="collapse" id="collapseExample">
					<ul class="nav">
						<li><a href="#">My Profile</a></li>
						<li><a href="#">Edit Profile</a></li>
						<li><a href="#">Settings</a></li>
					</ul>
				</div>
			</div>
		</div>

		<ul class="nav">
			<li prop="menu" class="active" id="mainMenu"><a href="#"
				onclick="javascript:left.pageSubmitFn('mainMenu')"> <i
					class="pe-7s-graph"></i>
					<p>HOME</p>
			</a></li>
			<li><a data-toggle="collapse" href="#componentsExamples"
				aria-expanded="true"> <i class="pe-7s-plugin"></i>
					<p>
						난 정말 아무것도 몰라요 <b class="caret"></b>
					</p>
			</a>
				<div class="collapse in" id="componentsExamples">
					<ul class="nav">
						<li prop="menu" class="active" id="welcomeWebMenu"><a
							href="#" onclick="javascript:left.pageSubmitFn('welcomeWebMenu')">시작해봅시다.</a></li>
						<li prop="menu" id="jqgridMenu"><a href="#"
							onclick="javascript:left.pageSubmitFn('jqgridMenu')">JQGRID</a></li>
						<li prop="menu" id="fourFree"><a href="#"
							onclick="javascript:left.pageSubmitFn('fourFree')">4주 프리</a></li>
						<li prop="menu" id="fourCh"><a href="#"
							onclick="javascript:left.pageSubmitFn('fourCh')">4주 취업</a></li>
						<li prop="menu" id="fourCh2"><a href="#"
							onclick="javascript:left.pageSubmitFn('fourCh2')">4주 취업2</a></li>
					</ul>
				</div></li>

			<li prop="menu" id="uploadMenu"><a data-toggle="collapse"
				href="#" onclick="javascript:left.pageSubmitFn('uploadMenu')"> <i
					class="pe-7s-note2"></i>
					<p>
						업로드 할줄 안다고.. <b class="caret"></b>
					</p>
			</a></li>

			<li><a data-toggle="collapse" href="#mapsExamples"> <i
					class="pe-7s-map-marker"></i>
					<p>
						라디오 체크 마스터~ <b class="caret"></b>
					</p>
			</a>
				<div class="collapse" id="mapsExamples">
					<ul class="nav">
						<li prop="menu"><a href="../maps/google.html">Google Maps</a></li>
						<li prop="menu"><a href="../maps/vector.html">Vector Maps</a></li>
						<li prop="menu"><a href="../maps/fullscreen.html">Full
								Screen Map</a></li>
					</ul>
				</div></li>

			<li><a href="../charts.html"> <i class="pe-7s-graph1"></i>
					<p>comming soon..</p>
			</a></li>

			<li><a href="../calendar.html"> <i class="pe-7s-date"></i>
					<p>팝업 마스터</p>
			</a></li>

			<li><a data-toggle="collapse" href="#pagesExamples"> <i
					class="pe-7s-gift"></i>
					<p>
						ready.. <b class="caret"></b>
					</p>
			</a>
				<div class="collapse" id="pagesExamples">
					<ul class="nav">
						<li prop="menu" id="loginMenu"><a href="#">Login Page</a></li>
						<li prop="menu" id="registerMenu"><a href="#"
							onclick="javascript:left.pageSubmitFn('registerMenu')">Register
								Page</a></li>
						<li prop="menu"><a href="../pages/lock.html">Lock Screen
								Page</a></li>
						<li prop="menu"><a href="../pages/user.html">User Page</a></li>
						<li prop="menu"><a href="#">More coming soon...</a></li>
					</ul>
				</div></li>
		</ul>
	</div>
</div>