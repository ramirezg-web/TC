package com.techelevator.model.mock;

import com.techelevator.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongData {

    public static List<Song> getPlaylist1() {
        List<Song> songList = new ArrayList<>();
        Song song = new Song("Name1", "Genre 1", 100);
        songList.add(new Song("Name2", "Genre 2", 120));
        songList.add(new Song("Name3", "Genre 3", 130));

        return songList;
    }

    public static List<Song> getPlaylist2() {
        List<Song> songList = new ArrayList<>();
        Song song = new Song("Name1", "Genre 1", 100);
        songList.add(new Song("Nam 4", "Genre 4", 140));
        songList.add(new Song("Name 5", "Genre 5", 150));

        return songList;
    }
}
