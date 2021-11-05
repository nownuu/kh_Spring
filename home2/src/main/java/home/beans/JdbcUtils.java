package home.beans;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtils {
	
	//연결 생성 : 직접 연결하는 방법
	public static Connection connect(String user, String password) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
							"jdbc:oracle:thin:@127.0.0.1:1521:xe", user, password);
		
		return con;
	}
	
	// 연결 생성 : DBCP 업체를 고용하는 방법
	// - 연결을 직접 수행하는 것이 아니라 연결을 관리하는 업체를 두고 렌탈하는 방식
	// - 연결을 생성하는 시간이 줄어들어서 전체적인 성능과 안정성이 향상됨
	// - 설정 파일을 초기에 불러와야한다.
	
	private static DataSource ds; 
	static {
		//context.xml에 있는 "jdbc/oracle"이라는 이름을 가진 자원의 참조 정보를 획득
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch(Exception e) {
			System.err.println("DataSource 생성 오류");
			e.printStackTrace();
		}
	}
	
	public static Connection connect2()	throws Exception {
		return ds.getConnection();
	}
}