package com.healthcare.controllers;

import com.healthcare.models.User;
import com.healthcare.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);  // Forward to the login page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.authenticateUser(email, password);  // Authenticate user with UserService

        if (user != null) {
            // If the user is authenticated, create a session and redirect to the dashboard
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("dashboard.jsp");  // Redirect to the user dashboard
        } else {
            // If authentication fails, redirect back to login page with error message
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
