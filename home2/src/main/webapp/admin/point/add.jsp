<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

%>
<jsp:include page="/template/header.jsp"></jsp:include>
<h2>포인트 상품 등록</h2>

<form action="add.kh" method="post">
	상품 이름 :
	<input type="text" name="coinName" required>
	<br><br>
	상품 금액 : 
	<input type="text" name="coinAmount" required>
	<br><br>
	<input type="submit" value="등록">
</form>
<jsp:include page="/template/footer.jsp"></jsp:include>