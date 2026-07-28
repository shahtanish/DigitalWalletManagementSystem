<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container text-center mt-5">
    <h1 class="text-danger">Something went wrong</h1>
    <p><%= exception != null ? exception.getMessage() : "Unknown error" %></p>
    <a href="index.jsp" class="btn btn-primary">Go Home</a>
</div>
</body>
</html>
