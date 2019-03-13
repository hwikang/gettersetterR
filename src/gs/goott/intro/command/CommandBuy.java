package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.OrderDAO;
import gs.goott.intro.OrderVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandBuy implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		//userid 의 아콘수 
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");
		MemberDAO memberDao = new MemberDAO();
		MemberVO memberVo = memberDao.getUserInfo(userid);
		int myAcorn = memberVo.getMyAcorn();
		//introNo 의 가격
		IntroDAO introDao = new IntroDAO();
		IntroVO introVo = introDao.getIntro(introNo);
		Double price = introVo.getPrice();
		//비교
		int cnt = 0;
		if(myAcorn-price<0) {//잔액부족
			cnt = -1;
			req.setAttribute("cnt", cnt);
		}else {
		//잔액차감
		int useCnt = memberDao.useAcorn(userid, price);
		//order table 에추가
			if(useCnt==1) {
				OrderVO orderVo = new OrderVO();
				OrderDAO orderDao = new OrderDAO();
				String setterId = introVo.getUserid();
				cnt = orderDao.orderContent(setterId, userid, price);
			}
		}
		req.setAttribute("cnt", cnt);
		req.setAttribute("introNo", introNo);
		
		return "buyOk.jsp";
	}

}
