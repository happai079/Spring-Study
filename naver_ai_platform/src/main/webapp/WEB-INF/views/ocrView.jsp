<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>OCR</title>
		<script src="js/jquery-3.6.0.min.js"></script>
		<script src="js/ocr.js"></script>
	</head>
	<body>
		<h3>OCR</h3>
		<!-- 파일 업로드 -->
		<form id="ocrForm">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<input type="submit" value="결과 확인">
		</form>
		
		<hr>
		<!-- 결과 확인 -->
		<div class="resultArea">
			<h3>결과</h3>
			<span class="resultText"></span>
		</div>
		<br><br>
	</body>
</html>