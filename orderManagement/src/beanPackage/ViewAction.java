package beanPackage;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.UserManagementDao;

public class ViewAction extends ActionSupport{

	private String result1;

	public String execute() throws Exception{

		UserManagementDao dao = UserManagementDao.getInstance();
		List<UserInfo> result = dao.getUserInfos();
		for(UserInfo userInfo:result) {
			this.result1 += userInfo.getUserName() + userInfo.getEmail() + userInfo.getAddress() + "<br />";

		}

		return "zhouping";

	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

}