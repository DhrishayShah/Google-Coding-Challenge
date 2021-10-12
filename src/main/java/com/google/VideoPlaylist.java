package com.google;

import java.util.*;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private HashMap<String, ArrayList<Video>> allPlaylists = new HashMap<String,ArrayList<Video>>();
    private HashSet<String> playlistNames = new HashSet<String>();

   public void addPlaylist(String playlistName){
       allPlaylists.put(playlistName, new ArrayList<Video>());
   }

    public void addPlaylistName(String playlistName){
        playlistName = playlistName.toLowerCase();
        playlistNames.add(playlistName);
    }

    public boolean checkIfNameExists(String playlistName){
        playlistName = playlistName.toLowerCase();
        if(playlistNames.contains(playlistName)){
            return true;
        }
        return false;
    }
    public ArrayList<Video> getPlaylist(String playlistName){
       return allPlaylists.get(playlistName);
    }

    public void updatePlaylist(String playlistName,ArrayList<Video> updatedList){
        allPlaylists.put(playlistName, updatedList);
    }
    
}
