package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.repository.DisciplineRepository;
import com.julie.studentmanager.validation.DisciplineValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class DisciplineController {

    private DisciplineRepository disciplineRepository;
    private DisciplineValidator disciplineValidator;


    @Autowired
    private DisciplineController(DisciplineRepository disciplineRepository, DisciplineValidator disciplineValidator){
        this.disciplineRepository = disciplineRepository;
        this.disciplineValidator= disciplineValidator;
    }

    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    public String getDisciplines(Model model){
        Set<Discipline> disciplineList = new HashSet<Discipline>(this.disciplineRepository.disciplineList());

        model.addAttribute("disciplines", disciplineList);
        return "discipline";
    }

    @RequestMapping(value = "/addDiscipline", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String addDiscipline(Model model){

        model.addAttribute("discipline", new Discipline());
        return "addDiscipline";
    }

    @RequestMapping(value = "/editDiscipline", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String editDisicpline(@RequestParam("idDiscipl")Integer id, Model model){
        Discipline discipline = this.disciplineRepository.disciplineById(id);

        model.addAttribute("discipline", discipline);
        return "addDiscipline";
    }

    @RequestMapping(value = "/addModifyDiscipline", method = RequestMethod.POST)
    public String addDiscipline(@ModelAttribute("discipline") Discipline discipline, BindingResult bindingResult){
        this.disciplineValidator.validate(discipline,bindingResult);
        if(bindingResult.hasErrors())
            return "addDiscipline";

        if(discipline.getId() == null) {
            this.disciplineRepository.addDiscipline(discipline);
        }else{
            this.disciplineRepository.editDiscipline(discipline);
        }
        return "redirect: disciplines";
    }

    @RequestMapping(value = "/deleteDiscipline", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String deleteDiscipline(@RequestParam("idDiscipl")Integer id){
        this.disciplineRepository.removeDiscipline(id);
        return "redirect:disciplines";
    }


}
