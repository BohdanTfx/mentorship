<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
	<h1>List of users.</h1>
	<c:forEach items="users" var="user" varStatus="index">
		<c:if test="${index < 2}">
			<h2>User №${user.id}</h2>
			<div>
				First name: <b>${user.firstName}</b>
			</div>
			<div>
				Last name: <b>${user.lastName}</b>
			</div>
			<div>
				Job title: <b>${user.jobTitle}</b>
			</div>
		</c:if>
	</c:forEach>
</body>
</html>