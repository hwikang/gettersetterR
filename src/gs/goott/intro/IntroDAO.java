package gs.goott.intro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gs.goott.content.ContentVO;
import gs.goott.util.DBConnection;

public class IntroDAO extends DBConnection implements IntroInterface {

	@Override
	public int introUpdate(IntroVO vo, String path) {
		int cnt = 0;
		String delFileName ="";
		String delThumbName ="";
		try {
			dbConn();
			String sql ="select filename, thumbnailFileName from introtbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				delFileName = rs.getString(1);
				delThumbName = rs.getString(2);
			}
			sql = "update introtbl set filename=?, interest=?, description=?, thumbnail=?, title=?, introdate=sysdate, thumbnailFileName=? where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getFilename());
			System.out.println(vo.getInterestStr().toLowerCase());
			pstmt.setString(2, vo.getInterestStr().toLowerCase());			
			pstmt.setString(3, vo.getDescription());
			pstmt.setString(4, vo.getThumbnail());
			System.out.println(vo.getTitle());
			pstmt.setString(5, vo.getTitle());
			System.out.println(vo.getUserid());
			pstmt.setString(6, vo.getThumbnailFileName());
			pstmt.setString(7, vo.getUserid());
			cnt = pstmt.executeUpdate();
			
			System.out.println("delFileName="+delFileName+"\ndelThumbName"+delThumbName);
			if(delFileName!=null && !delFileName.equals("")) {
				File f = new File(path,delFileName);
				File f2 = new File(path,delThumbName);
				if(vo.getBeforeFileName()==delFileName) {
					f.delete();
				}
				if(vo.getBeforeThumbnail()==delThumbName) {
					f2.delete();
				}
			}
		}catch(Exception e) {
			System.out.println("intro insert error"+e.getMessage());
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}

	@Override
	public IntroVO selectIntroVO(String userid) {
		IntroVO vo = new IntroVO();
		try {
			dbConn();
			String sql = "select introno, userid, filename, interest, description, to_char(introdate, 'YYYY-MM-DD'), title, follower, price, thumbnail from introtbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIntroNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setFilename(rs.getString(3));
				vo.setInterestStr(rs.getString(4));
				vo.setDescription(rs.getString(5));
				vo.setIntrodate(rs.getString(6));
				vo.setTitle(rs.getString(7));
				vo.setFollower(rs.getInt(8));
				vo.setPrice(rs.getDouble(9));
				vo.setThumbnail(rs.getString(10));
			}
		}catch(Exception e) {
			System.out.println("intro select error"+e.getMessage());
		}finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public int introInsert(String userid) {
		int cnt = 0;
		try {
			dbConn();
			String sql = "insert into introtbl(introNo, userid, filename, interest, description, introdate) values(introSq.nextVal, ?, 'Please attach the introvideo..', 'basic','(less than 500 letters)', sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("intro add content error"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	//���ο� ���̴� ��õ ������
	@Override
	public List<IntroVO> getRecommendContents(String interest) {
		//interest �ڸ���
		String interestArr[] = interest.split("/");
		for(int i =0; i<interestArr.length;i++) {
			System.out.println(interestArr[i]);
		}
		//
		List<IntroVO> list = new ArrayList<IntroVO>();
		try {
			dbConn();
			String sql ="select * from (";
			if(interest.equals("none")) {
				//�α��ξ��ѻ���
				sql +="select * from introtbl order by follower desc";
				sql += ") where rownum<=6";
				pstmt = con.prepareStatement(sql);
				System.out.println("sql = "+sql);
			}else {
				if(interestArr.length==1){
					//���ɻ� 1��
					sql +="select * from introtbl where  interest = ? order by follower desc";				
				}else if(interestArr.length==2){
					//���ɻ� 2��
					sql +="select * from introtbl where  interest = ? or  interest = ? order by follower desc";
				}else if(interestArr.length==3){
					//���ɻ� 3��
					sql +="select * from introtbl where  interest = ? or  interest = ? or interest= ? order by follower desc";
				}	
				sql += ") where rownum<=6";
				pstmt = con.prepareStatement(sql);
				
				for(int i=0 ; i<interestArr.length;i++) {
					System.out.println("�迭���� ="+interestArr.length);
					System.out.println(i);
					pstmt.setString(i+1, interestArr[i]);
				}
				System.out.println("sql = "+sql);
			}		
			
			sql += ") where rownum<=6";
			
			
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroVO vo = new IntroVO();
				vo.setIntroNo(rs.getInt("introno"));
				vo.setUserid(rs.getString("userid"));
				vo.setFilename(rs.getString("filename"));
				vo.setInterestStr(rs.getString("interest"));				
				vo.setDescription(rs.getString("description"));
				vo.setThumbnail(rs.getString("thumbnail"));
				vo.setIntrodate(rs.getString("introdate"));
				vo.setTitle(rs.getString("title"));
				vo.setFollower(rs.getInt("follower"));
				vo.setPrice(rs.getDouble("price"));
				list.add(vo);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get 6 recommendContents error");
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public String getInterest(String userid) {
		String interestStr ="";
		try {
			dbConn();
			String sql = "select interest from membertbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				interestStr = rs.getString("interest");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getInterest error");
		}finally{
			dbClose();
		}
		return interestStr;
	}

	@Override
	public List<IntroVO> getContent(String interest,String search) {
		List<IntroVO> list = new ArrayList<IntroVO>();
		String sql ="";
		try {
			dbConn();
			System.out.println("interest="+interest);
			//���ɻ�,Ű���� �Ѵ� 0
			if((interest.equals("")||interest.equals("all")) && search.equals("")) {
				sql = "select * from introtbl";
				pstmt = con.prepareStatement(sql);
			}
			//���ɻ縸����
			else if(search.equals("")&&( !interest.equals("") && !interest.equals("all"))) {
				sql = "select * from introtbl where interest=?";	
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, interest);
			}
			//Ű���常����
			else {
				sql = "select * from introtbl where title like '%"+search+"%' or description like '%"+search+"%'";
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroVO vo = new IntroVO();
				vo.setIntroNo(rs.getInt("introno"));
				vo.setUserid(rs.getString("userid"));
				vo.setFilename(rs.getString("filename"));
				vo.setInterestStr(rs.getString("interest"));				
				vo.setDescription(rs.getString("description"));
				vo.setThumbnail(rs.getString("thumbnail"));
				vo.setIntrodate(rs.getString("introdate"));
				vo.setTitle(rs.getString("title"));
				vo.setFollower(rs.getInt("follower"));
				vo.setPrice(rs.getDouble("price"));
				list.add(vo);				
			}
			System.out.println("list size in getConents method="+list.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getCONTENT error");
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public IntroVO getIntro(int introNo) {
		IntroVO vo = new IntroVO();
		try {
			dbConn();
			String sql = "select * from introtbl where introNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, introNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setIntroNo(rs.getInt("introno"));
				vo.setFilename(rs.getString("filename"));
				vo.setUserid(rs.getString("userid"));
				vo.setInterestStr(rs.getString("interest"));
				vo.setDescription(rs.getString("description"));
				vo.setIntrodate(rs.getString("introdate"));
				vo.setThumbnail(rs.getString("thumbnail"));
				vo.setTitle(rs.getString("title"));
				vo.setFollower(rs.getInt("follower"));
				vo.setPrice(rs.getDouble("price"));
				System.out.println("get �ϰ��ִ� intro userid="+vo.getUserid());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get intro error");
		}finally {
			dbClose();
		}
		return vo;
	}
	
}
