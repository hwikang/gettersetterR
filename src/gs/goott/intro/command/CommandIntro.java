package gs.goott.intro.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.replyDAO;
import gs.goott.intro.replyVO;
import gs.goott.signup.MemberVO;

public class CommandIntro implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int introNo = Integer.parseInt(req.getParameter("introNo"));
		System.out.println("introNo="+introNo);
		IntroVO vo = new IntroVO();
		IntroDAO dao =new IntroDAO();
		vo = dao.getIntro(introNo);
		req.setAttribute("introVO", vo); //membervo 와 곂칠우려가 있어 introVO 로 이름을 지정		
	
		replyDAO replyDao = new replyDAO();
		List<replyVO> list = replyDao.getReply(introNo);	
		req.setAttribute("list", list);
		
		return "intro.jsp";
	}

}
