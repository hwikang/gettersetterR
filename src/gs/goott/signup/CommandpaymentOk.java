package gs.goott.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;

public class CommandpaymentOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 도토리 충전 등록
		
		MemberVO vo = new MemberVO();

		String userid = req.getParameter("userid");
		//구매하려는 acorn 수

		int buyAcorn = Integer.parseInt(req.getParameter("buyAcorn"));
	
		MemberDAO dao = new MemberDAO();
		//vo정보 불러오기
		vo = dao.getUserInfo(userid);
		//id, 구매수(buyacorn), myacorn
		int cnt = dao.buyAcorn(userid, buyAcorn,vo.getMyAcorn());
		req.setAttribute("cnt",cnt);
		req.setAttribute("userid",vo.getUserid());
		req.setAttribute("myAcorn",vo.getMyAcorn());
		return "paymentOk.jsp";
	}

}
