<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>home.jsp</h1>
<h2>a : ${a}</h2>
<h2>b : ${b}</h2>

<h2>a : <%=request.getAttribute("a") %></h2>
<h2>b : <%=request.getAttribute("b") %></h2>