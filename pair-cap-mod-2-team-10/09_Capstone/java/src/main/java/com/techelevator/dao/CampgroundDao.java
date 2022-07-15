package com.techelevator.dao;

import com.techelevator.model.Campground;
import com.techelevator.model.Park;

import java.util.List;

public interface CampgroundDao {
    public List<Campground> getAllCampgroundsOfPark(Long park_id);
    public List<Campground> getAllCampgrounds();
}
