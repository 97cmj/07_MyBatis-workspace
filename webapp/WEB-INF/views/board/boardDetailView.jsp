<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세화면</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<style>
    td>textarea {
        resize: none;
        width : 100%;
        height : 100%;
    }
</style>

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
            <td>실제 조회한 제목</td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>user01</td>
        </tr>
        <tr>
            <td>조회수</td>
            <td>13</td>
        </tr>
        <tr>
            <td>작성일</td>
            <td>12</td>
        </tr>
        <tr>
            <td>내용</td>
            <td height="100">여기가 내용자리임</td>
        </tr>
    </table>

    <br>

    <table class="table" align="center" border="1">
    <tr>
        <td width="100" class="align-middle">댓글작성</td>
        <td width="400"><textarea class="form-control"></textarea></td>
        <td width="100" class="align-middle" style="text-align : center"><button class="btn btn-primary mb-3" style="width : 100%; height: 60px;">등록</button></td>
    </tr>
    <tr>
        <td colspan="3"><b>댓글(2)</b></td>
    </tr>
    <tr>
        <th>이름</th>
        <th>내용</th>
        <th>작성일</th>
    </tr>
    <tr>
        <td>admin</td>
        <td>댓글입니다.</td>
        <td>2023-05-02</td>
    </tr>

    </table>
    </div>
    
</body>
</html>