package com.healthcare.controllers;

import com.healthcare.models.Doctor;
import com.healthcare.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Handler to display the form to add a new doctor
    @GetMapping("/addDoctor")
    public String showDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());  // Create an empty Doctor object for the form
        return "doctorForm";  // Return the JSP page where the form is present
    }

    // Handler to process the doctor registration
    @PostMapping("/addDoctor")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.addDoctor(doctor);  // Call the service to add the doctor
        return "redirect:/viewDoctors";  // Redirect to the viewDoctors page after adding
    }

    // Handler to view all doctors
    @GetMapping("/viewDoctors")
    public String viewDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());  // Add list of doctors to the model
        return "viewDoctors";  // Return the JSP page to display all doctors
    }
}
