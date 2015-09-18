<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="updateResult" namespace="/mystruts"  method = "post" >

<s:textfield readOnly="true"  name= "userName" value = "%{userName}" label="社名(変更不可)" />
<s:textfield name="email" value = "%{email}" label="E-Mail" />
<s:textfield name="address" value = "%{address}" label="アドレス" />
<s:submit value="サブミット" />

</s:form>
</body>
</html>

