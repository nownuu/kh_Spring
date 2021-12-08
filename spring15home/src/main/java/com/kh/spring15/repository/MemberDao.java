package com.kh.spring15.repository;

import com.kh.spring15.entity.MemberDto;

public interface MemberDao {

	MemberDto get(String memberId);
	MemberDto login(MemberDto memberDto);
}
