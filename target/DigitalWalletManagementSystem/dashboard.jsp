<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>

<div class="container mt-5">
    <h2>Welcome, ${sessionScope.name}</h2>

    <div class="card p-4 my-4 text-center">
        <h4>Current Balance</h4>
        <h1 class="text-success">&#8377; ${balance}</h1>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <div class="card p-3">
                <h5>Add Money</h5>
                <form action="AddMoneyServlet" method="post">
                    <input type="number" step="0.01" min="1" class="form-control mb-2" name="amount" placeholder="Amount" required>
                    <button type="submit" class="btn btn-success w-100">Add</button>
                </form>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card p-3">
                <h5>Send Money</h5>
                <a href="sendMoney.jsp" class="btn btn-primary w-100">Send Money</a>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card p-3">
                <h5>Transactions</h5>
                <a href="TransactionServlet" class="btn btn-secondary w-100">View History</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
