package bean;
/*戒指
 * */
//by @邱厚森
public class Ring {
	private int RingId;//戒指id
	private int Price;//戒指价格
	private int SaleNum;//戒指总售量
	private String Weight;//戒指重量
	private String Color;//戒指色泽
	private String Clean;//戒指净度
	private String Cut;//戒指切工
	private String Quality;//戒指材质
	private int Size;//戒指尺寸
	private String RingImage;//每个戒指对应的图片名字或者地址
	private int CommentNum;//每个戒指评论数量
	
	public int getRingId() {
		return RingId;
	}
	public void setRingId(int ringId) {
		RingId = ringId;
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
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
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
	
	
}
