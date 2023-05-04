package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;

@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardDetailController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 게시글 번호 뽑기
		int bno = 0;

		try {
			
			bno = request.getParameter("bno") != null ? Integer.parseInt(request.getParameter("bno")) : 1;
			
		} catch (NumberFormatException e) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}

		// BoardServiceImpl 객체 생성 (다형성 적용)
		BoardService boardService = new BoardServiceImpl();
		// 1. 조회수 먼저 증가시키기
		int result = boardService.increaseCount(bno);
		// 2. 조회수 증가가 성공이다 => 그제서야 게시글 상세 조회 요청 보내기
		if (result > 0) {
			Board b = boardService.selectBoard(bno);
			request.setAttribute("b", b);
			// 3. 조회수 증가가 성공이라면 해당 게시글에 딸린 댓글들도 조회하기 ( 기존에는 ajax로 요청했음 )
			ArrayList<Reply> list = boardService.selectReplyList(bno);
			
			request.setAttribute("list", list);
			// 3. 조회수 증가가 성공이라면? 해당 게시글에 딸린 댓글들도 조회하기
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);

		} else {
			request.setAttribute("errorMsg", "게시글 상세 조회 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
