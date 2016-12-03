package com.mdekhtiarenko.universitysignin.spring.conf;

import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.UserDAOImpl;
import com.mdekhtiarenko.universitysignin.spring.delegate.IndexDelegate;
import com.mdekhtiarenko.universitysignin.spring.delegate.LoginDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mdekhtiarenko.universitysignin.spring")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LoginDelegate loginDelegate(){
        LoginDelegate loginDelegate = new LoginDelegate();
        loginDelegate.setUserService(userDAOImpl());
        return loginDelegate;
    }

    @Bean
    public UserDAOImpl userDAOImpl(){
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        return userDAOImpl;
    }

    @Bean
    public IndexDelegate indexDelegate(){
        IndexDelegate indexDelegate = new IndexDelegate();
        indexDelegate.setDisciplineService(disciplineDAOImpl());
        return indexDelegate;
    }

    @Bean
    public DisciplineDAOImpl disciplineDAOImpl(){
        DisciplineDAOImpl disciplineDAOImpl = new DisciplineDAOImpl();
        return disciplineDAOImpl;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}