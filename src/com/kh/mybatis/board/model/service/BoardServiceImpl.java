package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDao();

	@Override
	public int selectListCount() {

		// 1. SqlSession 객체 생성
		SqlSession sqlSession = getSqlSession();

		// 2. 생성된 SqlSession 객체와 전달값을 DAO 로 넘기면서 요청 후 결과 받기

		int listCount = boardDao.selectListCount(sqlSession);

		// 3. 트랜잭션 처리 (PASS)

		// 4. SqlSession 객체 반납
		sqlSession.close();

		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();

		// 2. 생성된 SqlSession 객체와 전달값을 DAO 로 넘기면서 요청 후 결과 받기

		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);

		sqlSession.close();

		return list;
	}

	@Override
	public int increaseCount(int boardNo) {

		// 1. SqlSession 객체 생성
		SqlSession sqlSession = getSqlSession();

		// 2. 생성된 SqlSession 객체와 전달값을 DAO 로 넘기면서 요청 후 결과 받기
		int result = boardDao.increaseCount(sqlSession, boardNo);

		// 3. 트랜잭션 처리
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		// 4. sqlSession 객체 반납
		sqlSession.close();

		return result;

	}

	@Override
	public Board selectBoard(int bno) {
		return null;
	}

	@Override
	public int insertBoard(Board b) {
		return 0;
	}

	@Override
	public int updateBoard(Board b) {
		return 0;
	}

	@Override
	public int deleteBoard(int bno) {
		return 0;
	}

}
