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
					//아이디,비번일치
					cnt =1;					
				}else {
					//비번일치하지않음
					cnt=0;
				}
			}else {
			//userid 존재하지않음	
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
			String sql="select count(userid) from memberTbl where userid=?"; //없는 아이디는 0을 반환
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("아이디 체크 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt; // 카운트가 없으면 0 있으면 있는 만큼 숫자반환 
	}

	@Override
	public int buyAcorn(String userid, int buyAcorn,int myAcorn) {
		// Acorn 충전
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
			//introDAO.insertIntro(vo.getUserid()); //insertIntro에 userid값 넘겨주기
			//idCheck(vo.getUserid()); // 중복체크에 userid값 넘겨주기
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원가입 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;

	}

	//회원 정보 가져오기
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
				vo.setUserno(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setUserpwd(rs.getString(3));
				vo.setTel(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setUserImage(rs.getString(6));
				vo.setInterestStr(rs.getString(7));
				vo.setMyAcorn(rs.getInt(8));
				vo.setContentPrice(rs.getInt(9));
				vo.setUserLevel(rs.getInt(11));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get user information error");
		}finally {
			dbClose();
		}
		
		return vo;
	}

	
	}



