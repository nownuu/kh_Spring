<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>상품 등록</h1>

<form method="post">
	이름 : <input type="text" name="name" required>
	<br><br>
	분류 : 
	<select name="type" required>
		<option value="">선택하세요</option>
		<option>아이스크림</option>
		<option>주류</option>
		<option>과자</option>
		<option>사탕</option>
	</select>
	<br><br>
	가격 : <input type="text" name="price" required>
	<br><br>
	제조일자 : <input type="date" name="made" required>
	<br><br>
	유통기한 : <input type="date" name="expire" required>
	<br><br>
	<input type="submit" value="등록">
</form>