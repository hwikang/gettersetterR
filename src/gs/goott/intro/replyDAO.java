package gs.goott.intro;

import gs.goott.util.DBConnection;

public class replyDAO extends DBConnection implements ReplyInterface {

	@Override
	public int writeReply(String commenter, String commentContent, Double star,int introNo) {
		int cnt =0;
		try {
			dbConn();
			String sql = "insert into replttbl values()";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("write reply error");
		}finally {
			dbClose();
		}
		
		
		return cnt;
	}
	
}
