package com.techelevator.dao;

import com.techelevator.model.Campground;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcCampgroundDao implements CampgroundDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCampgroundDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getAllCampgroundsOfPark(Long park_id) {
        List <Campground> campgrounds = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM campground " +
                "WHERE park_id = ?" +
                "LIMIT 5;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,park_id);
        while(results.next()){
            campgrounds.add(mapRowToCampground(results));
        }
        return campgrounds;
    }

    @Override
    public List<Campground> getAllCampgrounds() {
        List <Campground> campgrounds = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM campground " +
                "LIMIT 5;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            campgrounds.add(mapRowToCampground(results));
        }
        return campgrounds;
    }

    private Campground mapRowToCampground(SqlRowSet rowSet) {
        Campground campground = new Campground();

        campground.setCampground_id(rowSet.getLong("campground_id"));
        campground.setPark_id(rowSet.getLong("park_id"));
        campground.setName(rowSet.getString("name"));

        campground.setOpen_from_mm(rowSet.getInt("open_from_mm"));
        campground.setOpen_to_mm(rowSet.getInt("open_to_mm"));

        campground.setDaily_fee(rowSet.getBigDecimal("daily_fee"));

        return campground;
    }
}
