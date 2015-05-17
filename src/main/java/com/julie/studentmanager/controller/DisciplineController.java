package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DisciplineController {

    private DisciplineRepository disciplineRepository;

    @Autowired
    private DisciplineController(DisciplineRepository disciplineRepository){
        this.disciplineRepository = disciplineRepository;
    }

    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    public String getDisciplines(Model model){
        List<Discipline> disciplineList = this.disciplineRepository.disciplineList();

        model.addAttribute("disciplines", disciplineList);
        return "discipline";
    }

    @RequestMapping(value = "/addDiscipline", method = RequestMethod.GET)
    public String addDiscipline(Model model){

        model.addAttribute("discipline", new Discipline());
        model.addAttribute("nameButton", "Создать");
        model.addAttribute("infoText", "Для того чтобы создать дисциплину заполните все поля и нажмите кнопку");
        return "addDiscipline";
    }

    @RequestMapping(value = "/editDiscipline", method = RequestMethod.GET)
    public String editDisicpline(@RequestParam("idDiscipl")Integer id, Model model){
        Discipline discipline = this.disciplineRepository.disciplineById(id);

        model.addAttribute("discipline", discipline);
        model.addAttribute("nameButton", "Применить");
        model.addAttribute("infoText", "Для того чтобы модифицировать дисциплину, введите новое значение поля и нажмите кнопку");
        return "addDiscipline";
    }

    @RequestMapping(value = "/addModifyDiscipline", method = RequestMethod.POST)
    public String addDiscipline(@ModelAttribute("discipline") Discipline discipline){
        if(discipline.getId() == null) {
            this.disciplineRepository.addDiscipline(discipline);
        }else{
            this.disciplineRepository.editDiscipline(discipline);
        }
        return "redirect: disciplines";
    }

    @RequestMapping(value = "/deleteDiscipline", method = RequestMethod.GET)
    public String deleteDiscipline(@RequestParam("idDiscipl")Integer id){
        this.disciplineRepository.removeDiscipline(id);
        return "redirect:disciplines";
    }

}
