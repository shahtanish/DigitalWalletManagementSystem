package controller;

import dao.UserDAO;
import model.User;
import util.Validation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");

        UserDAO userDAO = new UserDAO();

        if (!Validation.isNotEmpty(name) || !Validation.isValidEmail(email)
                || !Validation.isNotEmpty(password) || !Validation.isValidMobile(mobile)) {
            req.setAttribute("error", "Invalid input. Please check all fields.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        if (userDAO.emailExists(email)) {
            req.setAttribute("error", "Email already registered.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        User user = new User(name, email, password, mobile);
        boolean success = userDAO.registerUser(user);

        if (success) {
            resp.sendRedirect("login.jsp?registered=true");
        } else {
            req.setAttribute("error", "Registration failed. Try again.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
