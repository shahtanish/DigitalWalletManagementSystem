package controller;

import dao.TransactionDAO;
import dao.UserDAO;
import dao.WalletDAO;
import util.Validation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String senderEmail = (String) session.getAttribute("email");
        String receiverEmail = req.getParameter("receiverEmail");
        String amountStr = req.getParameter("amount");

        UserDAO userDAO = new UserDAO();
        WalletDAO walletDAO = new WalletDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        if (!Validation.isValidEmail(receiverEmail) || !Validation.isValidAmount(amountStr)) {
            req.setAttribute("error", "Invalid receiver or amount.");
            req.getRequestDispatcher("sendMoney.jsp").forward(req, resp);
            return;
        }

        if (senderEmail.equalsIgnoreCase(receiverEmail)) {
            req.setAttribute("error", "Cannot send money to yourself.");
            req.getRequestDispatcher("sendMoney.jsp").forward(req, resp);
            return;
        }

        if (!userDAO.emailExists(receiverEmail)) {
            req.setAttribute("error", "Receiver not found.");
            req.getRequestDispatcher("sendMoney.jsp").forward(req, resp);
            return;
        }

        double amount = Double.parseDouble(amountStr);
        boolean success = walletDAO.transferMoney(senderEmail, receiverEmail, amount);

        if (success) {
            transactionDAO.addTransaction(senderEmail, receiverEmail, amount, "TRANSFER");
            resp.sendRedirect("DashboardServlet");
        } else {
            req.setAttribute("error", "Insufficient balance.");
            req.getRequestDispatcher("sendMoney.jsp").forward(req, resp);
        }
    }
}
