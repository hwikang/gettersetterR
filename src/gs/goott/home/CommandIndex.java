package gs.goott.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;

public class CommandIndex implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		System.out.println(session.getAttribute("loginStatus"));
		
		//session.setAttribute("loginStatus",0);
		
		//6개의 가장핫한세터추천
		IntroDAO dao = new IntroDAO();
		
		List<IntroVO> list = new ArrayList<IntroVO>();
		 if(session.getAttribute("loginStatus")==null) {
			 System.out.println("로그인안된상태"); 
			 list = dao.getRecommendContents("none");
			 
		 }else{ 			 
			 System.out.println("로그인된상태"); 
			 list = dao.getRecommendContents("bodybuild/acting");
		 }
		 
		
		
		return "index.jsp";
	}

}
