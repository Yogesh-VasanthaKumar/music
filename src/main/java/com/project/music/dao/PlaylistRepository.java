package com.project.music.dao;

import com.project.music.model.Playlist;
import com.project.music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {
    Playlist findById(int Id);
}
