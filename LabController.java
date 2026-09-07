package com.valencia.lab.signin.controller;

import com.valencia.lab.signin.model.Student;
import com.valencia.lab.signin.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class LabController {

    @Autowired
    private StudentRepository studentRepository;

    // Course list that will be shown in the drop down menu
    private final List<String> courseOptions = Arrays.asList("CEN4333C", "CIS3080", "ACG3024", "COP 2805C");

    // Sign in form screen
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courseList", courseOptions); // This loads the courses into the drop down menu
        return "index";
    }

    // form submission
    @PostMapping("/signin")
    public String submitForm(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Reload so I don't get an error, because I kept getting a blanklist sometimes
            model.addAttribute("courseList", courseOptions);
            return "index";
        }

        // Saves the student to the H2 database
        studentRepository.save(student);
        return "success";
    }
}