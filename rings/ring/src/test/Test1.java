package test;

import static org.junit.Assert.*;

import net.ring.dao.impl.OrderDaoImpl;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		System.out.println(orderDaoImpl.findLastOrderId());
	}

}
