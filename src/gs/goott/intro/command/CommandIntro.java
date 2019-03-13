package gs.goott.intro.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;
import gs.goott.intro.replyDAO;
import gs.goott.intro.replyVO;
import gs.goott.signup.MemberDAO;
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
		
		String userid = vo.getUserid();	//content 자료 불러오기!
		ContentDAO dao2 = new ContentDAO();
		List<ContentVO> cList = dao2.getContentList(userid);
		req.setAttribute("cList", cList);
		
		System.out.println("VO="+vo.getUserid());	
	
		replyDAO replyDao = new replyDAO();
		List<replyVO> list = replyDao.getReply(introNo);	
		req.setAttribute("list", list);
		
		//헤더의 정보를 업데이트하기 위해 다시 세션설정
		MemberVO memberVo = new MemberVO();
		MemberDAO memberDao = new MemberDAO();
			//로그인한유저아이디
			String loginUserid = (String)session.getAttribute("userid");
		memberVo = memberDao.getUserInfo(loginUserid);
		session.setAttribute("vo", memberVo);
		
		
		return "intro.jsp";
	}

}
