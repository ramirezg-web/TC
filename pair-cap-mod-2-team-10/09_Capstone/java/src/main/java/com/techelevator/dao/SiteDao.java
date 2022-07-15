package com.techelevator.dao;

import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SiteDao {

    public List<Site> getAvailableSites(Long camp_id,LocalDate userFromDate, LocalDate userToDate);
}
