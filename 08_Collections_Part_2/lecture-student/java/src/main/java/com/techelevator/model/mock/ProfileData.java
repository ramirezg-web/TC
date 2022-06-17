package com.techelevator.model.mock;

import com.techelevator.model.Profile;

public class ProfileData {
    public static Profile getProfile1(){
        return new Profile("userProfile1", "Gentle", "Ramirez");

    }
    public static Profile getProfile2(){
        return new Profile("userProfile2", "Jentil", "Reyez");

    }

}
