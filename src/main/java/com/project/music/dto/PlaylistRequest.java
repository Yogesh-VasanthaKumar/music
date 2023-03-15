package com.project.music.dto;

import com.project.music.model.Song;
import com.project.music.model.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistRequest {

    private int id;
    @NotBlank(message = "PlayList Name is Mandatory")
    private String name;

    private List<Song> songList;

    private User user;


}
