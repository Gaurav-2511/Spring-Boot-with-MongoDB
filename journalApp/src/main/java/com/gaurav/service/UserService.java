package com.gaurav.service;

import com.gaurav.entity.JournalEntry;
import com.gaurav.entity.User;
import com.gaurav.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();


    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getEntryById(ObjectId id){

       return userRepository.findById(id);
    }

    public boolean deleteEntryById(ObjectId id){
        userRepository.deleteById(id);
        return true;
    }

    public Optional<User> updateJournalEntryById(ObjectId id){
        Optional<User> byId = userRepository.findById(id);
        return byId;
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

}
