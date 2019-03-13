package gs.goott.intro;

import java.util.ArrayList;
import java.util.List;

import gs.goott.util.DBConnection;

public class OrderDAO extends DBConnection implements OrderInterface{

	@Override
	public int orderContent(String setterId, String getterId, Double price) {
		int cnt =0;
		try {
			dbConn();
			String sql = "insert into ordertbl values(ordersq.nextval,?,?,?,sysdate)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, getterId);
			pstmt.setString(2, setterId);
			pstmt.setDouble(3,price);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("order content error what the fuxx!");
		}finally {
			dbClose();
		}
		return cnt;
	}
	//order테이블 정보 가져오기
	public OrderVO orderInfo(String sertterId) {
		OrderVO vo = new OrderVO();
		try {
			dbConn();
			String sql ="select getterId, setterId, contentPrice from ordertbl where setterId=? ";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,sertterId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setGetterId(rs.getString("getterId"));
				vo.setSetterId(rs.getString("setterId"));
				vo.setContentPrice(rs.getDouble("contentPrice"));		
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 가져오기 에러");
		}finally {
			dbClose();
		}
		return vo;
	}
	@Override
	public List<IntroVO> orderList(String userid) {
		List<IntroVO> list = new ArrayList<IntroVO>();
		
		try {
			dbConn();
			String sql="select introno, userid, description, title, price, thumbnail from (select * from introtbl, ordertbl where introtbl.userid = ordertbl.setterid)where getterid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroVO vo = new IntroVO();
				vo.setIntroNo(rs.getInt("introNo"));
				vo.setUserid(rs.getString("userid"));
				vo.setDescription(rs.getString("description"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getDouble("price"));
				vo.setThumbnail(rs.getString("thumbnail"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
}
