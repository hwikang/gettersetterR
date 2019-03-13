package gs.goott.myProfile.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.OrderDAO;
import gs.goott.intro.OrderVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandmyProfile implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userid = (String)req.getSession().getAttribute("userid");
		// 로그인 시 세션에 id 저장해놓은 값 
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getUserInfo(userid);
		req.setAttribute("vo",vo);
		
		
		OrderDAO dao1 = new OrderDAO();
		OrderVO vo1 = dao1.orderInfo(userid);
		
		IntroDAO dao2 = new IntroDAO();
		String setterId = vo1.getSetterId();
		IntroVO vo2 = dao2.selectIntroVO(setterId);
		req.setAttribute("ordervo", vo1);
		
		
		return "myProfile.jsp";
	}

}
