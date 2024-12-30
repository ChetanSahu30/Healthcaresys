package com.healthcare.controllers;

import com.healthcare.models.User;
import com.healthcare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Added import for Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Empty user object for the form
        return "registrationForm";  // Return the JSP page for registration form
    }

    // Handle user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);  // Call service to save user data
        return "redirect:/login";  // Redirect to login page after registration
    }
}