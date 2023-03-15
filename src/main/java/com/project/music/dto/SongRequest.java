package com.project.music.dto;

import com.project.music.model.Playlist;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongRequest {

    private int id;
    @NotBlank(message = "Song Name is Mandatory")
    private String songName;
    @NotBlank(message = "Artist Name is Mandatory")
    private  String artistName;

}
