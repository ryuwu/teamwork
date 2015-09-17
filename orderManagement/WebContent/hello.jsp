<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="updateUser" namespace="/mystruts"  method = "post">

<s:textfield disable = true name= "userName" value = "<%=request.getParameter("userName") %>" label="会社の名前" />
<s:textfield name="email" value = "<%=request.getParameter("email") %>" label="E-Mail" />
<s:textfield name="address" value = "<%=request.getParameter("address") %>" label="アドレス" />
<s:submit value="サブミット" />

</s:form>
</body>
</html>