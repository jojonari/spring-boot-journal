package com.fast87.journal.repository;

import com.fast87.journal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jojonari on 2017. 7. 3..
 */
@Repository
public interface JournalRepository extends JpaRepository<Journal, Long>{
}
