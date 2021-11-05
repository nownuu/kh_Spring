package home.servlet.point;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.CoinDao;
import home.beans.CoinDto;

@WebServlet(urlPatterns="/admin/poin/add.kh")
public class CoinAddServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CoinDto coinDto = new CoinDto();
			coinDto.setCoinName(req.getParameter("coinName"));
			coinDto.setCoinAmount(Integer.parseInt(req.getParameter("coinAmount")));
			
			CoinDao coinDao = new CoinDao();
			coinDao.add(coinDto);
			
			resp.sendRedirect("list.jsp");
		}	catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
