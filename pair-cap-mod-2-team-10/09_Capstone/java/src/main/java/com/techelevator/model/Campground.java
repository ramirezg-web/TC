package com.techelevator.model;

import java.math.BigDecimal;

public class Campground {
    private long campground_id;
    private long park_id;
    private String name;
    private int open_from_mm;
    private int open_to_mm;
    private BigDecimal daily_fee;

    public long getCampground_id() {
        return campground_id;
    }

    public void setCampground_id(long campground_id) {
        this.campground_id = campground_id;
    }

    public long getPark_id() {
        return park_id;
    }

    public void setPark_id(long park_id) {
        this.park_id = park_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOpen_from_mm() {
        return open_from_mm;
    }

    public void setOpen_from_mm(int open_from_mm) {
        this.open_from_mm = open_from_mm;
    }

    public int getOpen_to_mm() {
        return open_to_mm;
    }

    public void setOpen_to_mm(int open_to_mm) {
        this.open_to_mm = open_to_mm;
    }

    public BigDecimal getDaily_fee() {
        return daily_fee;
    }

    public void setDaily_fee(BigDecimal daily_fee) {
        this.daily_fee = daily_fee;
    }

    public String getOpenMonth() {
        return convertMM(this.open_from_mm);
    }

    public String getCloseMonth(){
        return convertMM(this.open_to_mm);
    }

    public String convertMM(int mm){
            if(mm == 1){
                return "January";
            }
            else if(mm == 2){
                return "February";
            }
            else if(mm == 3){
                return "March";
            }
            else if(mm == 4){
                return "April";
            }
            else if(mm == 5){
                return "May";
            }
            else if(mm == 6){
                return "June";
            }
            else if(mm == 7){
                return "July";
            }
            else if(mm == 8){
                return "August";
            }
            else if(mm == 9){
                return "September";
            }
            else if(mm == 10){
                return "October";
            }
            else if (mm == 11){
                return "November";
            }
            else if(mm == 12){
                return "December";
            }
            else return "NOT VALID MONTH";
        }



    public Campground(){

    }

    public Campground(long campground_id, long park_id, String name, int open_from_mm, int open_to_mm, BigDecimal daily_fee) {
        this.campground_id = campground_id;
        this.park_id = park_id;
        this.name = name;
        this.open_from_mm = open_from_mm;
        this.open_to_mm = open_to_mm;
        this.daily_fee = daily_fee;
    }
}
