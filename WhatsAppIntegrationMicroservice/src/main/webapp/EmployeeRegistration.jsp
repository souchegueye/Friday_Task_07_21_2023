<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" />

<style>
body {
	background-color: #f8f9fa;
	padding-top: 40px;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	background-color: #fff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	padding: 30px;
	border-radius: 8px;
	text-align: center;
}

/* Apply general styles to both outer and inner form groups */
.form-group {
	margin-bottom: 15px;
}

/* Style the outer form group (optional) */
.outer-form-group {
	background-color: #f0f0f0;
	padding: 10px;
}

/* Style the inner form group */
.inner-form-group {
	display: flex;
	align-items: center;
}
/* Style the form label (optional) */
.form-label {
	flex: 0 0 120px; /* Set a fixed width for the label */
	padding-right: 10px;
	/* Add some spacing between the label and the input field */
	white-space: nowrap;
	/* Prevent the label text from wrapping to a new line */
	overflow: hidden; /* Hide any overflow of the label text */
	text-overflow: ellipsis;
	/* Show an ellipsis (...) for long label text that overflows */
}

/* Style the form control (input field) */
.form-control {
	flex: 1; /* Make the input field expand to fill the remaining space */
	padding: 5px;
	font-size: 16px;
}

.btn-primary {
	flex: 0 0 100px; /* Set a fixed width for the button */
	padding: 10px;
	margin-right: 10px;
	/* Add some spacing between the button and the input field */
}

.inline-heading {
	font-size: 5px display: inline;
	/* Set the display property to inline to make the heading inline */
}
</style>



</head>
<body>
	<div class="container">
		<h1 class="inline-heading">Employment Registration Form</h1>

		<form method="post" action="EmployeeRegistrationServlet">

			<div class="outer-form-group">
				<div class="inner-form-group">
					<label for="name" class="form-label">Name</label> <input
						type="text" class="form-control" id="name" name="name">
				</div>
			</div>

			<div class="outer-form-group">
				<div class="inner-form-group">
					<label for="dateOfBirth" class="form-label">Date Of Birth</label> <input
						type="date" class="form-control" id="dateOfBirth"
						name="dateOfBirth">
				</div>
			</div>

			<div class="outer-form-group">
				<div class="inner-form-group">
					<label for="contactNo" class="form-label">Contact No.</label> <input
						type="tel" class="form-control" id="contactNo" name="contactNo">
				</div>
			</div>

			<div class="outer-form-group">
				<div class="inner-form-group">
					<label for="dateOfJoining" class="form-label">Date Of
						Joining</label> <input type="date" class="form-control" id="dateOfJoining"
						name="dateOfJoining">
				</div>
			</div>


			<div class="outer-form-group">
				<div class="inner-form-group">
					<label for="emailAddress" class="form-label">Email Address</label>
					<input type="email" class="form-control" id="emailAddress"
						name="emailAddress">
				</div>
			</div>

			<div style="display: flex">
				<button type="submit" class="btn btn-primary">Save</button>

			</div>
		</form>
	</div>

</body>
</html>