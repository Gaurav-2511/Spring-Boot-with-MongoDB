package com.gaurav.controller;

import com.gaurav.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_ournal")
public class JournalEntryPoint {

    private Map<Long, JournalEntry> journalEntrys = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntrys.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntrys.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getGournalEntryById(@PathVariable long myId){
        return journalEntrys.get(myId);
    }
    
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteById(@PathVariable long myId){
        return journalEntrys.remove(myId);
    }


    @PutMapping("id/{myId}")
    public JournalEntry updateById(@PathVariable long myId, @RequestBody JournalEntry entry){
        return journalEntrys.put(myId, entry);
    }
}
