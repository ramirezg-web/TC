package com.techelevator.dao;

import com.techelevator.model.Reservation;

import java.util.List;

public interface ReservationDao {

    public List<Reservation> getSitesWithoutReservation();

    public Reservation createReservation(Reservation newReservation);


    public List<Reservation> getSiteByReservation(Long reservationId);



}
