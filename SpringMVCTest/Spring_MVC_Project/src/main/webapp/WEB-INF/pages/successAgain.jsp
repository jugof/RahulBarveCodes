<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<body>
		<%
			String loggedInUserName = (String)session.getAttribute("validUserName");
		%>
		<h1 style="background-color: green;color:white">
			Congratulations!! <%= loggedInUserName%>, You are IN
		</h1>
	</body>
</html>