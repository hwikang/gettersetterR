package gs.goott.content;

import java.util.List;

public interface ContentInterface {
	public int contentWrite(ContentVO vo); //牧刨明 积己
	public List<ContentVO> getContentList(String userid); //牧刨明 格废
	public ContentVO getContent(String userid, int contentNo); //牧刨明 1俺 免仿
	public List<ContentVO> getInterestList(String userid, String interest, int contentNo); //牧刨明 格废 府胶飘 免仿
}
