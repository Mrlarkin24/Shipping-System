<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 50%;
}

th, td {
	text-align: left;
	padding: 8px;
}

th {
	background-color: #004cff;
	color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Shipping Companies</title>
</head>
<body>

	<h1>Shipping Companies</h1>

	<table>
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>Ships</th>
		</tr>
		<c:forEach items="${shippingCompaniesList}"
			var="shippingCompaniesList">
			<tr>
				<td>${shippingCompaniesList.name}</td>
				<td>${shippingCompaniesList.homePort}</td>
				<td>${shippingCompaniesList.balance}</td>
				<td>${shippingCompaniesList.scid}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/">Home</a>

</body>
</html>