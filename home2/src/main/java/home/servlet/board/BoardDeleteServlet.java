package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;

@WebServlet(urlPatterns="/board/delete.kh")
public class BoardDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			// 처리
			BoardDao boardDao = new BoardDao();
			boolean success = boardDao.delete(boardNo);
			
			// 츨력
			resp.sendRedirect("list.jsp");
			
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
