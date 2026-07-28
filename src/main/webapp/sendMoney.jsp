<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send Money</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>

<div class="container mt-5" style="max-width: 450px;">
    <h2 class="mb-4">Send Money</h2>

    <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
    <% } %>

    <form action="SendMoneyServlet" method="post">
        <div class="mb-3">
            <label>Receiver Email</label>
            <input type="email" class="form-control" name="receiverEmail" required>
        </div>
        <div class="mb-3">
            <label>Amount</label>
            <input type="number" step="0.01" min="1" class="form-control" name="amount" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Send</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
