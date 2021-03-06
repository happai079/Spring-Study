<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Result</title>
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
				<td>${ prdNo }</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>${ prdName }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${ prdPrice }</td>
			</tr>
			<tr>
				<td>제조회사</td>
				<td>${ prdMaker }</td>
			</tr>
			<tr>
				<td>제조일</td>
				<td>${ prdDate }</td>
			</tr>
			<tr>
				<td>재고</td>
				<td>${ prdQty }</td>
			</tr>
		</table>
		
		<br><br>
		url을 통한 데이터 전송<br>
		<a href="/project/product/productModify/${ prdNo }">${ prdNo }</a>
	</body>
</html>