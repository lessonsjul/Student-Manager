package com.julie.studentmanager.controller;

import com.julie.studentmanager.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SemesterController {
    
    private SemesterRepository semesterRepository;

    @Autowired
    private SemesterController(SemesterRepository semesterRepository){
        this.semesterRepository = semesterRepository;
    }

}
