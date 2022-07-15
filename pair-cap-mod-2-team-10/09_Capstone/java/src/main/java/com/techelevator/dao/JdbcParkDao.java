package com.techelevator.dao;

import com.techelevator.model.Park;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcParkDao implements ParkDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getAllAvailableParks() {
        List <Park> parks = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM park " +
                "ORDER BY name " +
                "LIMIT 5";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            parks.add(mapRowToPark(results));
        }

        return parks;
    }

    private String name;
    private String location;
    private LocalDate establish_date;
    private int area;
    private int visitors;
    private String description;

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setPark_id(rowSet.getLong("park_id"));
        park.setName(rowSet.getString("name"));
        park.setLocation(rowSet.getString("location"));

        LocalDate establish_date = rowSet.getDate("establish_date").toLocalDate();
        park.setEstablish_date(establish_date);

        park.setArea(rowSet.getInt("area"));
        park.setVisitors(rowSet.getInt("visitors"));
        park.setDescription(rowSet.getString("description"));

        return park;
    }



}
