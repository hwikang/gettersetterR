package gs.goott.intro;

import java.util.List;

public interface OrderInterface  {
	//Ãß°¡	
	public int orderContent(String setterId, String getterId, Double price); 
	
	public OrderVO orderInfo(String sertterId);
	public List<IntroVO> orderList(String userid);
}
