<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보 등록 결과</title>
		<style type="text/css">
			table, tr, td {
				border: 1px solid black;			
			}
			table {
			    border-collapse: collapse;
			}
			tr > td:first-child {
				background-color: orange;	
			}
		</style>
	</head>
	<body>
		<h3>상품 정보</h3>
		<table>
			<tr>
				<td>상품번호</td>
				<td>${ product.prdNo }</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>${ product.prdName }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${ product.prdPrice }</td>
			</tr>
			<tr>
				<td>제조회사</td>
				<td>${ product.prdMaker }</td>
			</tr>
			<tr>
				<td>제조일</td>
				<td>${ product.prdDate }</td>
			</tr>
			<tr>
				<td>재고</td>
				<td>${ product.prdQty }</td>
			</tr>
		</table>
	</body>
</html>