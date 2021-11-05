<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
    
    <h1>Membership</h1>
    
<%--   <form action="<%=request.getContextPath() %>/member/join.kh" method="post"> --%>
  <form action="join.kh" method="post" enctype="multipart /form-data">
  
  	<table border ="0">
  		<tbody>
  			<tr>
  				<th>ID</th>
  				<td><input type="text" name="memberId" required></td>
  			</tr>
  			<tr>
  			<th>PW</th>
  			<td><input type="text" name="memberPw" required></td>
  			</tr>	
  			<tr>
  				<th>Nick Name</th>
  				<td><input type="text" name="memberNick" required></td>
  			</tr>
  			<tr>
  				<th>Birth</th>
  				<td><input type="date" name = "memberBirth" required></td>
  			</tr>
  			<tr>
  				<th>Phone number</th>
  				<td><input type="text" name ="memberPhone"></td>
  			</tr>
  			<tr>
  				<th>E-mail</th>
  				<td><input type="email" name ="memberEmail"></td>
  			</tr>
  			<tr>
  				<th>Profile</th>
  				<td><input type="file" name="attach" accept="image/*"></td>
  			</tr>
  		</tbody>
  	</table>
  		<br><br>
    	<input type="submit" value="가입">
    	
  </form>
<jsp:include page="/template/footer.jsp"></jsp:include>