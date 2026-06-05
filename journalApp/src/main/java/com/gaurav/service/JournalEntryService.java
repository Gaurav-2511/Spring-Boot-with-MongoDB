package com.gaurav.service;

import com.gaurav.entity.JournalEntry;
import com.gaurav.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public JournalEntry saveEntry(JournalEntry journalEntry){
        journalEntry.setDateTime(LocalDateTime.now());
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getEntries(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId id){

       return journalEntryRepository.findById(id);
    }

    public boolean deleteEntryById(ObjectId id){
        journalEntryRepository.deleteById(id);
        return true;
    }

    public Optional<JournalEntry> updateJournalEntryById(ObjectId id){
        Optional<JournalEntry> byId = journalEntryRepository.findById(id);
        return byId;
    }

}
