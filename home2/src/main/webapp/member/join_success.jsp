<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h2>회원 가입 완료</h2>

<h4><a href="<%=request.getContextPath()%>/member/login.jsp">Login</a></h4>
<h4><a href="<%=request.getContextPath()%>/index.jsp">Main Page</a></h4>

<jsp:include page="/template/footer.jsp"></jsp:include>