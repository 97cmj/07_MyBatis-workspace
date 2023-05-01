package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDao();

	/* 회원가입 */
	@Override
	public int insertMember(Member m) {

		// Mybatis 방식
		SqlSession sqlSession = Template.getSqlSession();
		int result = memberDao.insertMember(sqlSession, m);

		// 3. 트랜잭션 처리
		if (result > 0) {
			sqlSession.commit();
		}
		// 단일프로세스 : 한 트랜잭션의 쿼리문이 단 한개일 경우
		// 이 경우에는 실패 시 롤백을 굳이 안해도 됨!!
		// 단, 한 트랜잭션 내에 실행할 쿼리문이 여러개일 경우에는 반드시 롤백 구문을 작성해야함 !!

		// 4. sqlSession 객체 반납
		sqlSession.close();

		return result;

	}

	/* 로그인 */
	@Override
	public Member loginMember(Member m) {

		// 1.sql 객체 생성
		SqlSession sqlSession = Template.getSqlSession();
		// 2.만들어진 sqlsession으로 결과 받기
		Member loginUser = memberDao.loginMember(sqlSession, m);
		// 3.트랜잭션 처리 (select라 x)

		// 4. sql 반환
		sqlSession.close();

		return loginUser;
	}

	/* 회원 수정 */
	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 회원탈퇴 */
	@Override
	public int DeleteMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

}
