<%@page import="home.beans.CoinDto"%>
<%@page import="home.beans.CoinDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 입력 -->
<%
	int coinNo = Integer.parseInt(request.getParameter("coinNo"));
	
	CoinDao coinDao = new CoinDao();
	CoinDto coinDto = coinDao.get(coinNo);
%>
<jsp:include page="/template/header.jsp"></jsp:include>
<h2>포인트 상품 수정</h2>
<form action="edit.kh" method="post">
	상품 번호 : 1
	<input type="hidden" name="coinNo" value="<%=coinDto.getCoinNo()%>">
	<br><br>
	상품 이름 : <input type="text" name="coinName" value="<%=coinDto.getCoinName()%>">
	<br><br>
	상품 금액 : <input type="text" name="coinAmount" value="<%=coinDto.getCoinAmount()%>">
	<br><br>
	<input type="submit" value="수정">
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>