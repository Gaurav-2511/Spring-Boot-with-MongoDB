package com.gaurav.service;

import com.gaurav.entity.JournalEntry;
import com.gaurav.entity.User;
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

    @Autowired
    private UserService userService;


    public void saveEntry(JournalEntry journalEntry, String userName){
        User user = userService.findByUserName(userName);
        journalEntry.setDateTime(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);
    }

    public JournalEntry saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
        return journalEntry;
    }

    public List<JournalEntry> getEntries(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId id){

       return journalEntryRepository.findById(id);
    }

    public boolean deleteEntryById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveUser(user);
        journalEntryRepository.deleteById(id);
        return true;
    }

    public Optional<JournalEntry> updateJournalEntryById(ObjectId id){
        Optional<JournalEntry> byId = journalEntryRepository.findById(id);
        return byId;
    }

}
