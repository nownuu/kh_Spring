package com.kh.spring08.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import org.springframework.stereotype.Repository;


import com.kh.spring08.entity.StudentDto;

//@Service //대형 기능(ex : 결제)
@Repository //영속성 항목을 제어하는 컴포넌트
//@Component //나머지(뭔가를 함)
public class StudentDao {
	
	// 등록 서블릿
	public void insert(StudentDto studentDto) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
		
		String sql = "insert into student values(student_seq.nextval, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, studentDto.getName());
		ps.setInt(2, studentDto.getScore());
		ps.execute();
		
		con.close();
	}
}
