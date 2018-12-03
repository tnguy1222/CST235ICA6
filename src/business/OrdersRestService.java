package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;
import beans.User;

//localhost:8080/Assignment4b/rest/orders/getjson

@RequestScoped
@Path("/orders") //<========= Good naming convention
@Produces({ "application/xml", "application/json"})

public class OrdersRestService 
{
	@Inject
	OrdersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrderAsJson(){
		return service.getOrders();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrderAsXml(){
		List<Order> orders = service.getOrders();
		return orders.toArray(new Order[orders.size()]);
	}
	
	@GET
	@Path("/getUser/{firstname}/{lastname}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("firstname") String firstName,@PathParam("lastname") String lastName) {
		System.out.println("API was /getuser: I received requestfor name: "+ firstName+ " " + lastName);
		return new User();
	}
	
	@POST
	@Path("/saveuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User saveUser(User user)
	{
		System.out.println("API was /saveuser: I received request for name: "
				+ user.getFirstName() + " " 
				+ user.getLastName());
		return user;
	}
}
