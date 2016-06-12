package net.ring.dao;
//by @邱厚森
import java.util.ArrayList;

import bean.Ring;

/*对戒指的操作
 * 
 * */
public interface RingDao {

	public int GetSalesNum(Ring ring);//获得某一个确定的戒指的销售数量
	public Boolean addRing(Ring ring,String table);//往数据库中存入一个戒指
	public ArrayList<Ring> findRing(Ring ring);//根据传入的某一个戒指查询这个戒指的所有信息，并且显示在戒指详细信息页面
	public Ring findSpecialRing(String RingImage);//通过戒指的image字段找到这个戒指
	public boolean insertRingSize(int size, int ringId);//将用户购买的戒指的戒指尺寸放进戒指的尺寸属性
	public Ring findByRingId(int RingId);//通过某个戒指的ID找到这个戒指
	public Boolean delRing(int ringID,String table,String id);
}
