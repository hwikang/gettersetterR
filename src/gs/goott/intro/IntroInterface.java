package gs.goott.intro;

import java.util.List;

import gs.goott.content.ContentVO;

public interface IntroInterface {
	public int introInsert(String userid);	//setter��� cotent ����
	public int introUpdate(IntroVO vo, String path);  //setter��� cotent ����
	public IntroVO selectIntroVO(String userid);  //setter��� cotent ����
	
	public List<IntroVO> getRecommendContents(String interest); //���ο��� ��õ ����(������) �ѷ��ֱ��
}
