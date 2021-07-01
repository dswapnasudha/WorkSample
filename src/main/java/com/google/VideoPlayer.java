package com.google;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  
  private List <Video> videos = new VideoLibrary().getVideos() .stream()
          .sorted(Comparator.comparing(Video :: getTitle))
          .collect(Collectors.toList());
  
  private List<String> allPlaylists = new ArrayList<>();

  private Video currentVideo = null;

  private Boolean pause = false;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    List<Video> listOfAllVideos= videoLibrary.getVideos();
    listOfAllVideos.sort(Comparator.comparing(Video::getTitle));	
    
	 for (Video str :listOfAllVideos) 		 
		 System.out.println(str);
	   }

  public void playVideo(String videoId)  {	  
	  
	  Video video = videoLibrary.getVideo(videoId);	  
	  
	  pause = false;
	    if(currentVideo == null && videos.stream().anyMatch(Video -> video.getVideoId().equals(videoId))){
	      currentVideo = videos.stream().filter(Video -> video.getVideoId().equals(videoId)).findAny().orElse(null);
	      System.out.println("Playing video: " + currentVideo.getTitle());
	    } else if(video!= null && currentVideo != null && !videos.stream().noneMatch(Video -> video.getVideoId().equals(videoId))){
	      System.out.println("Stopping video: " + currentVideo.getTitle());
	      currentVideo = videos.stream().filter(Video -> video.getVideoId().equals(videoId)).findAny().orElse(null);
	      System.out.println("Playing video: " + currentVideo.getTitle());
	    } else{
	      System.out.println("Cannot play video: Video does not exist");
	    }
	    
	      
	  }
  
  

	public void stopVideo() {
    
	    if(currentVideo != null){
	        System.out.println("Stopping video: " + currentVideo.getTitle());
	        currentVideo = null;
	      } else{
	        System.out.println("Cannot stop video: No video is currently playing");
	      }	    
    }
	
  public void playRandomVideo() {
    
	  Random r = new Random();
	    int randomVideoIndex = r.nextInt(videos.size());
	    pause = false;
	    if(currentVideo != null){
	      stopVideo();
	      playVideo(videos.get(randomVideoIndex).getVideoId());
	    } else if(currentVideo == null){
	      playVideo(videos.get(randomVideoIndex).getVideoId());
	    }
    
  }

  public void pauseVideo() {
	  if(currentVideo != null){
	      if(!pause){
	        pause = true;
	        System.out.println("Pausing video: " + currentVideo.getTitle());
	      } else if (pause){
	        System.out.println("Video already paused: " + currentVideo.getTitle());
	      }
	    }else{
	      System.out.println("Cannot pause video: No video is currently playing");
	    }
  }

  public void continueVideo() {
	  if(currentVideo != null){
	      if(pause){
	        System.out.println("Continuing video: " + currentVideo.getTitle());
	        pause = false;
	      } else if(!pause){
	        System.out.println("Cannot continue video: Video is not paused");
	      }

	    } else{
	      System.out.println("Cannot continue video: No video is currently playing");
	    }
	  
  }

  public void showPlaying() {
	  if(currentVideo != null){
	      String pauseStatus;
	      if(pause){
	        pauseStatus = " - PAUSED";
	      } else{
	        pauseStatus = "";
	      }
	      System.out.println("Currently playing: " + currentVideo.getTitle() + " (" + currentVideo.getVideoId() + ") [" + currentVideo.getTags().stream().collect(Collectors.joining(" ")) + "]"+ pauseStatus);
	    } else{
	      System.out.println("No video is currently playing");
	    }
  }

  public void createPlaylist(String playlistName) {
	  if(!allPlaylists.stream().anyMatch(playlistName :: equalsIgnoreCase) && !playlistName.isEmpty()){
	      allPlaylists.add(playlistName);
	      System.out.println("Successfully created new playlist: " + playlistName);
	    } else {
	      System.out.println("Cannot create playlist: A playlist with the same name already exists");
	    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
	  System.out.println("addVideoToPlaylist needs implementation");	  	  
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