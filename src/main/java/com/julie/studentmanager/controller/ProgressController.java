package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Progress;
import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.ProgressRepository;
import com.julie.studentmanager.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProgressController {

    private ProgressRepository progressRepository;
    private SemesterRepository semesterRepository;

    @Autowired
    public ProgressController(ProgressRepository progressRepository, SemesterRepository semesterRepository) {
        this.progressRepository = progressRepository;
        this.semesterRepository = semesterRepository;
    }

    @RequestMapping(value = "/progress/{idSem}/{idStud}", method = RequestMethod.GET)
    public String  progressList(@PathVariable Integer idStud, @PathVariable Integer idSem,Model model) {

        List<Progress> progressList = this.progressRepository.progressList(idStud, idSem);
        Student student = progressList.get(0).getStudent();
        Semester semester = this.semesterRepository.semesterById(idSem);
        List<Semester> semesterList = this.semesterRepository.semesterList();
        double sum = 0;
        for(Progress elem: progressList){
            sum += elem.getValue();
        }
        double avarage = sum / progressList.size();
        model.addAttribute("progresses", progressList);
        model.addAttribute("student", student);
        model.addAttribute("semester", semester);
        model.addAttribute("semesters", semesterList);
        model.addAttribute("avaragePoint", avarage);
        return "progress";
    }
}
