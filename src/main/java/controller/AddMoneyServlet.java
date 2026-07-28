package controller;

import dao.TransactionDAO;
import dao.WalletDAO;
import util.Validation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/AddMoneyServlet")
public class AddMoneyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("email");
        String amountStr = req.getParameter("amount");

        if (!Validation.isValidAmount(amountStr)) {
            resp.sendRedirect("DashboardServlet?error=invalidAmount");
            return;
        }

        double amount = Double.parseDouble(amountStr);
        WalletDAO walletDAO = new WalletDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        boolean success = walletDAO.addMoney(email, amount);
        if (success) {
            transactionDAO.addTransaction(null, email, amount, "CREDIT");
        }

        resp.sendRedirect("DashboardServlet");
    }
}
