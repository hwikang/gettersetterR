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
			String sql = "insert into contenttbl values(contentSq.nextVal, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getFilename());
			pstmt.setString(4, vo.getDescription());
			pstmt.setString(5, vo.getInterest());
			pstmt.setString(6, vo.getThumbnail());
			pstmt.setFloat(7, vo.getVideoLength());
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("contentwrite error"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt; 
	}

	@Override
	public List<ContentVO> getContentList(String userid) {
		List<ContentVO> list = new ArrayList<ContentVO>();
		try {
			dbConn();
			String sql = "select contentno, userid, title, interest, videolength from contenttbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ContentVO vo = new ContentVO();
				vo.setContentNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setInterest(rs.getString(4));
				vo.setVideoLength(rs.getFloat(5));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("컨텐츠 목록 불러오기 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}
	
	
}
