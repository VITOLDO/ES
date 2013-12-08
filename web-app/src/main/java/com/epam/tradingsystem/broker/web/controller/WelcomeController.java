package com.epam.tradingsystem.broker.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Viktor, Filonenko
 * @since: 06.12.13
 */
@Controller
public class WelcomeController {
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public void home(HttpServletRequest request) {
        request.getSession().setAttribute("hello","world");
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public ModelAndView viewHomePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("HOME_PAGE");

        return modelAndView;
    }
}
