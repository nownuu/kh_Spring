package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberProfileDao {

	public void insert(MemberProfileDto memberProfileDto) throws Exception {
		Connection con = JdbcUtils.connect2();
		
		String sql = "insert into member_profile values(member_profile_seq.nextval, ?, ?, ?, ? ,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberProfileDto.getMemberId());
		ps.setString(2, memberProfileDto.getMemberFileUploadname());
		ps.setString(3, memberProfileDto.getMemberFileSavename());
		ps.setLong(4, memberProfileDto.getMemberFileSize());
		ps.setString(5, memberProfileDto.getMemberFileType());
		ps.execute();
		con.close();
	}

}
