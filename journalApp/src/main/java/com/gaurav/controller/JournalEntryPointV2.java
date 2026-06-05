package com.gaurav.controller;

import com.gaurav.entity.JournalEntry;
import com.gaurav.service.JournalEntryService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryPointV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public ResponseEntity<List<JournalEntry>> getEntries(){
        List<JournalEntry> entries = journalEntryService.getEntries();

        if(entries != null && !entries.isEmpty()){
            return new ResponseEntity<>(entries,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> saveEntry(@RequestBody JournalEntry journalEntry){

        try {
            JournalEntry entry = journalEntryService.saveEntry(journalEntry);
            return new ResponseEntity<JournalEntry>(entry, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId id){
        Optional<JournalEntry> journalEntry = journalEntryService.getEntryById(id);

        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId id){
        journalEntryService.deleteEntryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){

        JournalEntry oldEntry = journalEntryService.updateJournalEntryById(id).orElse(null);

        if(oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());

            JournalEntry entry = journalEntryService.saveEntry(oldEntry);
            return new ResponseEntity<JournalEntry>(entry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
