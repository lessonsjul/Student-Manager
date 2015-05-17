package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Progress;
import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.ProgressRepository;
import com.julie.studentmanager.repository.SemesterRepository;
import com.julie.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProgressController {

    private ProgressRepository progressRepository;
    private SemesterRepository semesterRepository;
    private StudentRepository studentRepository;

    @Autowired
    public ProgressController(ProgressRepository progressRepository,
                              StudentRepository studentRepository,
                              SemesterRepository semesterRepository) {
        this.progressRepository = progressRepository;
        this.studentRepository = studentRepository;
        this.semesterRepository = semesterRepository;
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String  progressList(@RequestParam("idSem") Integer idSem, @RequestParam("idStud")Integer idStud, Model model) {

        List<Progress> progressList = this.progressRepository.progressList(idStud, idSem);
        Map<String, Integer> values = new HashMap<String, Integer>();
        double sum = 0;
        for(Progress elem: progressList){
            String discipline = elem.getDiscipline().getName();
            int value = elem.getValue();
            values.put(discipline,value);
            sum += value;
        }
        double avarage = sum / progressList.size();

        Student student = this.studentRepository.studentById(idStud);
        List<Semester> semesterList = this.semesterRepository.semesterList();

        model.addAttribute("disValues", values);
        model.addAttribute("student", student);
        model.addAttribute("semesters",semesterList);
        model.addAttribute("choiseSem",idSem);
        model.addAttribute("avaragePoint", avarage);
        return "progress";
    }

    @RequestMapping(value = "/progress", method = RequestMethod.POST)
    public String  progressList(@ModelAttribute("idSem")Integer id, @RequestParam("idStud")Integer idStud) {
        return "redirect: progress?idSem="+id+"&idStud="+idStud;
    }
}
