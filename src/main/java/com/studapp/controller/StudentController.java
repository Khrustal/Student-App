package com.studapp.controller;

import com.studapp.model.Student;
import com.studapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/student")
    public String get(@RequestParam(required = false) Long id, Model model) {
        if(id == null) {
            List<Student> students = service.getAll();
            model.addAttribute("student", students);
        }
        else {
            Optional<Student> student = service.get(id);
            student.ifPresent(value -> model.addAttribute("student", value));
        }
        return "student";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student, Model model) {
        service.create(student);
        model.addAttribute("student", student);
        return "student";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        if(service.exists(id)) {
            service.delete(id);
        }
        return "home";
    }
}
