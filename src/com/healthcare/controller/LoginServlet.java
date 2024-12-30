package com.healthcare.controllers;

import com.healthcare.models.User;
import com.healthcare.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService(); // Access the business logic

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to login page (login.jsp)
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate login credentials using UserService
        User user = userService.authenticateUser(username, password);

        if (user != null) {
            // If login successful, redirect to the dashboard
            response.sendRedirect("/dashboard");
        } else {
            // If login fails, forward to login page with error message
            request.setAttribute("error", "Invalid credentials, please try again.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
