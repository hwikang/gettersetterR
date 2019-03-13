package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandBuy implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		//userid �� ���ܼ� 
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");
		MemberDAO memberDao = new MemberDAO();
		MemberVO memberVo = memberDao.getUserInfo(userid);
		int myAcorn = memberVo.getMyAcorn();
		//introNo �� ����
		IntroDAO introDao = new IntroDAO();
		IntroVO introVo = introDao.getIntro(introNo);
		Double price = introVo.getPrice();
		//��
		int cnt = 0;
		if(myAcorn-price<0) {//�ܾ׺���
			cnt = -1;
			req.setAttribute("cnt", cnt);
		}else {
		//�ܾ�����
		
		//�߰�
		
		}
		return null;
	}

}
