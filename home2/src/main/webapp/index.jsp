<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
            
<div class="container-600 container-center">
    <div class="row center">
        <h1>내가 만든 홈페이지</h1>
    </div>
    <div class="row">
        <img src="<%=request.getContextPath()%>/resource/image/kh_main.jpg" width="100%">
    </div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>
