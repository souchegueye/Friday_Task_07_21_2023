<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Details</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">

		<h1>Employee Details</h1>
		<p>
			Name:
			<%=request.getParameter("ename")%></p>
		<p>
			Date Of Birth:
			<%=request.getParameter("eDateOfBirth")%></p>
		<p>
			Contact No.:
			<%=request.getParameter("eContactNo")%></p>
		<p>
			Date Of Joining:
			<%=request.getParameter("eDateOfJoining")%></p>
		<p>
			Email Address:
			<%=request.getParameter("eEmailAddress")%></p>

		<%-- Add any additional data you want to display here --%>


	</div>
</body>
</html>
