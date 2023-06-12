package com.fegorsoft.phonebook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fegorsoft.phonebook.model.People;
import com.fegorsoft.phonebook.repository.PhonebookRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Phonebook", description = "API Phonebook")
@RestController
@RequestMapping("/phonebook")
@RequiredArgsConstructor
public class PhonebookController {

    @Autowired
    PhonebookRepository phonebookRepository;

    @GetMapping("/forCreateDate")
    public Collection<People> getPeopleForCreateDate(String startDate, String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date sd = null;
        Date ed = null;

		try {
            sd = formatter.parse(startDate);
            ed = formatter.parse(endDate);

        } catch (ParseException e) {
            // TODO Tratar el error
            e.printStackTrace();
        }

        log.info("Find people for: startDate = {}, endDate = {}", sd, ed);
        return phonebookRepository.findPeopleForCreateDate(sd, ed);
    }

    @GetMapping("/all")
    public Collection<People> getAllPeople() {
        log.info("Find all people");
        return phonebookRepository.findAll();
    }
 }
