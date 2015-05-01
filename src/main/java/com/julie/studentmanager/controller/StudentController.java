package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    private StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents(Model model){
        List<Student> studentList = this.studentRepository.studentList();

        model.addAttribute("students", studentList);
        return "index";
    }

}
