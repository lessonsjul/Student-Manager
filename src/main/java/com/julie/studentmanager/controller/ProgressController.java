package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.ProgressRepository;
import com.julie.studentmanager.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class ProgressController {

    private ProgressRepository progressRepository;
    private SemesterRepository semesterRepository;

    @Autowired
    public ProgressController(ProgressRepository progressRepository,
                              SemesterRepository semesterRepository) {
        this.progressRepository = progressRepository;
        this.semesterRepository = semesterRepository;
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String  progressList(@RequestParam("idSem") Integer idSem, @RequestParam("idStud")Integer idStud, Model model) {

        List<Object> result = this.progressRepository.progressListByStudIdAndSemId(idStud,idSem);
        Iterator itr = result.iterator();

        Map<Discipline, Integer> values = new HashMap<Discipline, Integer>();
        Student student = null;

        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            Discipline discipline = (Discipline) obj[2];
            int value = Integer.parseInt(String.valueOf(obj[0]));
            values.put(discipline,value);
            Student st = (Student) obj[1];
            if(student == null){
                student = st;
            }
        }

        List<Semester> semesterList = this.semesterRepository.semesterList();

        double avarage = this.progressRepository.avarageValue(idStud, idSem);

        model.addAttribute("student", student);
        model.addAttribute("semesters", semesterList);
        model.addAttribute("choiseSem",idSem);
        model.addAttribute("avaragePoint", avarage);
        model.addAttribute("progress", values);
        return "progress";
    }

    @RequestMapping(value = "/progress", method = RequestMethod.POST)
    public String  progressList(@ModelAttribute("idSem")Integer id, @RequestParam("idStud")Integer idStud) {
        return "redirect: progress?idSem="+id+"&idStud="+idStud;
    }
}
