package com.gaurav.controller;

import com.gaurav.entity.JournalEntry;
import com.gaurav.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryPointV2 {

    @Autowired
    private JournalEntryService journalEntryService;




    @PostMapping
    public boolean saveEntry(@RequestBody JournalEntry journalEntry){
        journalEntryService.saveEntry(journalEntry);
        return true;
    }

}
