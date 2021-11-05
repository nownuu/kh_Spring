package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/member/password.kh")
public class MemberChangePWServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId((String)req.getSession().getAttribute("ses"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			String changePw = req.getParameter("changePw");
			
			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.editPassword(memberDto, changePw);
	
			if(success) {
				resp.sendRedirect("password_success.jsp");
			}
			else {
				resp.sendRedirect("password.jsp?error");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
