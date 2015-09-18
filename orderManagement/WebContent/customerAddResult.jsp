<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>追加結果</title>
	</head>

	<body>

		<!-- 通过struts连接beanPackage.ViewAction -->
		<s:form action="viewAllUsers" namespace="/mystruts" >
		<!-- 返回按钮.返回顾客情报管理页面(customerManage.jsp) -->
		<s:submit value="戻る" />
		</s:form>
		<br>
		<br>

		<!-- 接收后台处理后的信息(追加客户成功或者失败) -->
		<s:property escape='0' value = "registerResult"/>

	</body>
</html>