package com.techelevator.model;

import com.techelevator.model.mock.ProfileData;
import com.techelevator.model.mock.SongData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment {

    public static Map<String, List<Song>> createOurData(){
        Map <String, List<Song>> spotfyMap= new HashMap<>();
        Profile firstProfile= ProfileData.getProfile1();
        Profile secondProfile=ProfileData.getProfile2();
        List <Song> playList1= SongData.getPlaylist1();
        List<Song> playlist2=SongData.getPlaylist2();
        String upperUsername=firstProfile.getUsername().toUpperCase();
//        SpotifyMap.put(upperUsername,playList1);
    }
}
