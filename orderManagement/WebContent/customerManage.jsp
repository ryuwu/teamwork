<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>顧客情報管理</title>
	</head>

	<body>

	<!-- 添加用户按钮.超链接到用户添加页面(customerAdd.jsp) -->
	<s:a href="../customerAdd.jsp"><input type="button" value="添加用户"></s:a>

	<!--接收并显示后台信息(所有顾客信息列表) -->
	<!-- TODO 前台负责显示顾客信息列表 -->
	<s:property escape='0' value = "result1"/>

	<!-- 返回首页按钮.超链接到受注管理系统页面(index.jsp) -->
	<s:a href="../index.jsp"><input type="button" value="返回首页"></s:a>

	</body>
</html>