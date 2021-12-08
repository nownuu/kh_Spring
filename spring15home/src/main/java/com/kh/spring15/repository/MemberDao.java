package com.kh.spring15.repository;

import com.kh.spring15.entity.MemberDto;

public interface MemberDao {

	MemberDto get(String memberId);//그냥 단일조회
	MemberDto login(MemberDto memberDto);//비밀번호 검사까지 통과하면 객체를 반환하도록 구현
	void join(MemberDto memberDto);//가입
	
}
