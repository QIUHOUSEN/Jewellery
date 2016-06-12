package net.ring.dao;
//by @邱厚森
import java.util.ArrayList;

import bean.Orders;
import bean.Users;

/*此接口包含增加订单，查询某一个指定用户的所有订单
 * */
public interface OrderDao {
	//在管理员界面，根据用户id查看某一个用户的所有订单
	public ArrayList<Orders> findAllOrders(int UserId);
	//某一个用户增加订单(他有可能一次下多个订单)
	public Boolean addOrder(ArrayList<Orders> orders, Users user);
	//某一个用户删除订单（根据页面上的订单号）
	public Boolean deleteOrder(int OrderId);
	//往数据库里面添加order
	public Boolean addOrder(Orders orders);
	public int findLastOrderId();
}
