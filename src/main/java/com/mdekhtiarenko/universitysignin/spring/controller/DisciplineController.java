package com.mdekhtiarenko.universitysignin.spring.controller;

import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.Discipline_has_UserDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.Discipline;
import com.mdekhtiarenko.universitysignin.spring.delegate.IndexDelegate;
import com.mdekhtiarenko.universitysignin.spring.viewBean.DisciplineForm;
import com.mdekhtiarenko.universitysignin.spring.viewBean.SignInBean;
import com.mdekhtiarenko.universitysignin.spring.viewBean.XML;
import com.mdekhtiarenko.universitysignin.xml.XMLParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 * Created by mykola.dekhtiarenko on 12.12.16.
 */
@Controller
public class DisciplineController {

    @ModelAttribute("DisciplineForm")
    public DisciplineForm getDisciplineForm() {
        return new DisciplineForm();
    }

    @RequestMapping(value="/discipline/delete/{id}", method= RequestMethod.GET)
    public ModelAndView deleteDiscipline(@PathVariable Integer id) {
        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        ddi.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;
    }

    @RequestMapping(value="/discipline/edit/{id}", method= RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public ModelAndView editDiscipline(@PathVariable Integer id) throws SQLException {
        ModelAndView mv = new ModelAndView("edit");
        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        Discipline d = ddi.getDiscipline(id);
        mv.addObject("discipline", d);
        return mv;
    }

    @RequestMapping(value="/discipline/edit/{id}", method= RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ModelAndView saveDiscipline(@PathVariable Integer id, @ModelAttribute("DisciplineForm")DisciplineForm form) throws SQLException {
        ModelAndView mv = new ModelAndView("redirect:/login");
        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        Discipline d = ddi.getDiscipline(id);
        d.setName(form.getName());
        d.setCredits(form.getCredits());
        d.setRecommended(form.isRecommended());
        ddi.updateDiscipline(d);
        return mv;
    }

    @RequestMapping(value = "/discipline/add", method = RequestMethod.GET)
    public ModelAndView addDiscipline() throws SQLException {
        ModelAndView mv = new ModelAndView("add");
        return mv;
    }

    @RequestMapping(value = "/discipline/add", method = RequestMethod.POST)
    public ModelAndView addDiscipline(@ModelAttribute("DisciplineForm")DisciplineForm form) throws SQLException {
        ModelAndView mv = new ModelAndView("redirect:/login");
        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        String name = form.getName();
        Charset.forName("UTF-8").encode(name);
        System.out.println();
        ddi.create(new Discipline(name, form.getCredits(), form.isRecommended()));
        return mv;
    }

    @RequestMapping(value="/signin",method=RequestMethod.POST)
    public ModelAndView signIn(int userId, int disciplineId) {
        Discipline_has_UserDAOImpl dhui = new Discipline_has_UserDAOImpl();
        ModelAndView model = new ModelAndView("supervisor");
        try {
            SignInBean signInBean = dhui.signIn(userId, disciplineId);
            IndexDelegate id = new IndexDelegate();
            model = new ModelAndView("student");
            model.addObject("userId", signInBean.getUser().getId());
            model.addObject("name", signInBean.getUser().getName() + " " + signInBean.getUser().getSecondname());
            model.addObject("mydisciplines", signInBean.getUser().getDisciplines());
            model.addObject("credits", signInBean.getUser().getCredits());
            model.addObject("alldisciplines", id.getAllDiscipline());
            model.addObject("color", signInBean.getType());
            model.addObject("responce", signInBean.getResponce());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }


    @RequestMapping(value="/edit",method=RequestMethod.POST)
    public ModelAndView edit(int disciplineId, String teacher, String description, boolean recommended) {
        //це херня, переробити
        XMLParser xml = new XMLParser();
        xml.createInfoFile(disciplineId, teacher, description);
        DisciplineDAOImpl ddi =  new DisciplineDAOImpl();
        try {
            Discipline d = ddi.getDiscipline(disciplineId);
            d.setRecommended(recommended);
            ddi.updateDiscipline(d);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("supervisorResponce");
        IndexDelegate id = new IndexDelegate();
        modelAndView.addObject("responce", "Дані було успішно оновлено!");
        try {
            modelAndView.addObject("alldisciplines", id.getAllDiscipline());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelAndView;

    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public ModelAndView editXMLDiscipline(@PathVariable Integer id) throws SQLException {
        ModelAndView mv = new ModelAndView("editXML");
        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        Discipline d = ddi.getDiscipline(id);
        mv.addObject("discipline", d);
        return mv;
    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ModelAndView saveXMLDiscipline(@PathVariable Integer id, @ModelAttribute("DisciplineForm")DisciplineForm form) throws SQLException {
        ModelAndView mv = new ModelAndView("redirect:/login");
        XMLParser xml = new XMLParser();
        xml.createInfoFile(id, form.getTeacher(), form.getDescription());
        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        Discipline d = ddi.getDiscipline(id);
        d.setRecommended(form.isRecommended());
        ddi.updateDiscipline(d);
        return mv;
    }

    @RequestMapping(value="/editXML/{id}", method= RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public ModelAndView editXMLCode(@PathVariable Integer id) throws SQLException, FileNotFoundException {
        ModelAndView mv = new ModelAndView("editXMLCode");
        XMLParser xmlParser = new XMLParser();
        String xmlStr = xmlParser.getFile(id);

        mv.addObject("XML", new XML());
        mv.addObject("xml", xmlStr);
        mv.addObject("id", id);
        return mv;
    }

    @RequestMapping(value="/editXML/{id}", method= RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ModelAndView saveXMLCode(@PathVariable Integer id, @ModelAttribute("XML")XML xml) throws SQLException {
        ModelAndView mv = new ModelAndView("redirect:/login");
        XMLParser xmlParser = new XMLParser();
        xmlParser.createInfoFileUsingString(id, xml.getXml());
        return mv;
    }
}
