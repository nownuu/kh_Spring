package com.kh.spring11.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.entity.ExamDto;

@Repository
public class ExamDaoImpl implements ExamDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(ExamDto examDto) {
		sqlSession.insert("exam.insert", examDto);
	}

	@Override
	public List<ExamDto> list() {
		return sqlSession.selectList("exam.list");
	}
	
	@Override
	public ExamDto get(int examId) {
		return sqlSession.selectOne("exam.get", examId);
	}
	
	@Override
	public List<ExamDto> search(String student) {
		return sqlSession.selectList("exam.search", student);
	}
	
	@Override
	public List<ExamDto> search(String column, String keyword) {
		//주의 : 
		//= 마이바티스 구문을 부를 때는 데이터를 1개만 전달할 수 있다.
		//= 보내야 할 값이 여러개라면 객체나 Map을 사용한다.
		Map<String, Object> param = new HashMap<>();
		param.put("column", column);
		param.put("keyword", keyword);
		return sqlSession.selectList("exam.searchByColumnAndKeyword", param);
	}
	
}