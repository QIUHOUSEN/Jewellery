package bean;
/*评论
 * */
//by @邱厚森
public class Comment {
	private int CommentId;//评论id
	private int RingId;//戒指id
	private int UserId;//用户id
	private String Content;//评论内容
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public int getRingId() {
		return RingId;
	}
	public void setRingId(int ringId) {
		RingId = ringId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	
	
}
