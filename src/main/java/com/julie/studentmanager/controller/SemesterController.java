package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.repository.DisciplineRepository;
import com.julie.studentmanager.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SemesterController {
    
    private SemesterRepository semesterRepository;
    private DisciplineRepository disciplineRepository;


    @Autowired
    public SemesterController(SemesterRepository semesterRepository, DisciplineRepository disciplineRepository) {
        this.semesterRepository = semesterRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public String  semesterList(@RequestParam("idSem") Integer idSem, Model model) {

        List<Semester> semesterList = this.semesterRepository.semesterList();

        model.addAttribute("semesters",semesterList);
        model.addAttribute("choiseSem",idSem);

        return "semester";
    }

    @RequestMapping(value = "/semesters", method = RequestMethod.POST)
    public String  semesterList(@ModelAttribute("idSem")Integer id) {
        return "redirect: semesters?idSem="+id;
    }

    @RequestMapping(value = "/addSemester", method = RequestMethod.GET)
    public String addSemester(@RequestParam("idSem")Integer id,Model model){

        List<Discipline> disciplineList = this.disciplineRepository.disciplineList();

        model.addAttribute("semester", new Semester());
        model.addAttribute("disciplines", disciplineList);
        model.addAttribute("nameButton", "Создать");
        model.addAttribute("infoText", "Для создания семестра заполните следующие данные и нажмите кнопку");
        return "addSemester";
    }

    @RequestMapping(value = "/editSemester", method = RequestMethod.GET)
    public String editSemester(@RequestParam("idSem")Integer id, Model model){
        Semester semester = this.semesterRepository.semesterById(id);
        List<Discipline> disciplineList = this.disciplineRepository.disciplineList();

        Set<Discipline> choiseDiscipl = new HashSet<Discipline>();

        for(Discipline elem: disciplineList){
            if(semester.getDisciplineList().contains(elem)){
                choiseDiscipl.add(elem);
                disciplineList.remove(elem);
            }
        }

        model.addAttribute("semester", semester);
        model.addAttribute("choiseDiscipl", choiseDiscipl);
        model.addAttribute("disciplines", disciplineList);
        model.addAttribute("nameButton", "Применить");
        model.addAttribute("infoText", "Для модификации семестра отредактируйте данные и нажмите кнопку");
        return "addSemester";
    }

    @RequestMapping(value = "/addModifySemester", method = RequestMethod.POST)
    public String addSemester(@ModelAttribute("semester") Semester semester){
        if(semester.getId() == null) {
            this.semesterRepository.addSemester(semester);
        }else{
            this.semesterRepository.editSemester(semester);
        }
        return "redirect: semesters";
    }
}
