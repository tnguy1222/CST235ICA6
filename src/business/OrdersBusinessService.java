package business;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Connection;

import beans.Order;
import beans.User;
import data.DataAccessInterface;
import data.OrderDataService;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface 
{
	//@EJB
	//OrderDataService service;
	
	@Inject
	DataAccessInterface<Order> orderDataService;
	
	//@Inject 
	//DataAccessInterface<User> userDataService;
	@Resource(mappedName="java:/ConnectFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/queue/Order")
	private Queue queue;
	
	public OrdersBusinessService()
	{
	}
	public void test() 
	{
		// TODO Auto-generated method stub
		
		System.out.println("==========> Hello from OrdersBusinessService.test()");
	}
	public List<Order> getOrders()
	{
		//userDataService.findById(0);	//<============userDataService. 
		return orderDataService.findAll();
	}
	public void setOrders(List<Order> orders) 
	{
		
	}
	public void sendOrder(Order order) {
		try
		{
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer messageProducer = session.createProducer(queue);
			
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is a test message");
			messageProducer.send(message1);
			
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			messageProducer.send(message2);
			
			connection.close();
		}
		catch(JMSException e) {
        	e.printStackTrace();

		}

	}
}
