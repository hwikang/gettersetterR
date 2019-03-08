package gs.goott.content;

import java.util.ArrayList;
import java.util.List;

import gs.goott.util.DBConnection;

public class ContentDAO extends DBConnection implements ContentInterface {

	@Override
	public int contentWrite(ContentVO vo) {
		int cnt = 0;			
		try {
			dbConn();
			String sql = "select"; 
		}catch(Exception e) {
			System.out.println("contentwrite error"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt; 
	}
	
	
}
