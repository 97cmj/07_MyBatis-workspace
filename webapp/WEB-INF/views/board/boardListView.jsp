<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<style>
    a {
        text-decoration: none;
        color: black;
    }
    tr:hover {
        background-color: #f2f2f2;
    }



</style>

<body>
    <jsp:include page="../common/menubar.jsp" />


    <div class="container" align="center">
    <br>
    <h1>자유게시판</h1>
    <br><br><br>
    <div id="search-area" style="float : right;">            
        <form class="row g-1" action="boardSearch.do" method="post">
            <div class="col-auto">
            <select class="form-select" name="searchType">
                <option value="title">제목</option>
                <option value="writer">작성자</option>
                <option value="content">내용</option>
            </select>
            </div>
            <div class="col-auto">
            <input class="form-control" type="text" name="searchKeyword">
            </div>
            <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>

    <table class="table" border="1">
    <thead>
        <tr>
            <th>번호</th>
            <th width="600px">제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        
        </tr>
    </thead>
    <tbody>
        <c:forEach var="b" items="${list}">
            <tr>
                <td>${b.boardNo}</td>
                <td><a href="detail.bo?bno=${b.boardNo}">${b.boardTitle}</a></td>
                <td>${b.boardWriter}</td>
                <td>${b.createDate}</td>
                <td>${b.count}</td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
    <hr>

    <div id="paging-area">






     <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">

        <!-- 이전페이지 disabled로 있게 하기 -->
        <c:if test="${ pi.currentPage eq 1 }">
            <li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
        </c:if>

        <c:if test="${ pi.currentPage ne 1 }">
            <li class="page-item"><a class="page-link" href="list.bo?currentPage=${ pi.currentPage-1 }">이전</a></li>
        </c:if>

        <c:forEach var="i" begin="${ pi.startPage }" end="${ pi.endPage }">
            <li class="page-item"><a class="page-link" href="list.bo?currentPage=${i}">${i}</a></li>
        </c:forEach>

        <c:if test="${ pi.currentPage eq pi.maxPage }">
            <li class="page-item disabled"><a class="page-link" href="list.bo?currentPage=${ pi.currentPage+1 }">다음</a></li>
        </c:if>

        <c:if test="${ pi.currentPage ne pi.maxPage }">
            <li class="page-item"><a class="page-link" href="list.bo?currentPage=${ pi.currentPage+1 }">다음</a></li>
        </c:if>
        </ul>
    </nav>
    </div>
</div>


</body>
</html>