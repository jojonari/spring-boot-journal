package com.fast87.journal.repository;

import com.fast87.journal.domain.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

/**
 * Created by jojonari on 2017. 7. 3..
 */
@Transactional
@RepositoryRestResource(collectionResourceRel = "entry", path = "journal")
public interface JournalRepository extends JpaRepository<JournalEntry, Long>{
    List<JournalEntry> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = DATE)Date date);
    List<JournalEntry> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = DATE)Date after, @Param("before") @DateTimeFormat(iso = DATE)Date before);
    List<JournalEntry> findByTitleContaining(@Param("word") String word);
    List<JournalEntry> findBySummaryContaining(@Param("word") String word);

}
