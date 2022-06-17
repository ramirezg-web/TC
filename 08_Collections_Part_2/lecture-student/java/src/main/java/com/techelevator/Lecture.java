package com.techelevator;

import com.techelevator.model.Profile;
import com.techelevator.model.Song;
import com.techelevator.model.mock.ProfileData;
import com.techelevator.model.mock.SongData;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		Map<String, List<Song>> demoSpotifyMap= Lecture.createOurData();

		System.out.println("enter your username: ");
		String usernameInput=scanner.nextLine();

		List <Song> userPlaylist= demoSpotifyMap.get(usernameInput);

		System.out.println("Playlist for Username: "+usernameInput);
		for(Song currentValue: userPlaylist){
			System.out.println(currentValue);
		}


	}
	public static Map<String, List<Song> > createOurData() {
		Map<String, List<Song>> spotifyMap= new HashMap<>();
		Profile firstProfile= ProfileData.getProfile1();
		Profile secondProfile=ProfileData.getProfile2();

		List<Song> playlist1=SongData.getPlaylist1();
		List<Song> playlist2=SongData.getPlaylist2();

		spotifyMap.put(firstProfile.getUsername(), playlist1);
		spotifyMap.put(secondProfile.getUsername(),playlist2);

		return spotifyMap;

		}



//		List<Song> songList= SongData.getPlaylist1();
//		for(Song currentValue: songList){
//			System.out.println(currentValue.getSongName());
//		}
//
//		SongList.get(0).setGenre("new genre");
//		System.out.println(songList.get(0));
//
//
//		System.out.println("####################");
//		System.out.println("        MAPS");
//		System.out.println("####################");
//		System.out.println();


	}


