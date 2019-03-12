package gs.goott.intro;

import java.util.List;

import gs.goott.content.ContentVO;

public interface IntroInterface {
	public int introInsert(String userid);	//setter모드 cotent 생성
	public int introUpdate(IntroVO vo, String path);  //setter모드 cotent 수정
	public IntroVO selectIntroVO(String userid);  //setter모드 cotent 선택
	
	public List<IntroVO> getRecommendContents(String interest); //메인에서 추천 세터(컨텐츠) 뿌려주기용
	public String getInterest(String userid);//유저의 interest 알아오기
	
	public List<IntroVO> getContent(String interest,String search);
}
