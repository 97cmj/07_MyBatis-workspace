package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardSearchController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청 시 전달값 뽑기
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");

		// 동적쿼리를 이용하여 condition과 keyword를 넘긴다 ( 하나의 객체로 가공해서 넘겨야함 )
		// => 굳이 VO 를 만들기 애매한 상황이라면 HashMap 으로 여러개의 데이터를 하나로 가공할 수 있다.
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);

		// => 이렇게 넘겨진 key + value 를 mapper 에서 #{키값} 로 완성시킬 수 있다.

		// 2. 검색 기능에서 필요로 하는 PageInfo 객체 만들기
		int searchCount = new BoardServiceImpl().selectSearchCount(map); // 현재 검색결과에 맞는 게시글의 총 갯수
		int currentPage = 1;
		int pageLimit = 10;
		int boardLimit = 5;

		try {

			currentPage = request.getParameter("currentPage") != null
					? Integer.parseInt(request.getParameter("currentPage"))
					: 1;

		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		
		PageInfo pi = Pagination.getPageInfo(searchCount, currentPage, pageLimit, boardLimit);
		
		ArrayList<Board> list = new BoardServiceImpl().selectSearchList(map, pi);

		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
