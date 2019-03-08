package gs.goott.content.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gs.goott.content.ContentDAO;
import gs.goott.content.ContentVO;
import gs.goott.controller.CommandService;

public class CommandContentWrite implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletContext().getRealPath("/uploadtest");
		int maxSize = 1024*1024*1024;
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req,path,maxSize,"UTF-8",pol);
		
		/*HttpSession session = req.getSession(); 세션값으로 아이디 가져오기
		String userid = (String)session.getAttribute("userid");*/
		ContentVO vo = new ContentVO();
		vo.setUserid("zbass90");
		vo.setTitle(mr.getParameter("title"));
		vo.setDescription(mr.getParameter("description"));
		vo.setInterest(mr.getParameter("interest"));
		
		String fileName = "";
		
		Enumeration fileList = mr.getFileNames();
		if(fileList.hasMoreElements()) {
			String oldFile = (String)fileList.nextElement();
			fileName =mr.getFilesystemName(oldFile);
		}
		vo.setFilename(fileName);
		
		ContentDAO dao = new ContentDAO();
		int cnt = dao.contentWrite(vo);
		
		return "upload.jsp";
	}

}
