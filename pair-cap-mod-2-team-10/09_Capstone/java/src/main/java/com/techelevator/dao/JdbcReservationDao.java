package com.techelevator.dao;

import com.techelevator.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcReservationDao implements ReservationDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Reservation> getSitesWithoutReservation() {
        List<Reservation> reservations=new ArrayList<>();
        String sql= "SELECT * FROM reservation left join site_id on reservation.site_id=site.site_id where site_id IS NULL ";
        SqlRowSet results=jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            reservations.add(mapRowToReservation(results));
        }
        return reservations;
    }

    @Override
    public List<Reservation> getSiteByReservation(Long reservationId) {
        return null;
    }

    @Override
    public Reservation createReservation(Reservation newReservation) {
        String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING reservation_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
               newReservation.getSite_id(), newReservation.getName(), newReservation.getFrom_date(), newReservation.getTo_date(), newReservation.getCreate_date());

        return getReservation(newId);
    }

    private Reservation getReservation(Long reservation_id){
        Reservation reservation = null;
        String sql = "SELECT * " +
                "FROM reservation " +
                "WHERE reservation_id = ? "+
                "LIMIT 5;";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql, reservation_id);
        while (results.next()) {
            reservation = mapRowToReservation(results);
        }
        return reservation;
    }

    private Reservation mapRowToReservation(SqlRowSet rowSet) {
        Reservation reservation = new Reservation();
        reservation.setReservation_id(rowSet.getLong("reservation_id"));
        reservation.setSite_id(rowSet.getLong("site_id"));
        reservation.setName(rowSet.getString("name"));

        reservation.setFrom_date(rowSet.getDate("from_date").toLocalDate());
        reservation.setTo_date(rowSet.getDate("to_date").toLocalDate());
        reservation.setCreate_date(rowSet.getDate("create_date").toLocalDate());

        return reservation;
    }
}
