package com.kh.spring10.repository;
// mybatis를 이용한 회원 DB처리

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.spring10.entity.MemberDto;

public class MemberDaoMyBatis implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void join(MemberDto memberDto) {
		// mapper 중에서 member 라는 namespace의 join이라는 구문을 찾고
		// memberDto를 전달시켜서 실행하라!
		sqlSession.insert("member.join", memberDto);
	}
	
	@Override
	public List<MemberDto> list() {

		return sqlSession.selectList("member.list");
	}
}
