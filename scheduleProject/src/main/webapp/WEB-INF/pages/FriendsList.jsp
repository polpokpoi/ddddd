<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BitsPedia - Facebook Friends List</title>
</head>
<body>
	<h1>Friends List</h1>
	<table>
		<c:forEach items="${friendsList}" var="fbuser">
			<tr>
				<td><c:out value="${fbuser.name}" /></td>
				<td><img src='https://graph.facebook.com/<c:out value="${fbuser.id}"/>/picture' />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>