package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {

		return sqlSession.selectOne("boardMapper.selectListCount");

	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {

		// 단일행 조회시 selectOne() 메소드
		// 여러행 조회시 selctList() 메소드
		// 첫번째 인자값 : "namespace값.id값"
		// 두번째 인자값 : 미완성된 쿼리문을 완성시킬 객체 (단, 완성된 쿼리문일 경우 생략 가능)

		// sqlSession.selectList("boardMapper.selectList"); // 14건이 모두 조회됨

		// 마이바티스는 페이징 처리를 위해 RowBounds 라는 클래스를 제공한다.
		/*
		 * [ 표현법 ] RowBounds rowBounds = new RowBounds(offset, limit);
		 * 
		 * offset : 앞에서부터 몇개의 게시글을 건너 뛰고 조회할건지에 대한 값 limit : 한번에 조회할 행의 갯수
		 * 
		 * ex) 한 페이지 당 목록이 5개씩만 보여지고 싶을 때 (즉, boardLimit 값이 5일 경우) offset limit
		 * currentPage : 1 => 1 ~ 5 0 5 currnetPage : 2 => 6 ~ 10 5 5 currentPage : 3 =>
		 * 11 ~ 15 10 5
		 */
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);

		// 만약 완성된 쿼리문의 경우 2번째 인자값 null

		/*
		 * selectList 메소드 호출 시 반드시 RowBounds 객체를 넘겨야할 경우 selectList 메소드의 오버로딩된 형태 중 매개변수
		 * 3개인 메소드를 사용해야만 한다!! => 딱히 두번째 매개변수 자리에 넘길 값이 없다면 (즉, 해당 쿼리문이 완성된 상태라면) null
		 * 이라도 넘겨야 함 !!
		 * 
		 */

		ArrayList<Board> list = (ArrayList) sqlSession.selectList("boardMapper.selectList", null, rowBounds);

		return list;

	}

	public int increaseCount(SqlSession sqlSession, int boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount", boardNo);

	}

	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		
		
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
		
	}

	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int bno) {
		return (ArrayList) sqlSession.selectList("boardMapper.selectReplyList", bno);
	}

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}

	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList) sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

}
