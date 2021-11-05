package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.ReplyDao;

@WebServlet(urlPatterns="/board/reply/delete.kh")
public class BoardReplyDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			int replyNo = Integer.parseInt(req.getParameter("replyNo"));
			
			//처리
			ReplyDao replyDao = new ReplyDao();
			boolean success = replyDao.delete(replyNo);
			
			BoardDao boardDao = new BoardDao();
			boolean success2 = boardDao.refreshReplyCount(boardNo);
			
			//출력
//			resp.sendRedirect("../detail.jsp?boardNo"+boardNo);
			resp.sendRedirect(req.getContextPath()+"/board/detail.jsp?boardNo="+boardNo);
		}	catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
