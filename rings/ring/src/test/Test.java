package test;

import net.ring.dao.impl.OrderDaoImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		System.out.println(orderDaoImpl.findLastOrderId());
		
	}

}
