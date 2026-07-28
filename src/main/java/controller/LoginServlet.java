package controller;

import dao.UserDAO;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateLogin(email, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("email", user.getEmail());
            session.setAttribute("name", user.getName());
            session.setMaxInactiveInterval(30 * 60);

            if ("on".equals(rememberMe)) {
                Cookie cookie = new Cookie("username", user.getEmail());
                cookie.setMaxAge(7 * 24 * 60 * 60);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }

            resp.sendRedirect("DashboardServlet");
        } else {
            req.setAttribute("error", "Invalid email or password.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
