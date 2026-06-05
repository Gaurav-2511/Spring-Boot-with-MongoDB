package com.gaurav.controller;

import com.gaurav.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryPointV2 {

    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getGournalEntryById(@PathVariable long myId){
        return null;
    }
    
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteById(@PathVariable long myId){
        return null;
    }


    @PutMapping("id/{myId}")
    public JournalEntry updateById(@PathVariable long myId, @RequestBody JournalEntry entry){
        return null;
    }
}
