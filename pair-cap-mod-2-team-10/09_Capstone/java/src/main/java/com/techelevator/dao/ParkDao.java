package com.techelevator.dao;
import com.techelevator.model.Park;
import java.util.List;

public interface ParkDao {
    public List<Park> getAllAvailableParks();
    //public List<Park> getAllParks();
}
