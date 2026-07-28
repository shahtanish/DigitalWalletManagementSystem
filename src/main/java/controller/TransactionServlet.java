package controller;

import dao.TransactionDAO;
import model.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("email");

        TransactionDAO transactionDAO = new TransactionDAO();
        List<Transaction> transactions = transactionDAO.getTransactionsByUser(email);

        req.setAttribute("transactions", transactions);
        req.setAttribute("currentUser", email);
        req.getRequestDispatcher("transactions.jsp").forward(req, resp);
    }
}
