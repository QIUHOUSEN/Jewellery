package net.ring.dao;

import java.util.ArrayList;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

import bean.Buy;
import bean.Orders;
import bean.Ring;
import bean.Users;
//by @邱厚森
/*购买*/
public interface BuyDao {
	
	//增加购买，即用户没点击一次“加入购物车”按钮就会是一次购买(一次购买对应一个订单)
	public Boolean addBuy(Ring ring, Users users);//某一个用户买了某一个戒指
	public boolean addBuy(Buy buy);//通过一个buy对象来添加购买
	public int countBuyCord();//在数据库查询有多少条购买的记录
	public ArrayList<Buy> findAllBuy(Users users);//返回数据库的所有buy到一个集合
	public Boolean deleteBuy(int BuyId);//根据buy的id来删除这次购买
	public void updateBuyStatus(Users users);//设置购买的状态。1：已下单，  0：未下单
	//以下王静的
	public Map<Integer,Integer> findBuyNumber();
}
