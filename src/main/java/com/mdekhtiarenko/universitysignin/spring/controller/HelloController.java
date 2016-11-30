package com.mdekhtiarenko.universitysignin.spring.controller;

import com.mdekhtiarenko.universitysignin.POJOs.POJODiscipline;
import com.mdekhtiarenko.universitysignin.POJOs.POJOUser;
import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.Discipline;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Controller
public class HelloController {
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", "John Snow");
        return mv;
    }
}


