<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Order</title>
</head>
<body>
	<form:form modelAttribute="orderAdd">
		<h1>Add Ship</h1>
		<table>
			<tr>
				<td>Ship Name:</td>
				<td>
					<form:select path="ship" items="${shippingList}"/>
				</td>
			</tr>
			<tr>
			<td>Shipping Company:</td>
				<td>
					<form:select path="shippingCompany" items="${orderCompanyList}"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Order Ship" /></td>
			</tr>
		</table>
		<br>
		<a href="/">Home</a>
	</form:form>
</body>
</html>