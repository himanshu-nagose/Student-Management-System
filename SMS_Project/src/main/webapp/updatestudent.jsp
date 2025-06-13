<%@ page import="com.bo.Student"%>
<%
  Student s = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" href="updatestudent.css">
</head>
<body>

	<div class="form-container">
		<h2>Update Student</h2>
		<form action="UpdateStudentFinalController" method="post">
			<input type="hidden" name="originalName" value="<%= s.getName() %>" />

			<div class="form-group">
				<label>Name</label> <input type="text" name="name"
					value="<%= s.getName() %>" required />
			</div>

			<div class="form-group">
				<label>Age</label> <input type="text" name="age"
					value="<%= s.getAge() %>" required />
			</div>

			<div class="form-group">
				<label>Class</label> <input type="text" name="studentClass"
					value="<%= s.getStudentClass() %>" required />
			</div>

			<div class="form-group">
				<label>City</label> <input type="text" name="city"
					value="<%= s.getCity() %>" required />
			</div>

			<input type="submit" value="Update" class="submit-btn" /> <a
				href="ViewStudentController" class="back-btn">Back to Student
				Records</a>
		</form>
	</div>

</body>
</html>
