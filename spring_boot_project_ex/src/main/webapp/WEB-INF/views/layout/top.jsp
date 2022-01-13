<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>프로젝트 예제 : index </title>	
		<link href="css/common.css" rel="stylesheet" type="text/css">
		<link href="css/index.css" rel="stylesheet" type="text/css">
		<link href="css/menu.css" rel="stylesheet" type="text/css">
		<link href="css/slideShow.css" rel="stylesheet" type="text/css">
		<link href="css/tabMenu.css" rel="stylesheet" type="text/css">
		<link href="css/product.css" rel="stylesheet" type="text/css">
		<script src="js/jquery-3.6.0.min.js"></script>
		<script src="js/subMenu.js"></script>
		<script src="js/slideShow.js"></script>
		<script src="js/tabMenu.js"></script>
		<script src="js/index.js"></script>
	</head>
	<body>
		<!-- Header -->
		<header>
			<div id="headerBox">
				<div id="logoBox"><a href="index.html"><img src="image/logo.png" id="logoImg"></a></div>
				<div id="topMenuBox">로그인 이벤트 장바구니 고객센터 회원가입</div>
			</div>
		</header>
		
		<!-- Navigation -->
		<nav>
			<div id="mainMenuBox">
				<ul id="menuItem">
					<li><a href="#">SPECIAL</a></li>
					<li><a href="#">메뉴항목1</a></li>
					<li><a href="#">메뉴항목2</a></li>
					<li><a href="#">메뉴항목3</a></li>
					<li><a href="#">메뉴항목4</a></li>
					<li><a href="#" id="showAllMenu">전체보기 ▼</a></li>
				</ul>				
			</div>  <!-- mainMenuBox 끝 -->
			<div id="subMenuBox">
				<div class="subMenuItem" id="subMenuItem1">
					<ul>
						<li><a href="#">subMenuItem1-1</a></li>
						<li><a href="#">subMenuItem1-2</a></li>
						<li><a href="#">subMenuItem1-3</a></li>
						<li><a href="#">subMenuItem1-4</a></li>
					</ul>
				</div>
				<div class="subMenuItem" id="subMenuItem2">
					<ul>
						<li><a href="#">subMenuItem2-1</a></li>
						<li><a href="#">subMenuItem2-2</a></li>
						<li><a href="#">subMenuItem2-3</a></li>
						<li><a href="#">subMenuItem2-4</a></li>
					</ul>
				</div>
				<div class="subMenuItem" id="subMenuItem3">
					<ul>
						<li><a href="#">subMenuItem3-1</a></li>
						<li><a href="#">subMenuItem3-2</a></li>
						<li><a href="#">subMenuItem3-3</a></li>
						<li><a href="#">subMenuItem3-4</a></li>
					</ul>
				</div>
				<div class="subMenuItem" id="subMenuItem4">
					<ul>
						<li><a href="#">subMenuItem4-1</a></li>
						<li><a href="#">subMenuItem4-2</a></li>
						<li><a href="#">subMenuItem4-3</a></li>
						<li><a href="#">subMenuItem4-4</a></li>
					</ul>
				</div>
				<div class="subMenuItem" id="subMenuItem5">
					<ul>
						<li><a href="#">subMenuItem5-1</a></li>
						<li><a href="#">subMenuItem5-2</a></li>
						<li><a href="#">subMenuItem5-3</a></li>
						<li><a href="#">subMenuItem5-4</a></li>
					</ul>
				</div>
				<div class="subMenuItem" id="subMenuItem6">
					<ul>
						<li><a href="#">subMenuItem6-1</a></li>
						<li><a href="#">subMenuItem6-2</a></li>
						<li><a href="#">subMenuItem6-3</a></li>
						<li><a href="#">subMenuItem6-4</a></li>
					</ul>
				</div>
			</div> <!-- subMenuBox 끝 -->
		</nav>
	</body>
</html>