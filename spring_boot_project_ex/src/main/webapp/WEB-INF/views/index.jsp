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
		<div id="wrap">
			<header>
				<div id="headerBox">
					<div id="logoBox"><a href="index.html"><img src="image/logo.png" id="logoImg"></a></div>
					<div id="topMenuBox">로그인 이벤트 장바구니 고객센터 회원가입</div>
				</div>
			</header>
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
			<section>
				<article id="slideShow"> <!-- 슬라이드 쇼  -->
					<!-- 이전/다음 버튼 -->
					<div id="prevNextButtonBox">
						<img id="prevButton" src="image/prevButton.png">
						<img id="nextButton" src="image/nextButton.png">
					</div>				
					<div id="slideShowBox">
						<div id="slidePanel">
							<img src= "image/slide_img_01.jpg" class="slideImage">
							<img src= "image/slide_img_02.jpg" class="slideImage">
							<img src= "image/slide_img_03.jpg" class="slideImage">
							<img src= "image/slide_img_04.jpg" class="slideImage">
							<img src= "image/slide_img_05.jpg" class="slideImage">
						</div>
					</div> <!-- slideShowBox 끝 -->
					<div id = "controlPanel">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
						<img src="image/controlButton1.png" class="controlButton">
					</div>
				</article>
				
				<article id="content1"> <!-- 탭메뉴 -->				
					<div id="tabMenuBox">					
						<div id="tabMenu">
							<ul id="tab">
								<li><img src="image/tab1.png"></li>
								<li><img src="image/tab2.png"></li>
								<li><img src="image/tab3.png"></li>
								<li><img src="image/tab4.png"></li>
							</ul>
						</div>								<div id="tabContent">
							<div><a href="#"><img src="image/tab_img_01.jpg"></a></div>
							<div><a href="#"><img src="image/tab_img_02.jpg"></a></div>
							<div><a href="#"><img src="image/tab_img_03.jpg"></a></div>
							<div><a href="#"><img src="image/tab_img_04.jpg"></a></div>
						</div>
					</div>	
				</article>
				
				<article id="content2"> <!-- 베스트 상품 -->
					<div id="productBox">
						<h3> 베스트 상품</h3>
						<div class="product">
							<div><a href="#"><img src="image/prd01.jpg"></a></div>
							<div><a href="#"><img src="image/prd02.jpg"></a></div>
							<div><a href="#"><img src="image/prd03.jpg"></a></div>
						</div>
						<div class="product">
							<div><a href="#"><img src="image/prd04.jpg"></a></div>
							<div><a href="#"><img src="image/prd05.jpg"></a></div>
							<div><a href="#"><img src="image/prd06.jpg"></a></div>
						</div>
					</div>
				</article>
			</section>
			<footer>
				<div id="footerBox">
					<div id="bottomMenuBox">
						<ul id="bottomMenuItem">
							<li><a href="#">회사소개</a></li>
							<li><a href="#">이용약관</a></li>
							<li><a href="#">개인정보 처리방침</a></li>
							<li><a href="#">전자금융거래약관</a></li>
							<li><a href="#">보안센터</a></li>
							<li><a href="#">채용정보</a></li>
						</ul>
					</div>
					<div id="companyInfo"><img src="image/footer.png"></div>
					<div id="moveToTopBox"><img src="image/moveToTop.png" id="moveToTop"></div>
				</div>
			</footer>
		</div>
	</body>
</html>

