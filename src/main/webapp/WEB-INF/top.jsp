<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Insert title here</title>
</head>

	<body>
		<div class="container">
			<div>
			<h1>Top Ten Songs</h1>
			<a href="/dashboard">Dashboard</a>
			</div>
			<div>
			<table>
				<thead>
					<tr>
						<th>Rating</th>
						<th>Title</th>
						<th>Artist</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${songs}" var="song">
						<tr>
							<td><c:out value="${song.rating}" /></td>
							<td><a href="/songs/${song.id }"> <c:out
										value="${song.title}" /></a></td>
							<td><c:out value="${song.artist}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
	
</html>