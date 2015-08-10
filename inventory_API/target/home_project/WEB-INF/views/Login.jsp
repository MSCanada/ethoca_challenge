<%@page import="org.msuhail.java.home_project.service.LocalizationService"%>
<%@page import="java.util.Locale" %>
<%@page import="org.msuhail.java.home_project.model.Users_Auth"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form method="post" action="Login.htm">
<input type="text" name="user_id">
<input type="password" name="password">
<input type="submit">
</form>

<%Users_Auth user=(Users_Auth)session.getAttribute("user_object"); %>
<c:catch var="result">
<c:set var="user_id" value="<%=user.user_id %>"></c:set>

<%=LocalizationService.GetMessage(Locale.FRENCH) %><c:out value="${user_id}" ></c:out>
</c:catch>
</body>
</html>