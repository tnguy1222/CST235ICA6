package controllers;

import java.text.DecimalFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController 
{
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	MyTimerService timer;
		public String onSubmit(User user) 
		{
			//call business service
			service.test();
		
			//call timer service
			timer.setTimer(10000);
			
			
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User", user);
			return "TestResponse.xhtml";

		}
		public String onSendOrder()
		{
			DecimalFormat df = new DecimalFormat("0000000000");
			String orderNo = df.format(new Date().getTime());
			
			Order order = new Order();
			order.setOrderNo(orderNo);
			order.setProductName("This is a ordered product");
			order.setPrice((float)1000.00);
			order.setQuantity(2000);
			service.sendOrder(order);
			
			return "OrderResponse.xhtml";
		}
		public OrdersBusinessInterface getService()
		{
			return service;
		}
		
}
