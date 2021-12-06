package com.kh.spring10.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.kh.spring10.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void join(MemberDto memberDto) {
		String sql = "insert into member values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?, sysdate, 0, '준회원')";
		Object[] param = {
				memberDto.getMemberId(),
				memberDto.getMemberPw(),
				memberDto.getMemberNick(),
				memberDto.getMemberBirth(),
				memberDto.getMemberEmail(),
				memberDto.getMemberPhone()
		};
		jdbcTemplate.update(sql, param);
	}

	/* 
	 * 목록을 구현하기 위한 준비물
	 * 
	 * 1. SQL 조회 구문
	 * 2. 데이터베이스 한 줄을 MemberDto로 맵핑하는 코드
	 * 검색결과를 구하려면 
	 * 3. 검색어
	 */
	@Override
	public List<MemberDto> list() {
		String sql = "select * from member";
		
		RowMapper<MemberDto> converter = new RowMapper<MemberDto>() {
			@Override
			public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto memberDto = new MemberDto();
				
				memberDto.setMemberId(rs.getString("member_id"));
				memberDto.setMemberPw(rs.getString("member_pw"));
				memberDto.setMemberNick(rs.getString("member_nick"));
				memberDto.setMemberBirth(rs.getString("member_birth"));
				memberDto.setMemberEmail(rs.getString("member_email"));
				memberDto.setMemberPhone(rs.getString("member_phone"));
				memberDto.setMemberJoin(rs.getDate("member_join"));
				memberDto.setMemberPoint(rs.getInt("member_point"));
				memberDto.setMemberGrade(rs.getString("member_grade"));
				return memberDto;
			}
		};
		
		// 람다 적용
//		RowMapper<MemberDto> converter = (rs, index)->{
//			MemberDto memberDto = new MemberDto();
//			
//			memberDto.setMemberId(rs.getString("member_id"));
//			memberDto.setMemberPw(rs.getString("member_pw"));
//			memberDto.setMemberNick(rs.getString("member_nick"));
//			memberDto.setMemberBirth(rs.getString("member_birth"));
//			memberDto.setMemberEmail(rs.getString("member_email"));
//			memberDto.setMemberPhone(rs.getString("member_phone"));
//			memberDto.setMemberJoin(rs.getDate("member_join"));
//			memberDto.setMemberPoint(rs.getInt("member_point"));
//			memberDto.setMemberGrade(rs.getString("member_grade"));
//			
//			return memberDto;
//		};
		return jdbcTemplate.query(sql, converter);
	}
}
