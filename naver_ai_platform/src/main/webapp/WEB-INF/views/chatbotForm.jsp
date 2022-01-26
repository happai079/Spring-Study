<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Chatbot</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<script src="<c:url value='/js/chatbot.js'/>"></script>
	</head>
	<body>
		<h3>Chatbot - 독서 프로그램</h3>
		
		<!-- 응답 메세지 출력 -->
		<div id="chatBox"></div>
		<br>

		<form id="chatbotForm">
			<input type="text" id="message" name="message" size="30" placeholder="질문을 입력하세요."/>
			<input type="submit" value="전송"/>
		</form>
		<br><br>
		
		<a href="/">index 페이지로 이동</a>
	</body>
</html>