package com.julie.studentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @RequestMapping(value = "/action", method = RequestMethod.GET)
    public String formAction( @RequestParam("buttonName") String param, @RequestParam("idStud") Integer id){

        return "redirect:"+param+"/"+id;

    }
}
