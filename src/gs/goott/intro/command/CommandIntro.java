package gs.goott.intro.command;

import java.io.IOException;
import java.util.ArrayList;
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
		req.setAttribute("list", cList);
		
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
		
		//마이프로필에서 history 를위해 session 에 해당 introno 배열 추가
		
		List<IntroVO> history = new ArrayList<IntroVO>();
		//int[] history = new int[10];
		if(session.getAttribute("history")!=null) {
			List<IntroVO> historyList = (List<IntroVO>) session.getAttribute("history");
			for(int i=0;i<historyList.size();i++) {
				//System.out.println("historylist="+historyList.get(i));				
				history.add(historyList.get(i));
			}
		}
		if(!history.contains(introNo)) {  //중복 이면 추가안함 ㅋ
			history.add(dao.getIntro(introNo));
		}
		session.setAttribute("history", history); 
		for(int i=0;i<history.size();i++) {
			System.out.println("history="+history.get(i));
		}
		
		return "intro.jsp";
	}

}
