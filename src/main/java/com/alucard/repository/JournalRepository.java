package com.alucard.repository;

import com.alucard.domain.Journal;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alucard on 5/9/2017.
 */
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
