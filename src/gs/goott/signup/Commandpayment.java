package gs.goott.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;

public class Commandpayment implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 도토리 충전페이지
		/*MemberVO vo = new MemberVO();
		
		String userid = req.getParameter("userid");
		int myAcorn = Integer.parseInt(req.getParameter("myAcorn"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.buyAcorn(userid, myAcorn);
		req.setAttribute("cnt",cnt);
		*/
		return "payment.jsp";
	}

}
