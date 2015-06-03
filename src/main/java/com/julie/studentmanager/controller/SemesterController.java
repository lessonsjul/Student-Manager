package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.domain.Semester;
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


    @Autowired
    public SemesterController(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public String  semesterList(@RequestParam(value = "idSem", required = false) Integer idSem, Model model) {
        List<Semester> semesterList = this.semesterRepository.semesterList();
        Semester semester = null;
        if(null !=idSem) {
           semester = this.semesterRepository.getSemesterByIdWithDiscipl(idSem);
        }else {
            semester = this.semesterRepository.getSemesterByIdWithDiscipl(semesterList.get(0).getId());
        }

        model.addAttribute("semesters",semesterList);
        model.addAttribute("semester",semester);
        model.addAttribute("choiseSem",idSem);
        model.addAttribute("addButton", "Создать семестр...");
        model.addAttribute("modifButton", "Модифицировать выбранный семестр...");
        model.addAttribute("deleteButton", "Удалить выбранный семестр");

        return "semester";
    }

    @RequestMapping(value = "/addSemester", method = RequestMethod.GET)
    public String addSemester(Model model){
        Set<Discipline> disciplineList = new HashSet<Discipline>(this.semesterRepository.getDisciplineList());

        model.addAttribute("semester", new Semester());
        model.addAttribute("disciplines", disciplineList);
        model.addAttribute("nameButton", "Создать");
        model.addAttribute("infoText", "Для создания семестра заполните следующие данные и нажмите кнопку");
        return "addSemester";
    }

    @RequestMapping(value = "/editSemester", method = RequestMethod.GET)
    public String editSemester(@RequestParam("idSem")Integer id, Model model){
        Semester semester = this.semesterRepository.getSemesterById(id);
        List<Discipline> disciplineListBySemId = this.semesterRepository.getDisciplineListBySemId(id);
        Set<String> selected = new HashSet<String>();

        for(Discipline elem: disciplineListBySemId){
            selected.add(elem.getName());
        }
        Set<Discipline> disciplineList = new HashSet<Discipline>(this.semesterRepository.getDisciplineList());

        model.addAttribute("semester", semester);
        model.addAttribute("selected", selected);
        model.addAttribute("disciplines", disciplineList);
        model.addAttribute("nameButton", "Применить");
        model.addAttribute("infoText", "Для модификации семестра отредактируйте данные и нажмите кнопку");
        return "addSemester";
    }

    @RequestMapping(value = "/addModifySemester", method = RequestMethod.POST)
    public String addSemester(@ModelAttribute("semester") Semester semester,
                              @RequestParam("id") Integer idSem,
                              @RequestParam("disciplineList")List<Discipline> disciplines){
        if(semester.getId() == null) {
            this.semesterRepository.addSemester(semester,disciplines);
        }else{
            this.semesterRepository.editSemester(semester,idSem,disciplines);
        }

        return "redirect:semesters";
    }

    @RequestMapping(value = "/deleteSemester", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("idSem") Integer idSem){

        if (null != idSem) this.semesterRepository.removeSemester(idSem);

        return "redirect:semesters";
    }
}
