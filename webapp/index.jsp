<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
        * 프레임워크
        - 개발자가 보다 편리한 개발을 할 수 있도록 기본적인 틀을 제공하는 것
        - 소프트웨어 개발의 입장으로써의 프레임워크는 소프트웨어의 특정 문제를 해결하기 위해 상호 협력하는 클래스와 인터페이스의 집합

        * 왜 프레임워크를 쓰나요?
        - 현재 웹 프로그래밍의 규모가 커지고 복잡해지면서 개발자가 직접 모든 것을 만들기에는 어려움이 있음
        - 프레임워크를 사용하면 개발자가 직접 만들어야 할 부분을 프레임워크가 대신 만들어주기 때문에 개발자는 핵심 로직에 집중할 수 있음
        - 개발자를 위한 틀을 제공하기 때문에 개발자가 프레임워크를 익히는 시간이 필요하지만, 익힌 후에는 개발 속도가 빨라짐

        * 프레임워크의 장단점
        - 장점
        1. 개발자가 핵심 로직에 집중할 수 있음
        2. 개발 속도가 빨라짐
        3. 개발자들 간의 협업이 쉬워짐

        - 단점
        1. 프레임워크를 익히는 시간이 필요함
        2. 프레임워크의 업데이트에 따라서 기존에 사용하던 코드가 동작하지 않을 수 있음
        
        * 프레임워크의 종류
        1. 영속성 프레임워크 : 데이터베이스와 연동하는 기능을 제공하는 프레임워크
            ex) Mybatis, JPA, Hibernate
        2. 자바 프레임워크 : 자바로 웹 프로그래밍을 할 때 사용하는 프레임워크
            ex) Spring, Struts, JSF
        3. 화면 구현 프레임워크 : 웹 화면을 구현할 때 사용하는 프레임워크
            ex) BootStrap,
        4. 기능 및 지원 프레임워크 : 웹 프로그래밍을 할 때 필요한 기능을 제공하는 프레임워크
            ex) Log4j, JUnit, Lombok 
     -->

     
     <!-- index 페이지가 로딩되자마자 WEB-INF/views/main.jsp 로 포워딩 -->
        <jsp:forward page="/WEB-INF/views/main.jsp" />
        
</body>
</html>