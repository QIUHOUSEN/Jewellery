package bean;

public class OrderList {
    //Orders表
	//by杨后青
	private int orders_OrderId;//订单id
	private int orders_UserId;//用户Id
	private int OrderAllPrice;//订单总价
	//ring表
	private int ring_RingId;//戒指id
	private int Price;//戒指价格
	private int SaleNum;//戒指总售量
	private String Weight;//戒指重量
	private String Color;//戒指色泽
	private String Clean;//戒指净度
	private String Cut;//戒指切工
	private String Quality;//戒指材质
	private String Size;//戒指尺寸
	private String RingImage;//每个戒指对应的图片名字或者地址
	private int CommentNum;//每个戒指评论数量
	//buy表
	private int buy_BuyId;//购买id
	private int buy_UserId;//用户id
	private int buy_RingId;//戒指id
	private int buy_OrderId;//订单id
	private int BuyNum;//购买数量
	public int getOrders_OrderId() {
		return orders_OrderId;
	}
	public void setOrders_OrderId(int orders_OrderId) {
		this.orders_OrderId = orders_OrderId;
	}
	public int getOrders_UserId() {
		return orders_UserId;
	}
	public void setOrders_UserId(int orders_UserId) {
		this.orders_UserId = orders_UserId;
	}
	public int getOrderAllPrice() {
		return OrderAllPrice;
	}
	public void setOrderAllPrice(int orderAllPrice) {
		OrderAllPrice = orderAllPrice;
	}
	public int getRing_RingId() {
		return ring_RingId;
	}
	public void setRing_RingId(int ring_RingId) {
		this.ring_RingId = ring_RingId;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getSaleNum() {
		return SaleNum;
	}
	public void setSaleNum(int saleNum) {
		SaleNum = saleNum;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getClean() {
		return Clean;
	}
	public void setClean(String clean) {
		Clean = clean;
	}
	public String getCut() {
		return Cut;
	}
	public void setCut(String cut) {
		Cut = cut;
	}
	public String getQuality() {
		return Quality;
	}
	public void setQuality(String quality) {
		Quality = quality;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getRingImage() {
		return RingImage;
	}
	public void setRingImage(String ringImage) {
		RingImage = ringImage;
	}
	public int getCommentNum() {
		return CommentNum;
	}
	public void setCommentNum(int commentNum) {
		CommentNum = commentNum;
	}
	public int getBuy_BuyId() {
		return buy_BuyId;
	}
	public void setBuy_BuyId(int buy_BuyId) {
		this.buy_BuyId = buy_BuyId;
	}
	public int getBuy_UserId() {
		return buy_UserId;
	}
	public void setBuy_UserId(int buy_UserId) {
		this.buy_UserId = buy_UserId;
	}
	public int getBuy_RingId() {
		return buy_RingId;
	}
	public void setBuy_RingId(int buy_RingId) {
		this.buy_RingId = buy_RingId;
	}
	public int getBuy_OrderId() {
		return buy_OrderId;
	}
	public void setBuy_OrderId(int buy_OrderId) {
		this.buy_OrderId = buy_OrderId;
	}
	public int getBuyNum() {
		return BuyNum;
	}
	public void setBuyNum(int buyNum) {
		BuyNum = buyNum;
	}
	

}
