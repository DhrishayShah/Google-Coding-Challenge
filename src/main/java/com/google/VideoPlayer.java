package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private String playing = "";
  private boolean pause = false;
  private VideoPlaylist playlist = new VideoPlaylist();
  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    ArrayList<Video> allVideos = (ArrayList<Video>) videoLibrary.getVideos();
    String [] allVids = new String[allVideos.size()];
    System.out.println("Here's a list of all available videos:");
    for(int i = 0; i < allVideos.size(); i++){
      allVids[i] = allVideos.get(i).getTitle() + " (" + 
                  allVideos.get(i).getVideoId() + ") "
                   + allVideos.get(i).getTags();
    }
    Arrays.sort(allVids);

    for(int i = 0; i < allVids.length;i++){
      System.out.println(allVids[i].replaceAll(",",""));
    }
    
    
  }
  
  public void playVideo(String videoId) {
    Video videoToPlay = videoLibrary.getVideo(videoId);
    if(!playing.equals("")){
      System.out.println("Stopping video: " + videoLibrary.getVideo(playing).getTitle());
      System.out.println("Playing video: " + videoToPlay.getTitle());
      playing = videoId;
      return;
    }
    if(videoToPlay != null){
      playing = videoId;
      System.out.println("Playing video: " + videoToPlay.getTitle());
    }else{
      System.out.println("Cannot play video: Video does not exist");
      playing = "";
    }
  }

  public void stopVideo() {
    Video currentlyPlaying = videoLibrary.getVideo(playing);
    
    if(playing.equals("")){
      System.out.println("Cannot stop video: No video is currently playing");
    }
    else{
      System.out.println("Stopping video: " + currentlyPlaying.getTitle());
      playing = "";
    }
    
    
  }

  public void playRandomVideo() {
    Random rand = new Random();
    int random = rand.nextInt(videoLibrary.getVideos().size());
    ArrayList<Video> allVideos = (ArrayList<Video>) videoLibrary.getVideos();
    if(!playing.equals("")){
      System.out.println("Stopping video: " + videoLibrary.getVideo(playing).getTitle());
      System.out.println("Playing video: " + allVideos.get(random).getTitle());
      playing = allVideos.get(random).getVideoId();
    }else{
      System.out.println("Playing video: " + allVideos.get(random).getTitle());
      playing = allVideos.get(random).getVideoId();
    }
    
  }

  public void pauseVideo() {
    if(!pause){
      System.out.println("Pausing video: " + videoLibrary.getVideo(playing).getTitle());
      pause = true;
    }else if(playing.equals("")){
      System.out.println("Cannot pause video: No video is currently playing");
    }else{
      System.out.println("Video already paused: " + videoLibrary.getVideo(playing).getTitle());
    }
  }

  public void continueVideo() {
    if(playing.equals("")){
      System.out.println("Cannot continue video: No video is currently playing");
      return;
    }
    if(pause){
      System.out.println("Continuing video: " + videoLibrary.getVideo(playing).getTitle());
    }else{
      System.out.println("Cannot continue video: Video is not paused");
    }
    
  }

  public void showPlaying() {

    if(!playing.equals("") && !pause){
      String currentVideo = videoLibrary.getVideo(playing).getTitle() + " (" + 
                            videoLibrary.getVideo(playing).getVideoId() + ") " +
                            videoLibrary.getVideo(playing).getTags();
      System.out.println("Currently playing: " + currentVideo.replaceAll(",",""));
    }else if(pause){
      String currentVideo = videoLibrary.getVideo(playing).getTitle() + " (" + 
                            videoLibrary.getVideo(playing).getVideoId() + ") " +
                            videoLibrary.getVideo(playing).getTags() + " - PAUSED";
      System.out.println("Currently playing: " + currentVideo.replaceAll(",",""));

    }else{
      System.out.println("No video is currently playing");
    }

    
  }

  public void createPlaylist(String playlistName) {
  
    boolean nameExists = playlist.checkIfNameExists(playlistName);
    if(nameExists){
      System.out.println("Cannot create playlist: A playlist with the same name already exists");
    }else{
      playlist.addPlaylist(playlistName);
      playlist.addPlaylistName(playlistName);
      System.out.println("Successfully created new playlist: " + playlistName);
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    ArrayList<Video> currentPlaylist = playlist.getPlaylist(playlistName);
    Video vid = videoLibrary.getVideo(videoId);
    if(currentPlaylist != null && vid != null){
      currentPlaylist.add(vid);
      playlist.updatePlaylist(playlistName, currentPlaylist);
      System.out.println("Added video to my_playlist: " + vid.getTitle());
    }else{
      System.out.println("");
    }
    
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}