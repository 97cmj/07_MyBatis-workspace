<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세화면</title>
<%@ include file="../common/common.jsp" %>
<link rel="stylesheet" type="text/css" href="../resources/detail.css">
</head>
<body>
    
    <jsp:include page="../common/menubar.jsp"/>
    
    <div class="container" align="center">
    <br>
    <h1>게시판 상세조회</h1>
    <br>

    <table class="table" border="2">
        <tr>
            <td width="100">글번호</td>
            <td width="500">10</td>
        </tr>
        <tr>
            <td>제목</td>
            <td>${b.boardTitle}</td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>${b.boardWriter}</td>
        </tr>
        <tr>
            <td>작성일</td>
            <td>${b.createDate}</td>
        </tr>
        <tr>
            <td>내용</td>
            <td>${b.boardContent}</td>
        </tr>
        <tr>
            <td>조회수</td>
            <td>${b.count}</td>
        </tr>

    </table>

    <br>

    <table class="table" align="center" border="1">
    <tr>
        <td width="100" class="align-middle">댓글작성</td>
        <td width="400"><textarea class="form-control"></textarea></td>
        <td width="100" class="align-middle" style="text-align : center"><button class="btn btn-primary mb-3" style="width : 80%; height: 60px;">등록</button></td>
    </tr>
    <tr>
        <td colspan="3"><b>댓글(${ list.size() })</b></td>
        					<!--  또는 fn:length(list) -->
    </tr>
    <tr>
        <th>이름</th>
        <th>내용</th>
        <th>작성일</th>
    </tr>

    <c:forEach var="c" items="${ list }">
    <tr>
        <td>${c.replyWriter}</td>
        <td>${c.replyContent}</td>
        <td>${c.createDate}</td>
    </tr>
    </c:forEach>

    </table>
    </div>

    <br><br>
    <div align="center">
        <button class="btn btn-primary mb-3" onclick="location.href='list.bo'">목록</button>
    
</body>
</html>