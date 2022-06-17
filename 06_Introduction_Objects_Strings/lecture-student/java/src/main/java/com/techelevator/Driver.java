package com.techelevator;

import com.techelevator.model.Song;

public class Driver {

    public static void main(String[] args) {

        System.out.println("Before creating Song object");
        //create a constructor after New keyword, default with no arguements
        //create instance of a class, instantiated a song object
        //by creatinga n instance of a song class
        Song firstSongObject = new Song();
        firstSongObject.setSongName("BLACK PARADE");
        firstSongObject.setGenre("R&B");
        firstSongObject.setTimeInSeconds(281);

//        Song secondSongObject=new Song("Fever","R&B", 156);
        Song secondSongObject=new Song("BLACK PARADE","R&B", 281);



        System.out.println(firstSongObject);
        System.out.println("Name first song " + firstSongObject.getSongName());
        System.out.println("Second Song " + secondSongObject.getSongName());

        secondSongObject=firstSongObject;
        
        System.out.println("are the songs equal: "+ firstSongObject.equals(secondSongObject));
        System.out.println("are songs == "+ (firstSongObject==secondSongObject));
    }
}
