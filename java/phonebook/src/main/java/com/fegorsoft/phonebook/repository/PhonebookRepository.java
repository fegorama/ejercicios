package com.fegorsoft.phonebook.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fegorsoft.phonebook.model.People;

public interface PhonebookRepository extends JpaRepository<People, Long> {

    @Query("SELECT p FROM People p WHERE (p.createDate BETWEEN :startDate AND :endDate)")
    Collection<People> findPeopleForCreateDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}