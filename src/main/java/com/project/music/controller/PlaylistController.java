package com.project.music.controller;

import com.project.music.dto.PlaylistRequest;
import com.project.music.dto.SongRequest;
import com.project.music.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/music/playlist")
public class PlaylistController {
    @Autowired
    MusicService service;

    @GetMapping("/get/{userId}")
    public ResponseEntity<String> getAllplaylist(@PathVariable int userId){
        return service.getallPlaylist(userId);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<String> addSong(@Valid  @PathVariable int userId, @RequestBody PlaylistRequest playlistRequest){
        return service.addPlaylist(userId,playlistRequest);
    }

    @PutMapping("/update/{userId}/{songId}/{playlistid}")
    public ResponseEntity<String> updateSong(@PathVariable int userId, int songId , int playlistid){
        return service.addSongtoPlaylist(userId,playlistid,songId);
    }

    @DeleteMapping("/delete/{userid}/{songid}/{playlistid}")
    public ResponseEntity<String> deleteSong(@PathVariable int userId,int songid,int playlistid){
        return service.removeSongfromPlaylist(userId,playlistid,songid);
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
