package gs.goott.intro;

import gs.goott.util.DBConnection;

public class OrderDAO extends DBConnection implements OrderInterface{

	@Override
	public int orderContent(String setterId, String getterId, Double price) {
		int cnt =0;
		try {
			dbConn();
			String sql = "insert into ordertbl values(ordersq.nextval,?,?,?,sysdate)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, setterId);
			pstmt.setString(2, getterId);
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

}
