package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

// 인터페이스란 : 상수필드 (public static final ) + 추상메소드 (public abstract)
// => 일종의 추상 클래스 (== 추상클래스의 변형체)
public interface MemberService {

	// 실제 회사에서는 협업 시 인터페이스 작성 후 모든 개발자에게 동시에 나눠줌
	// => implements 로 상속받은 후 개발을 진행함(메소드 구현의 강제성)

	// 회원가입용 메소드
	/* public abstract */ int insertMember(Member m);

	// 어차피 모든 메소드가 추상메소드이기 때문에 public abstract 은 묵시적으로 생략

	// 로그인용 메소드
	Member loginMember(Member m);

	// 회원정보 수정용 메소드
	int updateMember(Member m);

	// 회원탈퇴 메소드
	int DeleteMember(Member m);

}
