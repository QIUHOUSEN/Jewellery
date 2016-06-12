package bean;
/*
 * 订单
 * */
//by @邱厚森
public class Orders {
	private int OrderId;//订单id
	private int UserId;//用户Id
	private int OrderAllPrice;//订单总价
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public int getOrderAllPrice() {
		return OrderAllPrice;
	}
	public void setOrderAllPrice(int orderAllPrice) {
		OrderAllPrice = orderAllPrice;
	}
	
}
