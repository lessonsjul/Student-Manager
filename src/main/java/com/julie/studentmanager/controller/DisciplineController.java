package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DisciplineController {

    private DisciplineRepository disciplineRepository;

    @Autowired
    private DisciplineController(DisciplineRepository disciplineRepository){
        this.disciplineRepository = disciplineRepository;
    }

    @RequestMapping(value = "/getDisciplines", method = RequestMethod.GET)
    public String getDisciplines(Model model){
        List<Discipline> disciplineList = this.disciplineRepository.disciplineList();

        model.addAttribute("disciplines", disciplineList);
        return "discipline";
    }
}
