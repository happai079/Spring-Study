<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 업로드</title>
	</head>
	<body>
		<h3>파일 업로드</h3>
		<form id="fileUploadForm" method="post" action="<c:url value='/fileUpload'/>" enctype="multipart/form-data">
			파일 : <input type="file" id="uploadFile" name="uploadFile"><br><br>
			<input type="submit" value="업로드">
		</form>
	</body>
</html>