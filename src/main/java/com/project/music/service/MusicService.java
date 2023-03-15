package com.project.music.service;

import com.project.music.dao.PlaylistRepository;
import com.project.music.dao.SongRepository;
import com.project.music.dao.UserRepository;
import com.project.music.dto.PlaylistRequest;
import com.project.music.dto.SongRequest;
import com.project.music.dto.UserRequest;
import com.project.music.model.Playlist;
import com.project.music.model.Song;
import com.project.music.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {
@Autowired
UserRepository repository;

@Autowired
    SongRepository songRepository;

@Autowired
    PlaylistRepository playlistRepository;

public String  postUser(UserRequest userRequest){
       User user = new User(userRequest.getId(),userRequest.getName(),userRequest.getUsername(),userRequest.getPassword(),userRequest.isAdmin());
        repository.save(user);
        return "UserCreated";
}

public ResponseEntity<String>  getUser(){
    if(repository.findAll().size()==0){
        return new ResponseEntity<>("No User Found",HttpStatus.NOT_FOUND);

    }
    else {
        return new ResponseEntity<>(repository.findAll().toString(),HttpStatus.OK);
    }
}

public ResponseEntity<String> deleteUser(int id){
    List<User> users = repository.findAll();
    for(User user: users){
        if(user.getId()==id){
            repository.deleteById(id);
            return new ResponseEntity<>(user.getName()+" Deleted",HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>("No User Found", HttpStatus.NOT_FOUND);
        }
    }
    return new ResponseEntity<>("No User Found", HttpStatus.NOT_FOUND);
}













public ResponseEntity<String> getAllSong(int id){
   if(repository.findById(id) == null){
       return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
   }
   else {
       return new ResponseEntity<>( songRepository.findAll().toString(),HttpStatus.OK);
   }
}

public  ResponseEntity<String> addSong(int id, SongRequest songRequest){
    if(repository.findById(id) == null){
        return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
    }
    else { if(!(repository.findById(id).isAdmin())){
        return new ResponseEntity<>( "Please Signup as Admin", HttpStatus.BAD_REQUEST);
    }
    else{
        Song song = new Song(songRequest.getId(),songRequest.getSongName(),songRequest.getArtistName());
        songRepository.save(song);
        return new ResponseEntity<>( "Song Added",HttpStatus.CREATED);}
    }
}

public ResponseEntity<String> removeSong(int id, int songId){
    if(repository.findById(id) == null && repository.findById(id).isAdmin()){
        return new ResponseEntity<>( "Please Signup as Admin", HttpStatus.BAD_REQUEST);
    }
    else { if(!(repository.findById(id).isAdmin())){
        return new ResponseEntity<>( "Please Signup as Admin", HttpStatus.BAD_REQUEST);
    }
    else if (songRepository.findById(songId)==null){
            return new ResponseEntity<>( "No Song Found",HttpStatus.NOT_FOUND);
        }
        else {
            songRepository.deleteById(songId);
        return new ResponseEntity<>( "Song Deleted",HttpStatus.OK);}
    }
}


public ResponseEntity<String> updateSong(int id, SongRequest songRequest){
    if(repository.findById(id) == null  ){
        return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
    }
    else {
        if(!(repository.findById(id).isAdmin())){
            return new ResponseEntity<>( "Please Signup as Admin", HttpStatus.BAD_REQUEST);
        }
       else if (songRepository.findById(songRequest.getId())==null){
            return new ResponseEntity<>( "No Song Found",HttpStatus.NOT_FOUND);
        }
        else {
            Song song = songRepository.findById(songRequest.getId());
                song.setSongName(songRequest.getSongName());
                song.setArtistName(songRequest.getSongName());
            songRepository.save(song);
            return new ResponseEntity<>( "Song Updated",HttpStatus.OK);
        }
    }
}


    public  ResponseEntity<String> addPlaylist(int id, PlaylistRequest playlistRequest){
        if(repository.findById(id) == null){
            return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
        }
        else {

            Playlist playlist = new Playlist(playlistRequest.getId(),playlistRequest.getName(),playlistRequest.getSongList(),repository.findById(id));
               playlistRepository.save(playlist);
            return new ResponseEntity<>( "Playlist Created",HttpStatus.CREATED);}

    }
    public ResponseEntity<String> removeSongfromPlaylist(int id, int playlistId, int songId){
        if(repository.findById(id) == null){
            return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
        }
        else {
        if (playlistRepository.findById(playlistId)==null){
            return new ResponseEntity<>( "No Playlist Found",HttpStatus.NOT_FOUND);
        }  else {
            Playlist playlist= playlistRepository.findById(playlistId);
            List<Song> songList = playlistRepository.findById(playlistId).getSongList();
            for(Song song:songList){
                if(song.getId()==songId){
                    songList.remove(song);
                }
            }

            if(playlist.getSongList().size()==0){
                playlistRepository.deleteById(playlistId);
            }
            playlistRepository.save(playlist);
            return new ResponseEntity<>( "Song Deleted",HttpStatus.OK);}
        }
    }

public ResponseEntity<String> addSongtoPlaylist(int id, int playlistId, int songId){
    if(repository.findById(id) == null){
        return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
    }
    else {
        if (playlistRepository.findById(playlistId)==null){
            return new ResponseEntity<>( "No Playlist Found",HttpStatus.NOT_FOUND);
        }  else {
            Playlist playlist= playlistRepository.findById(playlistId);
            Song song = songRepository.findById(songId);
            List<Song> songList = playlistRepository.findById(playlistId).getSongList();
            for(Song songinplaylist:songList){
                if(songinplaylist.getId()==songId){
                    return new ResponseEntity<>( "Song already in Playlist",HttpStatus.BAD_REQUEST);
                }
                else {
                    songList.add(song);
                }
            }
        }
}
return new ResponseEntity<>( "Song added to Playlist",HttpStatus.OK);
}


public ResponseEntity<String> getallPlaylist(int id){
    if(repository.findById(id) == null){
        return new ResponseEntity<>( "Please Signup", HttpStatus.BAD_REQUEST);
    }
    else {
        List<Playlist> playlists=new ArrayList<>();
        for(Playlist playlist: playlistRepository.findAll()){
            if(playlist.getUser().getId()==id){
                playlists.add(playlist);
            }
        }
        return new ResponseEntity<>(playlists.toString(),HttpStatus.OK);
    }
}

}
