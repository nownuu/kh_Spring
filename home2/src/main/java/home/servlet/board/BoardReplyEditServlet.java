package home.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns="/board/reply/edit.kh")
public class BoardReplyEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReplyNo(Integer.parseInt(req.getParameter("replyNo")));
			replyDto.setBoardNo(Integer.parseInt(req.getParameter("boardNo")));
			replyDto.setReplyContent(req.getParameter("replyContent"));
			
			ReplyDao replyDao = new ReplyDao();
			boolean success = replyDao.edit(replyDto);
			
			if(success) {
				resp.sendRedirect("../detail.jsp?boardNo="+replyDto.getBoardNo());
			}
			else {
				resp.sendError(404);
			}
			} 
			catch(Exception e) {
				e.printStackTrace();
				resp.sendError(500);
			}
	}
}
