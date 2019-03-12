package gs.goott.signup;

import java.util.ArrayList;
import java.util.List;

import gs.goott.intro.IntroDAO;
import gs.goott.util.DBConnection;

public class MemberDAO extends DBConnection implements SignupInterface {
	
	@Override
	public int loginCheck(String userid, String userpwd) {
		int cnt =0;
		try {
			dbConn();
			String sql = "select userpwd from membertbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userpwd)) {
					//���̵�,�����ġ
					cnt =1;					
				}else {
					//�����ġ��������
					cnt=0;
				}
			}else {
			//userid ������������	
				cnt=-1;
			}
		} catch (Exception e) {
			System.out.println("login check error");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}

	@Override
	public int idCheck(String userid) {
		int cnt =0;
		try {
			dbConn();
			String sql="select count(userid) from memberTbl where userid=?"; //���� ���̵�� 0�� ��ȯ
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("���̵� üũ ����"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt; // ī��Ʈ�� ������ 0 ������ �ִ� ��ŭ ���ڹ�ȯ 
	}

	@Override
	public int buyAcorn(String userid, int buyAcorn,int myAcorn) {
		// Acorn ����
				int cnt = 0;
				try {
					dbConn();
					String sql = "update membertbl set myAcorn=? where userid=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, myAcorn+buyAcorn);
					pstmt.setString(2, userid);					
					cnt = pstmt.executeUpdate();
					
					
				}catch(Exception e) {
					System.out.println("Error"+e.getMessage());
				}finally {
					dbClose();
				}
				return cnt;
	}

	
	@Override
	public MemberVO getMemberRecord(String userid) {
		MemberVO vo = new MemberVO();
		try {
			dbConn();
			String sql = "select * from membertbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				vo.setUserid(rs.getString(2));
				vo.setMyAcorn(rs.getInt(8));				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get member records error!");
		}finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public int signup(MemberVO vo) {
		int cnt =0;
		try {
			dbConn();
			String sql = "insert into memberTbl values(memberSq.nextVal,?,?,?,?,?,?,0,0,sysdate,1)";
			                                             //userno                  myacorn contentPrice regdate userlevel
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpwd());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getUserImage());
			pstmt.setString(6, vo.getInterestStr());
			//pstmt.setInt(7, vo.getContentPrice());
			//pstmt.setInt(8, vo.getUserLevel());
			
			IntroDAO introDAO = new IntroDAO();
			//introDAO.insertIntro(vo.getUserid()); //insertIntro�� userid�� �Ѱ��ֱ�
			//idCheck(vo.getUserid()); // �ߺ�üũ�� userid�� �Ѱ��ֱ�
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("ȸ������ ����"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;

	}

	//ȸ�� ���� ��������
	@Override
	public MemberVO getUserInfo(String userid) {
		MemberVO vo = new MemberVO();
		try {
			dbConn();
			String sql ="select * from membertbl where userid=? ";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUserno(rs.getInt("userno"));
				vo.setUserid(rs.getString("userid"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));
				vo.setUserImage(rs.getString("userimage"));
				vo.setInterestStr(rs.getString("interest"));
				vo.setMyAcorn(rs.getInt("myacorn"));
				vo.setContentPrice(rs.getInt("contentprice"));
				vo.setUserLevel(rs.getInt("userlevel"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get user information error");
		}finally {
			dbClose();
		}
		
		return vo;
	}

	// ȸ������ ���� 
	public int profileUpdate(String userid, String data, String type) {
			int cnt = 0;
			try {
				dbConn();
				String sql = "update membertbl set "+type+"=? where userid=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, data);
				pstmt.setString(2, userid);					
				cnt = pstmt.executeUpdate();
					
			}catch(Exception e) {
				System.out.println("Error"+e.getMessage());
			}finally {
				dbClose();
			}
				return cnt;
	}
	//ȸ�� Ż��
	public int profileDelete(String userid){
		int cnt =0;
		try {
			dbConn();
			String sql = "delete from membertbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}finally {
			dbClose();
		}
			return cnt;
		
	}
	
}



