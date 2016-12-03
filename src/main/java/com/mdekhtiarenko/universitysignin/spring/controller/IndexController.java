package com.mdekhtiarenko.universitysignin.spring.controller;

import com.mdekhtiarenko.universitysignin.spring.delegate.IndexDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


@Controller
public class IndexController {
    @Autowired
    private IndexDelegate indexDelegate;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView listDisciplines() throws SQLException {
        ModelAndView mv = new ModelAndView("index");
        
        IndexDelegate indexDelegate = new IndexDelegate();
        mv.addObject("list", indexDelegate.getAllDiscipline());
        return mv;
    }
}


