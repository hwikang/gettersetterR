package gs.goott.intro;

public interface OrderInterface  {
	//Ãß°¡	
	public int orderContent(String setterId, String getterId, Double price); 
	
	public OrderVO orderInfo(String sertterId);
}
