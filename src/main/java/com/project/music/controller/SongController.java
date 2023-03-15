package com.project.music.controller;

import com.project.music.dto.SongRequest;
import com.project.music.model.Song;
import com.project.music.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/music/song")
public class SongController {

    @Autowired
    MusicService service;

    @GetMapping("/get/{userId}")
    public ResponseEntity<String> getAllSong(@PathVariable int userId){
        return service.getAllSong(userId);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<String> addSong(@Valid @PathVariable int userId, @RequestBody SongRequest songRequest){
        return service.addSong(userId,songRequest);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateSong(@Valid @PathVariable int userId, @RequestBody SongRequest songRequest){
        return service.updateSong(userId,songRequest);
    }

    @DeleteMapping("/delete/{userid}/{songid}")
    public ResponseEntity<String> deleteSong(@PathVariable int userId,int songid){
        return service.removeSong(userId,songid);
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
