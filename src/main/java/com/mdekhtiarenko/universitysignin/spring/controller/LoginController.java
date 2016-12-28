package com.mdekhtiarenko.universitysignin.spring.controller;


import com.mdekhtiarenko.universitysignin.dao.PeriodDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.User;
import com.mdekhtiarenko.universitysignin.spring.delegate.IndexDelegate;
import com.mdekhtiarenko.universitysignin.spring.delegate.LoginDelegate;
import com.mdekhtiarenko.universitysignin.spring.viewBean.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {
    @Autowired
    private LoginDelegate loginDelegate;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User isValidUser = (User)request.getSession().getAttribute("user");
        if(isValidUser!=null) {
            if(isValidUser.getRole().equals("Student")) {
                return redirectStudentPage(isValidUser);
            }
            else if (isValidUser.getRole().equals("Supervisor")){
                return redirectSupervisorPage(isValidUser);
            }
            else if(isValidUser.getRole().equals("Admin")){
                return redirectAdminPage(isValidUser);
            }
        } else {
            ModelAndView model = new ModelAndView("login");
            LoginBean loginBean = new LoginBean();
            model.addObject("loginBean", loginBean);
            return model;
        }
        return new ModelAndView("index");
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        ModelAndView mv = new ModelAndView("index");
        IndexDelegate indexDelegate = new IndexDelegate();
        mv.addObject("list", indexDelegate.getAllDiscipline());
        return mv;
    }



    @RequestMapping(value = "/role/admin", method = RequestMethod.GET)
    public ModelAndView redirectAdminPage(User user) throws SQLException {
        ModelAndView model = new ModelAndView("admin");
        model = new ModelAndView("admin");
        IndexDelegate id = new IndexDelegate();
        model.addObject("userId", user.getId());
        model.addObject("name", user.getName() + " " + user.getSecondname());
        model.addObject("alldisciplines", id.getAllDiscipline());
        model.addObject("period", id.getPeriod());
        return model;
    }

    @RequestMapping(value = "/role/student", method = RequestMethod.GET)
    public ModelAndView redirectStudentPage(User user) throws SQLException {
        ModelAndView model = new ModelAndView("student");
        IndexDelegate id = new IndexDelegate();
        PeriodDAOImpl pdi = new PeriodDAOImpl();
        model.addObject("period", pdi.getPeriod());
        model.addObject("userId", user.getId());
        model.addObject("name", user.getName() + " " + user.getSecondname());
        model.addObject("mydisciplines", user.getDisciplines());
        model.addObject("credits", user.getCredits());
        model.addObject("alldisciplines", id.getAllDiscipline());
        return model;
    }

    @RequestMapping(value = "/role/supervisor", method = RequestMethod.GET)
    public ModelAndView redirectSupervisorPage(User user) throws SQLException {
        ModelAndView model = new ModelAndView("supervisor");
        IndexDelegate id = new IndexDelegate();
        model.addObject("userId", user.getId());
        model.addObject("name", user.getName() + " " + user.getSecondname());
        model.addObject("alldisciplines", id.getAllDiscipline());
        model.addObject("period", id.getPeriod());
        return model;
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean) {
        ModelAndView model=null;
        try {

            User isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            request.getSession().setAttribute("user", isValidUser);

            if(isValidUser!=null) {

               if(isValidUser.getRole().equals("Student")) {
                   return redirectStudentPage(isValidUser);
               }
               else if (isValidUser.getRole().equals("Supervisor")){
                    return redirectSupervisorPage(isValidUser);
               }
               else if(isValidUser.getRole().equals("Admin")){
                    return redirectAdminPage(isValidUser);
               }
               else {
                   return new ModelAndView("index");
               }
            }
            else {
                model = new ModelAndView("login");
                model.addObject("loginBean", loginBean);
                request.setAttribute("message", "Invalid credentials!!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return model;
    }
}
