package gs.goott.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;

public class Commandpayment implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 도토리 충전페이지
		MemberVO vo = new MemberVO();
		HttpSession session = req.getSession();
		//vo = (MemberVO)session.getAttribute("vo");
		//System.out.println(vo.getMyAcorn());
		//req.setAttribute("vo", vo);
		return "payment.jsp";
	}

}
