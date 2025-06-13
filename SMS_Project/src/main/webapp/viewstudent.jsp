<%@ page import="java.util.List"%>
<%@ page import="com.bo.Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>View Students</title>
<link rel="stylesheet" href="viewstudent.css" />
</head>
<body>
	<div class="container">

		<div class="header">
			<h2>Student Records</h2>
			<a href="dashboard.html" class="back-link">Back to Dashboard</a>
		</div>

		<div class="search-bar">
			<input type="text" id="searchInput"
				placeholder="Search by name or department....." onkeyup="filterTable()" />
		</div>

		<table id="studentTable">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Department</th>
					<th>College City</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
  List<Student> list = (List<Student>) request.getAttribute("students");
  if (list != null) {
    for (Student s : list) {
%>
				<tr>
					<td><%= s.getName() %></td>
					<td><%= s.getAge() %></td>
					<td><%= s.getStudentClass() %></td>
					<td><%= s.getCity() %></td>
					<td>
						<form action="UpdateStudentController" method="get"
							style="display: inline;">
							<input type="hidden" name="name" value="<%= s.getName() %>" />
							<button type="submit" class="edit-btn">Edit</button>
						</form>
						<form action="DeleteStudentController" method="post"
							style="display: inline;"
							onsubmit="return confirm('Delete this student?');">
							<input type="hidden" name="name" value="<%= s.getName() %>" />
							<button type="submit" class="delete-btn">Delete</button>
						</form>
					</td>
				</tr>
				<%
    }
  } else {
%>
				<tr>
					<td colspan="5" style="text-align: center; color: red;">No
						student data found.</td>
				</tr>
				<%
  }
%>

			</tbody>
		</table>
	</div>

	<script>
    function filterTable() {
      const input = document.getElementById("searchInput").value.toLowerCase();
      const rows = document.querySelectorAll("#studentTable tbody tr");

      rows.forEach(row => {
        const name = row.cells[0].textContent.toLowerCase();
        const studentClass = row.cells[2].textContent.toLowerCase();
        row.style.display = name.includes(input) || studentClass.includes(input) ? "" : "none";
      });
    }
  </script>
</body>
</html>
