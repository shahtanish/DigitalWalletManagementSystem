<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>

<div class="container mt-5" style="max-width: 500px;">
    <h2 class="mb-4">My Profile</h2>

    <table class="table table-bordered bg-white">
        <tr><th>Name</th><td>${user.name}</td></tr>
        <tr><th>Email</th><td>${user.email}</td></tr>
        <tr><th>Mobile</th><td>${user.mobile}</td></tr>
        <tr><th>Wallet Balance</th><td>&#8377; ${user.walletBalance}</td></tr>
    </table>

    <a href="editProfile.jsp" class="btn btn-primary">Edit Profile</a>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
