package com.techelevator;
//purpose of this class to create the song objects
//kick off of new application, create some song objects

import com.techelevator.model.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Driver {
    //just put main method
    public static void main(String[] args) {
        //new instance of song holding the reference in "my first song object"
        Song myFirstSongObject= new Song("Fever","R&B",185);
        Song mySecondSongObject= new Song("Black Parade", "R&B", 205);
        Song myThirdSongObject= new Song("Mental Health","R&B", 302);

        //create a song array
//        Song[] songArray= new Song[3];
//        songArray[0]=myFirstSongObject;
//        songArray[1]=mySecondSongObject;
//        songArray[2]=myThirdSongObject;
        //an array is a fixed allocation
//        Song[] songArray={myFirstSongObject,mySecondSongObject,myThirdSongObject};


        List<Song> songList= new ArrayList<>();
        songList.add(myFirstSongObject);
        songList.add(myThirdSongObject);
        System.out.println("Add second song into song list ");

        songList.add(1, mySecondSongObject);
//
//        for (Song currentValue: songList){
//            System.out.println(currentValue);
//        }
//
//        for (int i=0; i<songList.size();i++){
//            System.out.println(songList.get(i));
//        }

        Iterator<Song> iterator=songList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        System.out.println("remove third song");
//        songList.remove(myThirdSongObject);

        System.out.println("finished");

    }
}

