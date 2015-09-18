package actionPackage;
import infoPackage.CustomerInfo;

import com.opensymphony.xwork2.ActionSupport;

import daoPackage.CustomerManagementDao;

/**
 * 情報を更新する判断
 * @author ZhouPing
 *
 */
public class CustomerUpdateAction extends ActionSupport{

	//接受从前面传过来的值；
	private String userName;
	private String address;
	private String email;
	private String message="";
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 *  顧客情報を変更する成功か判断する
	 */
	public String execute() throws Exception{
		//对前台传过来的值进行判断，判断传过来的值是否为空
		//空的情况下，返回一个不能为空的message
		if(email==null || email.equals("")){
			message +="email不能为空";
		}
		if(address==null ||address.equals("")){
			message +="address不能为空";
		}

		//如果message不为空的情况下，返回一个success字符串给前台
		if(!this.message.equals("")){
			return "success";
		}
		//然后往UserInfo类中，加入从前台传过来的值
		CustomerInfo uu=new CustomerInfo();
		uu.setAddress(this.address);
		uu.setEmail(this.email);
		uu.setUserName(this.userName);
		//调用dao的方法，把从前面得到的值传到dao的类中
		CustomerManagementDao dao = CustomerManagementDao.getInstance();
		Boolean result=dao.updateUser(uu);
		//进行判断，对的话返回变更成功，
		if(result==true){
			message +="变更成功";
		}else{
		//错的话返回变更失败
			message +="变更失败";
		}

		return "success";

	}


}
