<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Spring MVC Database</title>
</head>

<body>
	<h2>USERS sSTATUS</h2>

	<table border="1">
		<tr>
			<th>UserName</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.status}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>