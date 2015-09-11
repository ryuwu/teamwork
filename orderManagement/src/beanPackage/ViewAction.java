package beanPackage;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.UserManagementDao;

public class ViewAction extends ActionSupport{

	//从前台接收数据

	//往前台送数据，前台显示该数据
	private String userViewResult;


	public String execute() throws Exception{


		UserManagementDao dao = UserManagementDao.getInstance();
		List<UserInfo> result = dao.getUserInfos();

		userViewResult = "hello";

		return "zhouping";
	}

	public String getUserViewResult() {
		return userViewResult;
	}

	public void setUserViewResult(String userViewResult) {
		this.userViewResult = userViewResult;
	}







}