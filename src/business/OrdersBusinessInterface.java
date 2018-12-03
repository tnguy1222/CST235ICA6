package business;

import javax.ejb.Local;

import beans.Order;

import java.util.List;

@Local
public interface OrdersBusinessInterface 
{
	public void test();
	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
	public void sendOrder(Order order);

}
