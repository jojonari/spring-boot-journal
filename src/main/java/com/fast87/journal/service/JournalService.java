package com.fast87.journal.service;

import com.fast87.journal.domain.JournalEntry;
import com.fast87.journal.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by jojonari on 2017. 7. 3..
 */
@Service
public class JournalService {
    private static final Logger log =  LoggerFactory.getLogger(JournalService.class);

    @Autowired
    JournalRepository repo;

    public void insertData() throws ParseException {
        log.info(">데이터 생성");
        repo.save(new JournalEntry("스프링부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", "01/01/2016"));
        repo.save(new JournalEntry("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트 만들었다", "01/02/2016"));
        repo.save(new JournalEntry("졸립다", "사실 공부하기 싫다", "01/03/2016"));
        repo.save(new JournalEntry("배고프다", "밥은 먹었는데 그래도 배고프다", "01/04/2016"));
        repo.save(new JournalEntry("그래도 공부를 하자", "먹고 사는게 쉬운일이 아니다", "01/05/2016"));
        log.info(">완료");
    }


    public List<JournalEntry> findAll(){
        return repo.findAll();
    }
}
