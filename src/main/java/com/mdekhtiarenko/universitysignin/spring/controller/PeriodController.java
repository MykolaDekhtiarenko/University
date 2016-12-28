package com.mdekhtiarenko.universitysignin.spring.controller;

import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.PeriodDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.Period;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mykola.dekhtiarenko on 13.12.16.
 */
@Controller
public class PeriodController {

    @RequestMapping(value="/period/preparatory", method= RequestMethod.GET)
    public ModelAndView setPreparatory() {
        PeriodDAOImpl pdi = new PeriodDAOImpl();
        pdi.setPeriod(Period.PREPARATORY);
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;
    }

    @RequestMapping(value="/period/signin", method= RequestMethod.GET)
    public ModelAndView setSignIn() {
        PeriodDAOImpl pdi = new PeriodDAOImpl();
        pdi.setPeriod(Period.SIGN_IN);
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;
    }

    @RequestMapping(value="/period/finale", method= RequestMethod.GET)
    public ModelAndView setFinal() {
        PeriodDAOImpl pdi = new PeriodDAOImpl();
        pdi.setPeriod(Period.FINALE);
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;
    }
}
