package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CancelDao {
	
	public void insert(int historyNo) throws Exception {
		Connection con = JdbcUtils.connect2();
		
		String sql = "insert into cancel values(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, historyNo);
		ps.execute();
		
		con.close();
	}
	
	public boolean available(int historyNo) throws Exception {
		Connection con = JdbcUtils.connect2();
		
		String sql = "select * from cancel where history_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, historyNo);
		ResultSet rs = ps.executeQuery();
		
		boolean exist = rs.next();
		
		con.close();
		
		return !exist;
	}
}