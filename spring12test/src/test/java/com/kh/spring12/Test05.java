package com.kh.spring12;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.ExamDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test05 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void countTest() {
		Map<String, Object> param = new HashMap<>();
		param.put("column", "type");
		param.put("keyword", "서술형");
		List<ExamDto> list = sqlSession.selectList("exam.searchByColumnAndKeyword", param);

		System.out.println(list.size());
		
		assertNotEquals(0, list.size());
	}
}
