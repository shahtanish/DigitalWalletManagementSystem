package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI();
        boolean isPublic = uri.contains("login.jsp") || uri.contains("register.jsp")
                || uri.contains("LoginServlet") || uri.contains("RegisterServlet")
                || uri.contains("index.jsp") || uri.endsWith("/")
                || uri.contains(".css") || uri.contains(".js");

        boolean loggedIn = (session != null && session.getAttribute("email") != null);

        if (loggedIn || isPublic) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
