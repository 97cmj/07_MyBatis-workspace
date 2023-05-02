<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.login-area a {
	text-decoration: none;
	color: black;
	font-size: 12px;
}

.logined-area a {
	text-decoration: none;
	color: black;
	font-size: 16px;
}

.nav-area {
	background-color: black;
	color: white;
	height: 50px;
}

.menu {
	display: table-cell;
	width: 250px;
	height: 50px;
	text-align: center;
	vertical-align: middle;
	font-size: 20px;
	font-weight: bold;
}

.menu:hover {
	background-color: white;
	color: black;
	cursor: pointer;
}

/* menubar.jsp 에 .outer 에 한번만 적용하고 다 include 해서 쓸 것 */
.outer {
	width: 900px;
	background-color: black;
	color: white;
	margin: auto;
	margin-top: 50px;
}
</style>
<body>

	<h1 align="center">안녕 내 이름은 마이바티스</h1>
	<br>

	<c:choose>
		<c:when test="${ empty loginUser }">
			<div class="login-area" align="right">
				<!-- case1. 로그인 전에 보여져야 하는 폼-->
				<form action="login.me" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userId"
								placeholder="아이디를 입력하세요." required></td>
							<td rowspan="2">
								<button type="submit" style="height: 50px;">로그인</button>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="userPwd"
								placeholder="비밀번호를 입력하세요." required></td>
						</tr>
						<tr>
							<td colspan="3" align="center"><a href="enrollForm.me">회원가입</a>
								| <a href="">아이디/비밀번호 찾기</a></td>
						</tr>


					</table>
				</form>
			</div>
		</c:when>

		<c:otherwise>


			<div class="logined-area" align="right">
				<table>
					<tr>
						<td colspan="2">
							<h3>${ loginUser.userName }님 환영합니다.</h3>
						</td>
					</tr>
					<tr>
						<td><a href="/mypage.me">마이페이지</a></td>
						<td><a href="/logout.me">로그아웃</a></td>
					</tr>
				</table>
			</div>

		</c:otherwise>
	</c:choose>


	<br>

	<div class="nav-area" align="center">
		<div class="menu">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='list.bo?currentPage=1';">게시판</div>
		<div class="menu">ETC</div>
	</div>

</body>
</html>