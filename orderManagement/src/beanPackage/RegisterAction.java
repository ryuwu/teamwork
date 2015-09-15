package beanPackage;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.UserManagementDao;


public class RegisterAction extends ActionSupport{

//用于接受前台数据
	private String userName;
	private String email;
	private String address;

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

	//用于向前台传送username、email、address值。

	private String registerResult = "";

	public String getRegisterResult() {
		return registerResult;
	}


	public void setRegisterResult(String registerResult) {
		this.registerResult = registerResult;
	}

	//通过userinfo向dao传送数据
	public String execute() throws Exception{

		if(userName == null || userName.equals("")){
			this.registerResult += "★会社名不能为空★<br/>";
		}

		if(email == null || email.equals("")){
			this.registerResult += "★email不能为空★<br/>";
		}

		if(address == null || address.equals("")){
			this.registerResult += "★address不能为空★<br/>";
		}

		if(!this.registerResult.equals("")){
			return "success";
		}


		UserInfo uInfo = new UserInfo();
		uInfo.setUserName(this.userName);
		uInfo.setEmail(this.email);
		uInfo.setAddress(this.address);

		//dao通过boolean值返回判断结果
		UserManagementDao dao = UserManagementDao.getInstance();
		boolean result = dao.addUser(uInfo);

		if(result){

			this.registerResult += "追加成功";

		}else{

			this.registerResult += "追加失败，您的公司名已经被注册";

		}

		return "success";

	}



}

