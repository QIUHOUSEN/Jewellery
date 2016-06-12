package bean;
/*
 * 购买*/
//by @邱厚森
public class Buy {
	private int BuyId;//购买id
	private int UserId;//用户id
	private int RingId;//戒指id
	private int OrderId;//订单id
	private int BuyNum;//购买数量
	private int BuySize;//购买尺寸
	public int getBuyId() {
		return BuyId;
	}
	public void setBuyId(int buyId) {
		BuyId = buyId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getRingId() {
		return RingId;
	}
	public void setRingId(int ringId) {
		RingId = ringId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getBuyNum() {
		return BuyNum;
	}
	public void setBuyNum(int buyNum) {
		BuyNum = buyNum;
	}
	public int getBuySize() {
		return BuySize;
	}
	public void setBuySize(int buySize) {
		BuySize = buySize;
	}
	
	
}
