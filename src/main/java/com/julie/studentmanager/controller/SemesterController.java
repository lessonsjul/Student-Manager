package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.repository.SemesterRepository;
import com.julie.studentmanager.validation.SemesterValidator;
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
import java.util.List;
import java.util.Set;

@Controller
public class SemesterController {

    private final SemesterValidator semesterValidator;
    private SemesterRepository semesterRepository;


    @Autowired
    public SemesterController(SemesterRepository semesterRepository, SemesterValidator semesterValidator) {
        this.semesterRepository = semesterRepository;
        this.semesterValidator = semesterValidator;
    }

    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public String  semesterList(@RequestParam(value = "idSem", required = false) Integer idSem, Model model) {
        Semester semester;
        List<Semester> semesterList = this.semesterRepository.getSemesterList();

        if(idSem == null){
            if(semesterList.size() != 0) {
                semester = this.semesterRepository.getSemesterByIdWithDiscipl(semesterList.get(0).getId());
            } else {semester = null;}
        }else {
           semester = this.semesterRepository.getSemesterByIdWithDiscipl(idSem);
        }

        String nedeli = "недель";
        if(semester != null){
            int dur = semester.getDuration();
            if(dur >= 5 && dur <= 20){
                nedeli = "недель";
            }else if(dur == 1 || dur % 10 == 1){
                nedeli = "неделя";
            } else if(dur % 10 >= 2 && dur % 10 <= 4 ){
                nedeli = "недели";
            }
        }


        model.addAttribute("nedeli",nedeli);
        model.addAttribute("semesters",semesterList);
        model.addAttribute("semester",semester);
        model.addAttribute("choiseSem",idSem);

        return "semester";
    }

    @RequestMapping(value = "/addSemester", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String addSemester(Model model){
        Set<Discipline> disciplineList = new HashSet<Discipline>(this.semesterRepository.getDisciplineList());

        model.addAttribute("semester", new Semester());
        model.addAttribute("disciplines", disciplineList);
        return "addSemester";
    }

    @RequestMapping(value = "/editSemester", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String editSemester(@RequestParam("idSem")Integer id, Model model){

        Semester semester = this.semesterRepository.getSemesterByIdWithDiscipl(id);
        List<Discipline> disciplineListBySemId = this.semesterRepository.getDisciplineListBySemId(id);
        Set<String> selected = new HashSet<String>();

        for(Discipline elem: disciplineListBySemId){
            selected.add(elem.getName());
        }
        Set<Discipline> disciplineList = new HashSet<Discipline>(this.semesterRepository.getDisciplineList());

        model.addAttribute("semester", semester);
        model.addAttribute("selected", selected);
        model.addAttribute("disciplines", disciplineList);
        return "addSemester";
    }

    @RequestMapping(value = "/addModifySemester", method = RequestMethod.POST)
    public String addSemester(@ModelAttribute("semester") Semester semester,
                              BindingResult bindingResult, Model model){
        this.semesterValidator.validate(semester,bindingResult);
        if(bindingResult.hasErrors()){
            if(null != semester.getId()){
                List<Discipline> disciplineListBySemId = this.semesterRepository.getDisciplineListBySemId(semester.getId());
                Set<String> selected = new HashSet<String>();

                for(Discipline elem: disciplineListBySemId){
                    selected.add(elem.getName());
                }
                model.addAttribute("selected",selected);
            }
            Set<Discipline> disciplineList = new HashSet<Discipline>(this.semesterRepository.getDisciplineList());
            model.addAttribute("disciplines",disciplineList);

            return "addSemester";
        }
        if(semester.getId() == null) {
            this.semesterRepository.setSemester(semester, semester.getDisciplineList());
        }else{
            this.semesterRepository.updateSemester(semester, semester.getId(), semester.getDisciplineList());
        }

        return "redirect:semesters";
    }

    @RequestMapping(value = "/deleteSemester", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String deleteStudent(@RequestParam("idSem") Integer idSem){

        if (null != idSem) this.semesterRepository.removeSemester(idSem);

        return "redirect:semesters";
    }
}
