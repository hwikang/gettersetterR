package gs.goott.intro.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gs.goott.controller.CommandService;

public class CommandReplyWrite implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String commentContent = req.getParameter("commentContent");
		Double star = Double.parseDouble(req.getParameter("star"));
		String commentor = req.getParameter("commenter");
		
		
		return null;
	}

}
