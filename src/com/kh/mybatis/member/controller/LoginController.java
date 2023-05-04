package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청 받은 id, pw 값 저장
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//2. VO 객체로 가공
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		//3. 서비스로 요청 후 결과 받기
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		
		//4. 결과에 따른 응답페이지 지정
		if(loginUser == null) { //로그인 실패
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 틀립니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		} else { //로그인 성공
			
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
