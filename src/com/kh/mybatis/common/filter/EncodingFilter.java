package com.kh.mybatis.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = "/*") // get 방식이든 post 방식이든 간에 모든 서블릿이 요청되기 전에 이 필터를 거쳐가겠다.
public class EncodingFilter implements Filter { // class 선언부

	/*
	 * * Filter
	 * 서블릿에 요청이 도달하기 전 먼저 가로채서 선처리 해주는 개념
	 * 주로 공통적으로 선처리 돼야하는 구문들을 기능으로써 정의해서 활용한다.
	 * 예 ) 문자 인코딩 처리, 로그인 여부 파악, ..
	 * 
	 * => Filter 클래스의 doFilter 메소드 내부에서 선처리할 구문을 정의하면 됨
	 * => 어느 요청에 대해서 해당 필터를 거쳐갈건지 @WebFilter 라는 어노테이션에 url 주소를 기술하면 됨 
	 */

    public EncodingFilter() {}


	public void destroy() {}



	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 이 영역에 선처리할 코드를 작성
		request.setCharacterEncoding("UTF-8");
		// 기본적으로 필터는 여러개를 가져갈 수 있음.
		// 현재 이 필터가 최종 필터일 경우 => Servlet을 호출하는 구문의 역할
		// 현재 이 필터가 최종 필터가 아닌 경우 => 또 다른 다음 필터를 호출하는 구문의 역할
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
