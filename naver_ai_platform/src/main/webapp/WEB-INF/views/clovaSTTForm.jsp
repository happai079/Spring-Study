<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>STT</title>
	</head>
	<body>
		<h3>STT</h3>
		<form id="sttForm" method="post" action="<c:url value='/clovaSTT'/>" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile">
			<select name="language">
				<option selected disabled>언어 선택</option>
				<option value="Kor">한국어</option>
				<option value="Eng">영어</option>
				<option value="Jpn">일본어</option>
				<option value="Chn">중국어</option>
			</select>
			<input type="submit" value="결과 확인">
		</form>
		
		<hr>
		<c:if test="${ not empty result }">
			<h3>음성 텍스트 변환 결과</h3>
			<span>${ result }</span>
			<br><br>
			<audio preload="auto" controls src="/voice/${ file }"></audio>
		</c:if>
		
		<br><br>
		<a href="/">index 페이지로 이동</a>
	</body>
</html>