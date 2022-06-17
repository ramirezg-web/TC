package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
//    private int availableFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;
//    private int availableCoachSeats;

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }


//    public int availableCoachSeats(){
//        return totalCoachSeats-bookedCoachedSeats;
//    }
//    public int availableFirstClassSeats(){
//        return totalFirstClassSeats-bookedFirstClassSeats;
//    }
    public int getAvailableFirstClassSeats() {
        return this.totalFirstClassSeats-this.bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return this.totalCoachSeats-this.bookedCoachSeats;
    }



    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
//        if(forFirstClass==true){
//            totalNumberOfSeats+=bookedFirstClassSeats;
//        }
//        if (forFirstClass==false){
//            bookedCoachedSeats+=totalNumberOfSeats;
//        }
//        return true;
        if (forFirstClass){
            if (totalNumberOfSeats>getAvailableFirstClassSeats()){
                return false;
            }
            bookedFirstClassSeats+=totalNumberOfSeats;
        } else{
            if(totalNumberOfSeats> getAvailableCoachSeats()){
                return false;
            }
            bookedCoachSeats+=totalNumberOfSeats;
        }
        return true;
    }
}
