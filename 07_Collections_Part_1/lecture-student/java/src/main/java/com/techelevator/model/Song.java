package com.techelevator.model;

import java.util.Objects;

public class Song {
    private String songName;

    private String genre;

    private int timeInSeconds;

    //fields^^^^^^^^

    //constructors
    //no arguements
    public Song(){

    }

    public Song(String songName, String genre, int timeInSeconds) {
        this.songName = songName;
        this.genre = genre;
        this.timeInSeconds = timeInSeconds;
    }

    //methods


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return timeInSeconds == song.timeInSeconds && Objects.equals(songName, song.songName) && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, genre, timeInSeconds);
    }

    @Override
    public String toString(){
        return songName + " "+genre;
    }
}
