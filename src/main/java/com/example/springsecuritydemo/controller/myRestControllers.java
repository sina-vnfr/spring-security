package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dto.user;
import com.example.springsecuritydemo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class myRestControllers {

    @Autowired
    private userRepository userRepository;

    @GetMapping("/getpizza")
    public String getPizza(){ return "take your pizza" ;}
    @GetMapping("/gethamber")
    public ResponseEntity<String> getHamber(){
        return new ResponseEntity<>("take your Hamber" , HttpStatus.OK);
    }
    @GetMapping("/getcoka")
    public ResponseEntity<String> getCoka(){
        return new ResponseEntity<>("take your cokacola" , HttpStatus.OK);
    }
    @RequestMapping(
            value = "/saveuser",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> saveUser(@RequestBody user user){
        userRepository.save(user);
        return new ResponseEntity<>("your information succesfully saved" , HttpStatus.OK);
    }
}
