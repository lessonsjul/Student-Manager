package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getStudents(Model model){
        List<Student> studentList = this.studentRepository.studentList();

        model.addAttribute("students", studentList);
        return "student";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model){

        model.addAttribute("student", new Student());
        model.addAttribute("nameButton", new String("Создать"));
        model.addAttribute("infoText",new String("Для создания студента заполните все поля и нажмите кнопку"));
        return "addStudent";
    }

    @RequestMapping(value = "/modifyStudent/{id}",method = RequestMethod.GET)
    public String modifiyStudent(@PathVariable Integer id, Model model){

        Student student = this.studentRepository.studentById(id);
        model.addAttribute("student",student);
        model.addAttribute("nameButton", new String("Применить"));
        model.addAttribute("infoText",new String("Для модификации, введите новые значения и нажмите кнопку"));
        return "addStudent";
    }

}
