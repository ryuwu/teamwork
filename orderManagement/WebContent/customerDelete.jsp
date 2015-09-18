<!--確認削除を表す-->

<!--@author luo-->
<!--@date 2015/09/18-->
<!--@version1.0-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>確認削除</title>
	</head>
	<body>
			<s:form action="viewAllUsers" namespace="/mystruts" >
				<!-- 取消按钮.返回顾客情报管理页面(customerManage.jsp) -->
				<s:submit value="取消" />
			</s:form>

			<s:form action="" namespace="/mystruts" >
				<!--接收所要删除客户的信息 -->
				<s:property escape='0' value = "message"/>

				<s:submit value="確認" />
			</s:form>


	</body>
</html>