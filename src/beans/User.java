package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@ManagedBean
@ViewScoped
public class User {
	@NotNull(message="Please enter first name, this is required")
	@Size(min =4, max =15)
	String firstName= "";
	
	@NotNull(message="Please enter last name, this is required")
	@Size(min =4, max =15)
	String lastName = "";
	
	public User()
	{
		firstName = "Thong";
		lastName = "Nguyen";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}