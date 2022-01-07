<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보 등록</title>
	</head>
	<body>
		<h3>상품 정보 등록</h3>
		<form method="post" action="/project/product/newProduct">
			<table>
				<tr>
					<td>상품번호</td>
					<td><input type="text" name="prdNo"></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="prdName"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="prdPrice"></td>
				</tr>
				<tr>
					<td>제조회사</td>
					<td><input type="text" name="prdMaker"></td>
				</tr>
				<tr>
					<td>제조일</td>
					<td><input type="text" name="prdDate"></td>
				</tr>
				<tr>
					<td>재고</td>
					<td><input type="text" name="prdQty"></td>
				</tr>
			</table>
			<input type="submit" value="등록"> <input type="reset" value="취소">
		</form>
	</body>
</html>