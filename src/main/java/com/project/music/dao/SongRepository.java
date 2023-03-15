package com.project.music.dao;

import com.project.music.model.Song;
import com.project.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

    Song findById(int Id);
}
