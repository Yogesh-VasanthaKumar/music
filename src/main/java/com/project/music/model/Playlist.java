package com.project.music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private int id;

    @Column(name = "playlist_name")

    private String name;


@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(
        name = "Playlist_song",
        joinColumns = {
                @JoinColumn(name = "playlist_id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "song_id")
        }
)
private List<Song> songList = new ArrayList<Song>();

@ManyToOne
    private User user;
}
