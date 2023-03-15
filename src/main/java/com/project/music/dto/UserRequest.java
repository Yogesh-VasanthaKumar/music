package com.project.music.dto;

import com.project.music.model.Playlist;
import com.project.music.model.Song;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private int id;
    @NotBlank(message = "User Name is Mandatory")
    private String name;
    @NotBlank(message = "User Name is Mandatory")
    private String username;

    @Pattern(regexp = "^([A-z]).{8,20}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;

    private boolean admin;


}
