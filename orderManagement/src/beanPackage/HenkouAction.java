package beanPackage;

import com.opensymphony.xwork2.ActionSupport;

public class HenkouAction extends ActionSupport{
	private String userName;
	private String address;
	private String email;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String execute() throws Exception{
		return "success";
	}

}
