<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="css/style.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Show Orders</title>

</head>
<body>

	<h1>Order Details</h1>

	<table>
		<tr>
			<th>Order Number</th>
			<th>Shipping Company Name</th>
			<th>Ship Name</th>
			<th>Order Date</th>
		</tr>
		<c:forEach items="${orderList}" var="orderList">
			<tr>
				<td>${orderList.oid}</td>
				<td>${orderList.shippingCompany.name}</td>
				<td>${orderList.ship.name}</td>
				<td>${orderList.date}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/">Home</a>

</body>
</html>