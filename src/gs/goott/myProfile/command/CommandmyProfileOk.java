package gs.goott.myProfile.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gs.goott.controller.CommandService;
import gs.goott.signup.MemberDAO;
import gs.goott.signup.MemberVO;

public class CommandmyProfileOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String data = null;
		String type = null;
		if(req.getParameter("pwchange")!=null){
			data = req.getParameter("pwchange"); 
			type = "userpwd";
		}else if(req.getParameter("telchange")!=null){
			data = req.getParameter("telchange"); 
			type = "tel";
		}else if(req.getParameter("emailchange")!=null){
			data = req.getParameter("emailchange"); 
			type = "email";
		}else if(req.getParameter("interestchange")!=null){
			String[] interest = req.getParameterValues("interest");
			data ="";
			for(int i=0; i<interest.length; i++) {
				data += interest[i]+"/";
				System.out.println("interestStr="+data);
			}
			type = "interest";
		}else{ // ������ ���� ����
			String path="\\\\GOOTT-1-13-PC\\gettersetter\\Users\\Thumbnails";
			//String path= req.getServletContext().getRealPath("/profileImage"); //��Ĺ�� �����η� ������ ����.
			//��Ĺ ������=> D:\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\gettersetter\profileImage
			System.out.println("path="+path);
			int Max_size = 1024*1024*20; //20mb�� ����
			DefaultFileRenamePolicy pol = new DefaultFileRenamePolicy();
			MultipartRequest mr = new MultipartRequest(req,path,Max_size,"UTF-8",pol);
			data = mr.getFilesystemName("profilechange"); 
			type = "userImage";
		};
		
		String userid = (String)req.getSession().getAttribute("userid");
		//String userid = "hahaori";
		MemberDAO dao = new MemberDAO();
		int cnt = dao.profileUpdate(userid, data, type);
		MemberVO mem = dao.getUserInfo(userid);
		req.setAttribute("mem", mem);
		return "myProfile.jsp";
		
	}

}
