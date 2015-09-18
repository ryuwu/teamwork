<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- @author jiang 		-->
<!-- @date 2015/09/18 	-->
<!-- @version 1.0 		-->

<!-- 削除結果を表す 	-->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>削除結果</title>
	</head>
	<body>
		<!-- 裏から情報を受け取る -->
		<s:property escape='0' value = "message"/>
		<br>
		<!-- け取った情報をアクションに渡す -->
		<s:form action="viewAllUsers" namespace="/mystruts" >
			<!-- 戻るbutton -->
			<s:submit value="返回" />
		</s:form>
	</body>
</html>