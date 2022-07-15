package com.techelevator.dao;

import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcSiteDao implements SiteDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Site mapRowToSite(SqlRowSet rowSet) {
        Site site = new Site();
        site.setSite_id(rowSet.getLong("site_id"));
        site.setCampground_id(rowSet.getLong("campground_id"));
        site.setSite_number(rowSet.getInt("site_number"));
        site.setMax_occupancy(rowSet.getInt("max_occupancy"));
        site.setAccessible(rowSet.getBoolean("accessible"));
        site.setMax_rv_length(rowSet.getInt("max_rv_length"));
        site.setUtilities(rowSet.getBoolean("utilities"));
        return site;
    }



    @Override
    public List<Site> getAvailableSites(Long camp_id, LocalDate user_from_date, LocalDate user_to_date) {

        List <Site> campgrounds = new ArrayList<>();
        String sql = "SELECT DISTINCT * " +
                "FROM site " +
                "WHERE campground_id = ? AND (site.site_id NOT IN (SELECT DISTINCT site_id FROM reservation)) " +
                "OR (site.site_id IN (select site_id FROM reservation) AND  (site.site_id NOT IN (SELECT DISTINCT site_id FROM reservation WHERE from_date <= ? AND to_date >= ?)))"+
                "ORDER BY site_number ASC "+
                "LIMIT 5;";


        //prompt says that a campsite is unavailable if any part of their preferred date range overlaps with an existing reservation

        //we want user to be able to reserve a site that is NOT in the reservation table
        // OR if it IS in the reservation table, allow reservation if their preferred date is OK

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,camp_id,user_from_date,user_to_date);

        while(results.next()){
            campgrounds.add(mapRowToSite(results));
        }

        return campgrounds;

    }

}