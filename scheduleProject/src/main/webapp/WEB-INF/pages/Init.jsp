<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="utf-8" ?>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Add team page</title>
</head>


<body>

<h1>login Users page</h1>

<p>Here you can Login.</p>

<form:form method="POST"   commandName="user"  action="${pageContext.request.contextPath}/home.mju">

<table>

<tbody>
  <tr>
		<td>id:</td>
		<td><form:input path="id" /></td>
	</tr>
	 


	
	
	
	

	
	
	
	
	
	
	
	<tr>
		<td><input type="submit" value="Add" /></td>
		<td></td>
	</tr>

</tbody>
</table>

</form:form>


<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>