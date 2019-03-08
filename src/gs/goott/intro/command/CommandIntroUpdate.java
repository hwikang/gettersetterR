package gs.goott.intro.command;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.media.sound.FFT;

import gs.goott.controller.CommandService;
import gs.goott.intro.IntroDAO;
import gs.goott.intro.IntroVO;

public class CommandIntroUpdate implements CommandService {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = "\\\\GOOTT-1-13-PC\\gettersetter\\Introduction";
		int maxSize = 1024*1024*1024;
		System.out.println(path);
		DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(req, path, maxSize, "UTF-8", pol);		
		IntroVO vo = new IntroVO();
		vo.setUserid("zbass90");
		vo.setInterest(mr.getParameterValues("interest"));
		vo.setDescription(mr.getParameter("description"));		
		
		String fileName = "";

		Enumeration fileList = mr.getFileNames();
		if(fileList.hasMoreElements()) {
			String oldFile = (String)fileList.nextElement();
			fileName = mr.getFilesystemName(oldFile);
		}
		vo.setFilename(fileName);
	
		IntroDAO dao = new IntroDAO();
		int cnt = dao.introUpdate(vo,path);
		
		
		IntroVO vo2 = dao.selectIntroVO(vo.getUserid());		
		req.setAttribute("cnt", cnt);
		req.setAttribute("vo", vo2);		
			
		return "upload.jsp";
	}

}
