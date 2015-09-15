package beanPackage;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.UserManagementDao;

public class ViewAction extends ActionSupport{

	private String result1 = "";

	public String execute() throws Exception{

		UserManagementDao dao = UserManagementDao.getInstance();
		List<UserInfo> result = dao.getUserInfos();

		//显示表头
		this.result1 += "<table border=\"1\"><tr><th>会社の名前</th><th>会社のE-mail</th><th>住所</th></tr>";


		for(UserInfo userInfo:result) {
			this.result1 += "<tr>";
			this.result1 += "<td>" +userInfo.getUserName() + "</td><td>" + userInfo.getEmail() + "</td><td>" + userInfo.getAddress() + "</td>";
			this.result1 += "</tr>";
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