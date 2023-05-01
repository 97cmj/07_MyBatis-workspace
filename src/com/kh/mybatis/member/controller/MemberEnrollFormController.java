package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enrollForm.me")
public class MemberEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberEnrollFormController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입 페이지를 포워딩 시키기
		// webapp 의 WEB-INF/views/member/memberEnrollForm.jsp 로 포워딩
		request.getRequestDispatcher("WEB-INF/views/member/memberEnrollForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
