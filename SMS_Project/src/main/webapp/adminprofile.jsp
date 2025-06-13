<%@ page import="com.bo.Admin" %>
<%@ page session="true" %>
<%
    Admin admin = (Admin) session.getAttribute("adminDetails");
    if (admin == null) {
        response.sendRedirect("adminlogin.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Profile</title>
    <link rel="stylesheet" type="text/css" href="adminprofile.css">
</head>
<body>
    <div class="profile-container">
        <h2>Admin Profile Details</h2>
        <table class="profile-table">
            <tr>
                <td class="label">Passkey:</td>
                <td class="value"><%= admin.getAdminPasskey() %></td>
            </tr>
            <tr>
                <td class="label">Name:</td>
                <td class="value"><%= admin.getAdminName() %></td>
            </tr>
            <tr>
                <td class="label">Email:</td>
                <td class="value"><%= admin.getAdminEmail() %></td>
            </tr>
            <tr>
                <td class="label">Username:</td>
                <td class="value"><%= admin.getAdminUsername() %></td>
            </tr>
        </table>
        <a href="dashboard.html" class="back-button">Back to Dashboard</a>
    </div>
</body>
</html>
