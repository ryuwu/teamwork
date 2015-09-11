package datapackage;

import java.util.ArrayList;

import dataFlowPackage.UserInfo;


public class RegisterData {


	private static RegisterData instance=new RegisterData();

	private RegisterData (){

	}

	public static RegisterData getInstance() {

	return instance;

	}


	ArrayList<UserInfo> list = new ArrayList<UserInfo>();


	public boolean checkData(UserInfo cs) {
		boolean result = true;

		for(UserInfo u : list) {
			if(u.getUsername().equals(cs.getUsername())){
				result = false;
				break;
			}
		}

		if(result) {
			list.add(cs);
			return true;
		}else{
			return false;
		}
	}

	public boolean hasData(UserInfo cs) {
		boolean result = false;

		for(UserInfo u : list) {
			if(u.getUsername().equals(cs.getUsername())){
				result = true ;
				break;
			}
		}
		return result;
	}

	public boolean hasPassword(UserInfo cs) {
		boolean result = false;

		for(UserInfo u : list) {
			if(u.getUsername().equals(cs.getUsername())){
				if(u.getPassword().equals(cs.getPassword()))
				result = true ;
				break;
			}
		}
		return result;

	}
}



