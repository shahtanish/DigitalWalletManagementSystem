package controller;

import dao.WalletDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("email");

        WalletDAO walletDAO = new WalletDAO();
        double balance = walletDAO.getBalance(email);

        req.setAttribute("balance", balance);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}
