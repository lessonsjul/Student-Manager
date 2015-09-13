package com.julie.studentmanager.controller;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.domain.Progress;
import com.julie.studentmanager.domain.Semester;
import com.julie.studentmanager.domain.Student;
import com.julie.studentmanager.repository.DisciplineRepository;
import com.julie.studentmanager.repository.ProgressRepository;
import com.julie.studentmanager.repository.SemesterRepository;
import com.julie.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private StudentRepository studentRepository;
    private DisciplineRepository disciplineRepository;
    private static int STUDENTID;
    private static int SEMESTERID;

    @Autowired
    public ProgressController(ProgressRepository progressRepository,
                              SemesterRepository semesterRepository,
                              StudentRepository studentRepository,
                              DisciplineRepository disciplineRepository) {
        this.progressRepository = progressRepository;
        this.semesterRepository = semesterRepository;
        this.studentRepository = studentRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String  progressList(@RequestParam(value = "idStud", required = false)Integer idStud,
                                @RequestParam(value = "idSem", required = false)Integer idSem) {
        SEMESTERID = this.semesterRepository.getSemesterList().get(0).getId();
        if(null == idStud){
            idStud = STUDENTID;
        }
        if(null == idSem) idSem = SEMESTERID;
        return "redirect: progressList?idSem="+idSem+"&idStud="+idStud;
    }

    @RequestMapping(value = "/progressList")
    protected String  progressList(@RequestParam("idSem") Integer idSem, @RequestParam("idStud")Integer idStud, Model model) {
        STUDENTID = idStud;
        SEMESTERID = idSem;
        List<Object> result = this.progressRepository.getProgressListByStudIdAndSemId(idStud, idSem);
        Iterator itr = result.iterator();

        Map<Discipline, Integer> values = new HashMap<Discipline, Integer>();
        Student student = null;
        double avarage = 0;

        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            student = (Student) obj[1];
            if(null != obj[0]) {
                values.put((Discipline) obj[2], Integer.parseInt(String.valueOf(obj[0])));
                avarage = this.progressRepository.getAvarageValueOfProgress(idStud, idSem);
            }
        }
        List<Semester> semesterList = this.semesterRepository.getSemesterList();
        if(null == student)
            student = this.studentRepository.getStudentById(idStud);

        model.addAttribute("student", student);
        model.addAttribute("semesters", semesterList);
        model.addAttribute("choiseSem",idSem);
        model.addAttribute("avaragePoint", avarage);
        model.addAttribute("progress", values);
        return "progress";
    }

    @RequestMapping(value = "/addProgress", method = RequestMethod.GET)
    @PreAuthorize("hasRose('admin')")
    public String addProgress(Model model){
        List<Student> studentsList = this.studentRepository.getStudentList();
        List<Discipline> disciplineList = this.disciplineRepository.getDisciplineList();

            model.addAttribute("progress", new Progress());
            model.addAttribute("studentList", studentsList);
            model.addAttribute("disciplineList", disciplineList);
        return "addProgress";
    }

    @RequestMapping(value = "/setProgress", method = RequestMethod.POST)
    public String setProgress(@ModelAttribute("progress")Progress progress ){
        this.progressRepository.setProgress(progress);

        int idStud = progress.getStudent().getId();
        return "redirect: progress?idStud="+idStud;
    }
}
