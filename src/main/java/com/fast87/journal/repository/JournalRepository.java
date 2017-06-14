package com.fast87.journal.repository;

import com.fast87.journal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jojonari on 2017. 6. 14..
 */
public interface JournalRepository  extends JpaRepository<Journal, Long>{
}
