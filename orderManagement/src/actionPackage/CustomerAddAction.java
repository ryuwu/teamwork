package actionPackage;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 顧客情報を伝送する
 * @author ZhouPing
 *
 */

public class CustomerAddAction extends ActionSupport{
	//接受前台传过来的值
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
		//往前返回一个success的字符串
		return "success";
	}

}
