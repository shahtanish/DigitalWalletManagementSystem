<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Transaction History</h2>

    <table class="table table-bordered bg-white">
        <thead>
        <tr>
            <th>Date</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Amount</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${transactions}">
            <tr>
                <td>${t.date}</td>
                <td>${t.senderEmail != null ? t.senderEmail : '-'}</td>
                <td>${t.receiverEmail != null ? t.receiverEmail : '-'}</td>
                <td>
                    <c:choose>
                        <c:when test="${t.senderEmail == currentUser}">
                            <span class="text-danger">-${t.amount}</span>
                        </c:when>
                        <c:otherwise>
                            <span class="text-success">+${t.amount}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${t.type}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
