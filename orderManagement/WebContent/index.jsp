<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getSum</title>
</head>
<body>


<s:form action="viewAllUsers" namespace="/mystruts" >
<s:submit value="顧客情報管理" />
</s:form>

<s:form action="" namespace="/mystruts" >
<s:submit value="商品管理" />
</s:form>

<s:form action="" namespace="/mystruts" >
<s:submit value="受注管理" />
</s:form>

</body>
</html>
