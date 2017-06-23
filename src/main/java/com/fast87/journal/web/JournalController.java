package com.fast87.journal.web;

import com.fast87.journal.domain.Journal;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jojonari on 2017. 6. 15..
 */
@RestController
public class JournalController{
    private static List<Journal> journals = new ArrayList<Journal>();
    
    static {
        try {
            journals.add(new Journal("스프링부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", "01/01/2016"));
            journals.add(new Journal("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트 만들었다", "01/02/2016"));
            journals.add(new Journal("졸립다", "사실 공부하기 싫다", "01/03/2016"));
            journals.add(new Journal("배고프다", "밥은 먹었는데 그래도 배고프다", "01/04/2016"));
            journals.add(new Journal("그래도 공부를 하자", "먹고 사는게 쉬운일이 아니다", "01/05/2016"));
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("journal/all")
    public List<Journal> getAll() throws ParseException{
        return journals;
    }

    @RequestMapping("journal/findBy/title/{title}")
    public List<Journal> findByTitleContains(@PathVariable String title) throws ParseException{
        return journals
                .stream()
                .filter(journal -> journal.getTitle().toLowerCase().contains(
                        title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "journal", method = RequestMethod.POST)
    public Journal add(@RequestBody Journal journal) {
        System.out.println(journal.toString());
        journals.add(journal);
        return journal;
    }

}
