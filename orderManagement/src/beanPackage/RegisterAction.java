package beanPackage;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.UserManagementDao;


public class RegisterAction extends ActionSupport{

	private String userName;
	private String email;
	private String address;

	private String registerResult;

	public String execute() throws Exception{

		UserInfo uInfo = new UserInfo();

		uInfo.setUserName(this.userName);
		uInfo.setEmail(this.email);
		uInfo.setAddress(this.address);

		UserManagementDao dao = UserManagementDao.getInstance();
		boolean result = dao.checkName(uInfo);

		if(result){
			this.registerResult = "登录成功";
		}else{
			this.registerResult = "登录失败，您的公司名已经被注册";
		}

		return "success";

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

	public String getRegisterResult() {
		return registerResult;
	}

	public void setRegisterResult(String registerResult) {
		this.registerResult = registerResult;
	}
}

