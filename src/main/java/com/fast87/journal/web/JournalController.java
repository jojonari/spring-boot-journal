package com.fast87.journal.web;

import com.fast87.journal.domain.Journal;
import com.fast87.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created by jojonari on 2017. 6. 15..
 */
@Controller
public class JournalController {

    @Autowired
    JournalRepository repo;

    @RequestMapping(value = "/journal", produces = {APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public List<Journal> getJournal(){
        return repo.findAll();
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", repo.findAll());
        return "index";
    }


}
