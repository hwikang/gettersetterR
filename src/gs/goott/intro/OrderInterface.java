package gs.goott.intro;

import java.util.List;

public interface OrderInterface  {
	//�߰�	
	public int orderContent(String setterId, String getterId, Double price); 
	//����� �Ȼ���� Ȯ�� 
	public List<OrderVO> checkOrderList(String userid);
}
