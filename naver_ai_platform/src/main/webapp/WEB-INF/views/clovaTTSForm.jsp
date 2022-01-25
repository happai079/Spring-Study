<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TTS</title>
	</head>
	<body>
		<h3>TTS</h3>
		<form id="ttsForm" method="post" action="<c:url value='/clovaTTS'/>" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile"><br>
			언어 및 성별 : <select name="speaker">
							<option selected disabled>언어 및 성별 선택</option>
							<option value="nara">한국어, 여성</option>
							<option value="jinho">한국어, 남성</option>
							<option value="nhajun">한국어, 아동(남)</option>
							<option value="ndain">한국어, 아동(여)</option>
							<option value="clara">영어, 여성</option>
							<option value="matt">영어, 남성</option>
							<option value="ntomoko">일본어, 여성</option>
							<option value="shinji">일본어, 여성</option>
							<option value="meimei">중국어, 여성</option>
							<option value="liangliang">중국어, 남성</option>
							<option value="carmen">스페인어, 여성</option>
							<option value="jose">스페인어, 남성</option>
						</select>
			<input type="submit" value="결과 확인">
		</form>
		
		<hr>
		<c:if test="${ not empty result }">
			<h3>텍스트 -> 음성 변환 결과</h3>
			<audio preload="auto" controls src="/voice/${ result }"></audio>
		</c:if>
		
		<br><br>
		<a href="/">index 페이지로 이동</a>
	</body>
</html>