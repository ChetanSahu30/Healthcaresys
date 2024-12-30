package com.healthcare.controllers;

import com.healthcare.models.User;
import com.healthcare.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);  // Forward to registration page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Create a new user object
        User newUser = new User(name, email, password);

        // Register the user using the UserService
        userService.registerUser(newUser);

        // Redirect to login page after successful registration
        response.sendRedirect("login.jsp");
    }
}
