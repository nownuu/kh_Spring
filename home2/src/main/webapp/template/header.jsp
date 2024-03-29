<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 상태인지 아닌지 판정하는 코드
	//= 로그인 상태라는 것은 세션에 존재하는 ses라는 데이터가 null이 아니라는 것이다.
	//= jsp에서는 session이라는 내장객체가 존재하기 때문에 바로 접근이 가능하다.
	String ses = (String)session.getAttribute("ses");
	boolean login = ses != null;
	
	String grade = (String)session.getAttribute("grade");
	boolean admin = grade != null && grade.equals("관리자");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/commons.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/layout.css">
<%--     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/test.css"> --%>
    <style>
        .logo-wrapper {
            width:130px;
        }
        .logo-wrapper > img {
            width:100%;
            height:100%;
        }
        .title-wrapper {
            flex-grow: 1;
        }

    </style>
</head>
<body>
    <!-- 홈페이지 전체 폭을 설정하는 테두리 영역 -->
    <main>

        <!-- 헤더(상단) 영역 -->
        <header>

            <div class="flex-container">
                <div class="logo-wrapper">
                    <img src="<%=request.getContextPath()%>/resource/image/kh_logo.jpg">
                </div>
                <div class="title-wrapper center">
                    <h1>과정평가형 정보처리산업기사 취득과정</h1>
                </div>
            </div>

        </header>

        <!-- 메뉴 영역 -->
        <nav>
            <ul class="slide-menu">
            	<%if(login){ %>
            	<li><a href="<%=request.getContextPath()%>/index.jsp">홈으로</a></li>
            	<li><a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a></li>
            	<li class="flex-right">
            		<a href="#">회원메뉴</a>
            		<ul>
            			<li><a href="<%=request.getContextPath()%>/point/charge.jsp">포인트 충전</a></li>
		            	<li><a href="<%=request.getContextPath()%>/member/mypage.jsp">내정보</a></li>
		            	<li><a href="<%=request.getContextPath()%>/member/logout.kh">로그아웃</a></li>
            		</ul>
            	</li>
            	<%}else{ %>
            	<li><a href="<%=request.getContextPath()%>/index.jsp">홈으로</a></li>
            	<li><a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a></li>
            	<li class="flex-right">
            		<a href="<%=request.getContextPath()%>/member/login.jsp">로그인</a>
            		<ul>
            			<li><a href="<%=request.getContextPath()%>/member/join.jsp">회원가입</a></li>
            		</ul>
            	</li>
            	<%} %>
            	
            	<%if(admin){ %>
            	<li><a href="<%=request.getContextPath()%>/admin/home.jsp">관리메뉴</a></li>
            	<%} %>
            </ul>
        </nav>

        <!-- 섹션(컨텐츠) 영역 -->
        <section>