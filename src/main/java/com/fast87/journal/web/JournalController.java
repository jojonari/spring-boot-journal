package com.fast87.journal.web;

import com.fast87.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jojonari on 2017. 6. 15..
 */
@RestController
public class JournalController{
    private static final String VIEW_INDEX = "index";

    @Autowired
    JournalRepository repo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("journal", repo.findAll());
        return modelAndView;
    }

}