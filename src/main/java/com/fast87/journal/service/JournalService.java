package com.fast87.journal.service;

import com.fast87.journal.domain.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jojonari on 2017. 7. 3..
 */
@Service
public class JournalService {
    private static final Logger log =  LoggerFactory.getLogger(JournalService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertData(){
        log.info(">테이블 생성");
        jdbcTemplate.execute("DROP  TABLE JOURNAL IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE JOURNAL(id SERIAL, title VARCHAR(255), summary VARCHAR(255), created TIMESTAMP)");
        log.info(">데이터 생성");
        jdbcTemplate.execute("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 입문', '오늘 스프링 배웠다', '2016-01-01 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 프로젝트', '프로젝트 배웠다', '2016-01-02 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO JOURNAL(title, summary, created) VALUES ('스프링 부트 해부', '스프링부트를 파해쳤다', '2016-01-03 00:00:00.00')");
        log.info(">완료");
    }


    public List<Journal> findAll(){
        List<Journal> entries = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM JOURNAL", new Object[]{}, (rs,row) -> new Journal(rs.getLong("id"), rs.getString("title"), rs.getString("summary"), new Date(rs.getTimestamp("created").getTime())))
                .forEach(entry -> entries.add(entry));
        return entries;
    }
}
