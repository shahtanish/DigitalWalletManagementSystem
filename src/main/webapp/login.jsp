<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5" style="max-width: 400px;">
    <h2 class="mb-4">Login</h2>

    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
    <% } %>
    <% if ("true".equals(request.getParameter("registered"))) { %>
    <div class="alert alert-success">Registration successful. Please login.</div>
    <% } %>

    <form action="LoginServlet" method="post">
        <%
            String savedEmail = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("username".equals(c.getName())) {
                        savedEmail = c.getValue();
                        break;
                    }
                }
            }
        %>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" class="form-control" name="email" \value="<%= savedEmail %>" required>
        </div>
        <div class="mb-3">
            <label>Password</label>
            <input type="password" class="form-control" name="password" required>
        </div>
        <div class="form-check mb-3">
        <input type="checkbox" class="form-check-input" name="rememberMe" id="rememberMeCheck">
        <label class="form-check-label" for="rememberMeCheck">Remember Me</label>
    </div>

        <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>
    <p class="mt-3">New user? <a href="register.jsp">Register</a></p>
</div>
</body>
</html>
