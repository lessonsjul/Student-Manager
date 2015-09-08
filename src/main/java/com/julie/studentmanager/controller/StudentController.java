package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.SemesterRepository;
import com.julie.studentmanager.repository.StudentRepository;
import com.julie.studentmanager.validation.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    private StudentRepository studentRepository;
    private SemesterRepository semesterRepository;
    private StudentValidator studentValidator;

    @Autowired
    private StudentController(StudentRepository studentRepository, SemesterRepository semesterRepository, StudentValidator studentValidator) {
        this.studentRepository = studentRepository;
        this.semesterRepository = semesterRepository;
        this.studentValidator = studentValidator;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getStudents(Model model) {
        List<Student> studentList = this.studentRepository.studentList();
        if(0 != this.semesterRepository.semesterList().size()){
            int idSem = this.semesterRepository.semesterList().get(0).getId();
            model.addAttribute("idSem", idSem);
        }

        model.addAttribute("students", studentList);
        return "student";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String editStudent(@RequestParam("idStud")Integer id, Model model){
        Student student = this.studentRepository.studentById(id);

        model.addAttribute("student", student);
        return "addStudent";
    }

    @RequestMapping(value = "/addModifyStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student,BindingResult bindingResult){
        this.studentValidator.validate(student, bindingResult);
        if(bindingResult.hasErrors())
            return "addStudent";

        if(student.getId() == null) {
            this.studentRepository.addStudent(student);
        }else{
            this.studentRepository.editStudent(student);
        }
        return "redirect: students";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String deleteStudent(@RequestParam("idStud")Integer id){
        this.studentRepository.removeStudent(id);
        return "redirect:students";
    }

}
