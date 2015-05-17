package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    private StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getStudents(Model model) {
        List<Student> studentList = this.studentRepository.studentList();

        model.addAttribute("students", studentList);
        return "student";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model) {

        model.addAttribute("student", new Student());
        model.addAttribute("nameButton", "Создать");
        model.addAttribute("infoText", "Для создания студента заполните все поля и нажмите кнопку");
        return "addStudent";
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public String editStudent(@RequestParam("idStud")Integer id, Model model){
        Student student = this.studentRepository.studentById(id);

        model.addAttribute("student", student);
        model.addAttribute("nameButton", "Применить");
        model.addAttribute("infoText", "Для модификации, введите новые значения и нажмите кнопку");
        return "addStudent";
    }

    @RequestMapping(value = "/addModifyStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student){
        if(student.getId() == null) {
            this.studentRepository.addStudent(student);
        }else{
            this.studentRepository.editStudent(student);
        }
        return "redirect: students";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("idStud")Integer id){
        this.studentRepository.removeStudent(id);
        return "redirect:students";
    }

}
