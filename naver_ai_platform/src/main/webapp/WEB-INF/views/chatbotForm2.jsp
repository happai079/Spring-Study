<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Chatbot</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/chatbot.css'/>">
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<script src="<c:url value='/js/chatbot2.js'/>"></script>
	</head>
	<body>
		<div id="wrap">
			<!-- Header -->
			<div id="chatHeader">
				<span>챗봇</span>
				<button id="btnClose">X</button>
			</div>			
			
			<!-- 채팅 내용 출력 -->
			<!-- 응답 메세지 출력 -->
			<div id="chatBox"></div>
			<br>
	
			<form id="chatbotForm">
				<input type="text" id="message" name="message" size="30" placeholder="질문을 입력하세요."/>
				<input type="submit" value="전송"/>
			</form>
			<br><br>
			
			<a href="/">index 페이지로 이동</a>
		</div>
	</body>
</html>