package com.mdekhtiarenko.universitysignin.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", "John Snow");
        return mv;
    }
}


