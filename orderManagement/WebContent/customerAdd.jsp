<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>顧客追加</title>
	</head>

	<body>

		<!-- 将公司名，E-Mail，アドレス传递给registerUserアクション -->
		<s:form action="registerUser" namespace="/mystruts" >
			<!-- 入力框.会社名 -->
			<s:textfield name="userName" label="会社名" />
			<!-- 入力框.E-Mail -->
			<s:textfield name="email" label="E-Mail" />
			<!-- 入力框.アドレス -->
			<s:textfield name="address" label="アドレス" />
			<!--提交按钮 -->
			<s:submit value="保存" />
		</s:form>


	</body>
</html>

