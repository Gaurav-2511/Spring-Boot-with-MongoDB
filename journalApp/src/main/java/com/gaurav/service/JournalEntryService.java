package com.gaurav.service;

import com.gaurav.entity.JournalEntry;
import com.gaurav.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

}
