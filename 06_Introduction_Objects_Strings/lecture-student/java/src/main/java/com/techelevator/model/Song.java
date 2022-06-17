package com.techelevator.model;

import java.util.Objects;

public class Song {
    //classes have fields, methods, and contsructors
    //fields

    private String songName;

    private String genre;

    private int timeInSeconds;

    public Song(String songName, String genre, int timeInSeconds) {
        this.songName = songName;
        this.genre = genre;
        this.timeInSeconds = timeInSeconds;
    }

    public Song() {

    }

    // in order to get the value we create methods

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
}
