package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {

		/*
		 * INSERT 문 : sqlSession.insert(); : int (처리된 행의 갯수) UPDATE 문 :
		 * sqlSession.update(); : int (처리된 행의 갯수) DELETE 문 : sqlSession.delete(); : int
		 * (처리된 행의 갯수) SELECT 문 : sqlSession.selectOne(); : 해당VO객체타입
		 * sqlSession.selectList(); : List타입
		 * 
		 * 
		 */
		return sqlSession.insert("memberMapper.insertMember", m);

	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);

	}

}
