<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<title>공지사항</title>
</head>

<style>
.board-area>tr>td>a {
	text-decoration: none;
	color: black;
}

.board-area>tr:hover {
	background-color: #f2f2f2;
}
</style>

<body>
	<jsp:include page="../common/menubar.jsp" />


	<div class="container" align="center">
		<br>
		<h1>자유게시판</h1>
		<br> <br> <br>
		<div id="search-area" style="float: right;">
			<form class="row g-1" action="search.bo" method="get">
				<div class="col-auto">
					<select class="form-select" name="condition">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="col-auto">
					<input class="form-control" type="text" name="keyword"
						value="${keyword}">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>
		</div>

		<c:if test="${ not empty condition}">
			<script>
				$(function() {
					$("#search-area option[value=${ condition }]").attr(
							"selected", true);
				});
			</script>
		</c:if>
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
			<tbody class="board-area">
				<c:if test="${ empty list }">
					<tr>
						<td colspan="5" align="center">게시글이 없습니다.</td>
					</tr>
				</c:if>

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


<%-- --%>



			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">


					<!-- 동적 SQL을 이용한 방식 (권장하는 방식) -->
					<!-- 이전페이지 disabled로 있게 하기 -->
					
					<li class="page-item ${pi.currentPage == 1 ? 'disabled' : ''}">
						<a class="page-link"
						href="${not empty condition ? 'search.bo' : 'list.bo'}?currentPage=${pi.currentPage - 1}&condition=${condition}&keyword=${keyword}">
							이전 </a>
					</li>

					<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}">
						<c:choose>
							<c:when test="${not empty condition}">
								<li class="page-item ${i == pi.currentPage ? 'active' : ''}"><a
									class="page-link"
									href="search.bo?currentPage=${i}&condition=${condition}&keyword=${keyword}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item ${i == pi.currentPage ? 'active' : ''}"><a
									class="page-link" href="list.bo?currentPage=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${ pi.currentPage eq pi.maxPage }">
					<c:choose>
						<c:when test="${not empty condition}">
						<li class="page-item disabled"><a class="page-link"
							href="search.bo?currentPage=${ pi.currentPage+1 }&condition=${condition}&keyword=${keyword}">다음</a></li>
						</c:when>
						<c:otherwise>
						<li class="page-item disabled"><a class="page-link"
							href="list.bo?currentPage=${ pi.currentPage+1 }">다음</a></li>
						</c:otherwise>
					</c:choose>
					</c:if>

					<c:if test="${ pi.currentPage ne pi.maxPage && not empty list}">
					<c:choose>
						<c:when test="${not empty condition}">
						<li class="page-item"><a class="page-link"
							href="search.bo?currentPage=${ pi.currentPage+1 }&condition=${condition}&keyword=${keyword}">다음</a></li>
						</c:when>
						<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="list.bo?currentPage=${ pi.currentPage+1 }">다음</a></li>
						</c:otherwise>
					</c:choose>
					</c:if>
					
				</ul>
			</nav>
		</div>
	</div>


</body>
</html>