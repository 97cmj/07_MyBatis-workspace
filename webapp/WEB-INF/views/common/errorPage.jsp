<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/common.jsp" %>
</head>
<body>
	 <jsp:include page="menubar.jsp" />
	 
	 <br>
	 
	 <h1 align="center" style="color : red">${ errorMsg }</h1>
</body>
</html>