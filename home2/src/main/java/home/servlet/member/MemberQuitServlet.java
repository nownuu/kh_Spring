package home.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns="/member/quit.kh")
public class MemberQuitServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String memberId = (String)req.getSession().getAttribute("ses"); // 아이디 세션
			String memberPw= req.getParameter("memberPw"); //비밀번호 파라미터
			
			// 처리 : 회원삭제+로그아웃
			MemberDao memberDao = new MemberDao();
			boolean success = memberDao.quit(memberId,memberPw);
			
			if(success) {
			req.getSession().removeAttribute("ses");
			resp.sendRedirect("quit_success.jsp");
			
//			resp.sendRedirect(req.getContextPath()+"/member/quit_success.jsp");	
			}
			else {
				resp.sendRedirect("check.jsp?error");
			}
		}	catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
