package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface 
{
	List<Order> orders = new ArrayList<Order>();
	
	public AnotherOrdersBusinessService()
	{
		orders.add(new Order("0000000000", "This is another product 1", 1.00f, 1));
		orders.add(new Order("0000000001", "This is another product 2", (float)2.00, 2));
		orders.add(new Order("0000000002", "This is another product 3", (float)3.00, 3));
		orders.add(new Order("0000000003", "This is another product 4", (float)4.00, 4));
		orders.add(new Order("0000000004", "This is another product 5", (float)5.00, 5));
		orders.add(new Order("0000000005", "This is another product 6", (float)6.00, 6));
		orders.add(new Order("0000000006", "This is another product 7", (float)7.00, 7));
		orders.add(new Order("0000000007", "This is anotherproduct 8", (float)8.00, 8));
		orders.add(new Order("0000000009", "This is another product 9", (float)9.00, 9));
		orders.add(new Order("0000000010", "This is another product 10", (float)10.00, 10));
	}
	public void test() {
		// TODO Auto-generated method stub
		
		System.out.println("==========> Hello from AnotherOrdersBusinessService()");
	}
	public List<Order> getOrders()
	{
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public void sendOrder(Order order) {
		// Do nothing
		
	}
	

}
