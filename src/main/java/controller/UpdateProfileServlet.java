package controller;

import dao.UserDAO;
import util.Validation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("email");

        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");

        if (!Validation.isNotEmpty(name) || !Validation.isValidMobile(mobile) || !Validation.isNotEmpty(password)) {
            resp.sendRedirect("ProfileServlet?error=invalid");
            return;
        }

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.updateProfile(email, name, mobile, password);

        if (success) {
            session.setAttribute("name", name);
        }

        resp.sendRedirect("ProfileServlet");
    }
}
