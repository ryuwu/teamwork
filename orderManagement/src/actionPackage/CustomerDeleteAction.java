package actionPackage;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerDeleteAction extends ActionSupport{
	private String userName;
	private String email;
	private String address;
	private String message="";

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String execute() throws Exception{
		message=this.userName;
		return "success";
	}





}
