package home.servlet.point;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.CoinDao;
import home.beans.CoinDto;
import home.beans.HistoryDao;
import home.beans.HistoryDto;
import home.beans.MemberDao;

@WebServlet(urlPatterns = "/point/charge.kh")
public class PointChargeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int coinNo = Integer.parseInt(req.getParameter("coinNo"));

			String memberId = (String)req.getSession().getAttribute("ses");

			CoinDao coinDao = new CoinDao();
			CoinDto coinDto = coinDao.get(coinNo);

			HistoryDto historyDto = new HistoryDto();
			historyDto.setMemberId(memberId);
			historyDto.setHistoryAmount(coinDto.getCoinAmount());
			historyDto.setHistoryMemo("포인트상품 구매");
			
			HistoryDao historyDao = new HistoryDao();
			historyDao.insert(historyDto);
			
			MemberDao memberDao = new MemberDao();
			memberDao.addPoint(memberId, coinDto.getCoinAmount());//1번 방식
			//memberDao.refreshPoint(memberId);//2번 방식
			
			resp.sendRedirect("charge_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}