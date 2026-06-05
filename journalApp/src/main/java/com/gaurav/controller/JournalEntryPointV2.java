package com.gaurav.controller;

import com.gaurav.entity.JournalEntry;
import com.gaurav.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryPointV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getEntries(){
       return journalEntryService.getEntries();
    }


    @PostMapping
    public JournalEntry saveEntry(@RequestBody JournalEntry journalEntry){
        return journalEntryService.saveEntry(journalEntry);
       
    }

    @GetMapping("/id/{id}")
    public JournalEntry getEntryById(@PathVariable ObjectId id){
       return journalEntryService.getEntryById(id);
    }


    @DeleteMapping("/id/{id}")
    public boolean deleteEntryById(@PathVariable ObjectId id){
        return journalEntryService.deleteEntryById(id);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){

        JournalEntry oldEntry = journalEntryService.updateJournalEntryById(id).orElse(null);

        if(oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
        }

       return journalEntryService.saveEntry(oldEntry);
    }
}
