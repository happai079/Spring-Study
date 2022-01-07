<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Command 객체 이름 변경</title>
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
				<td>${ prd.prdNo }</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>${ prd.prdName }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${ prd.prdPrice }</td>
			</tr>
			<tr>
				<td>제조회사</td>
				<td>${ prd.prdMaker }</td>
			</tr>
			<tr>
				<td>제조일</td>
				<td>${ prd.prdDate }</td>
			</tr>
			<tr>
				<td>재고</td>
				<td>${ prd.prdQty }</td>
			</tr>
		</table>
	</body>
</html>