<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
 <HEAD>
  <TITLE> hello </TITLE>
  <script language="javascript">
function userNameCheck(){                             //id检测方法
	var userName = document.myform.userName.value;
 	if(userName.length==0){                                //如果为空
   		alert("用户名不能为空");

    	return false;
	}

 	if( userName.indexOf(" ") != -1 ){

 		alert("用户名不能有空格");

		return false;

	}

	return true;
}

function addressCheck(){                         //密码验证方法
	var address=document.myform.address.value;
 	if(address.length==0){
    	alert("密码不能为空");
  		return false;
 	 }

 	 return true;
  }

function emailCheck(){                         //密码验证方法
	var email=document.Myform.email.value;
 	if( email.indexOf("@") ==-1){
    	alert("请输入正确邮箱地址");
  		return false;
 	 }

 	 return true;
  }


function allCheck(){                        //将两个方法打包一起,这样条用这个allCheck()方法
	if(idCheck()&&addressCheck()&&emailCheck()){                   //时就可以实现两个功能.
   		return true;
 	}
	else{

   		return false;
 	}

}

</script>
</HEAD>
<BODY>

<s:form action="registerUser" namespace="/mystruts" >
<s:textfield name="userName" label="会社の名前" />
<s:textfield name="email" label="E-Mail" />
<s:textfield name="address" label="アドレス" />
<s:submit value="サブミット" />
</s:form>

</BODY>
</HTML>

