<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>

<div class="container mt-5" style="max-width: 450px;">
    <h2 class="mb-4">Edit Profile</h2>

    <form action="UpdateProfileServlet" method="post">
        <div class="mb-3">
            <label>Name</label>
            <input type="text" class="form-control" name="name" value="${sessionScope.name}" required>
        </div>
        <div class="mb-3">
            <label>Mobile</label>
            <input type="text" class="form-control" name="mobile" required>
        </div>
        <div class="mb-3">
            <label>New Password</label>
            <input type="password" class="form-control" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Update</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
