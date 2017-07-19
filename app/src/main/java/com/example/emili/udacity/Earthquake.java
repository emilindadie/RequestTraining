package com.example.emili.udacity;

/**
 * Created by emili on 12/07/2017.
 */

class Earthquake {

    private double magnitude;
    String location;
    long timeInMilliseconds;


    public Earthquake(){


    }
    public Earthquake(double magnitude, String location, long timeInMilliseconds){

        this.magnitude = magnitude;
        this.location = location;
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public void setMagnitude(double magnitude){

        this.magnitude = magnitude;
    }

    public double getMagnitude(){
        return  magnitude;
    }

    public void setLocation(String location){

        this.location = location;
    }

    public String getLocation(){
        return  location;
    }

    public void setTimeInMilliseconds(long timeInMilliseconds){

        this.timeInMilliseconds = timeInMilliseconds;
    }

    public long getTime(){
        return  timeInMilliseconds;
    }


}
