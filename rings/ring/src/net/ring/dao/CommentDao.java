package net.ring.dao;
//by @邱厚森
/*该接口实现对评论的增删
 * */
import java.util.ArrayList;

import bean.Comment;
import bean.Ring;

public interface CommentDao {
	//public Boolean addComment(Ring ring);//对某一个指定的戒指增加评论
	//public Boolean deleteComment(Comment comment);//对某一个指定评论删除（根据评论的id）
	//王静的
	public ArrayList<Comment> findComment(int ringid);
	public int findRingId(String str);
	public void addComment(Comment com);
}
