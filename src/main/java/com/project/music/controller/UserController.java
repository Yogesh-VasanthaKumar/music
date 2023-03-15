package com.project.music.controller;

import com.project.music.dto.UserRequest;
import com.project.music.model.User;
import com.project.music.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/music/User")
public class UserController {

    @Autowired
    MusicService service;
@PostMapping("/add")
    public ResponseEntity<String> postUser(@Valid @RequestBody UserRequest userRequest){
    return new ResponseEntity<>(service.postUser(userRequest), HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
    return service.deleteUser(id);
}

@GetMapping("/get")
    public ResponseEntity<String> getUser(){
    return service.getUser();
}


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
