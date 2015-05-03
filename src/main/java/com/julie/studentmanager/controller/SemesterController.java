package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SemesterController {
    
    private SemesterRepository semesterRepository;

    @Autowired
    private SemesterController(SemesterRepository semesterRepository){
        this.semesterRepository = semesterRepository;
    }

    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public String getSemesters(){
        List<Semester> semesterList = this.semesterRepository.semesterList();
        return "semester";
    }

}
