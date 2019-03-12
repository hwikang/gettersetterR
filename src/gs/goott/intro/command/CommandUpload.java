package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gs.goott.content.ContentDAO;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;

public class CommandUpload implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession ses = req.getSession();
		String userid = (String)ses.getAttribute("userid");
		IntroDAO introDAO = new IntroDAO();
		IntroVO introVO = introDAO.selectIntroVO(userid);
		
		ContentDAO contentDAO = new ContentDAO();
		req.setAttribute("introVO", introVO);
		
		return "upload.jsp";
	}

}
