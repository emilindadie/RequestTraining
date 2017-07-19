package com.example.emili.udacity;

/**
 * Created by emili on 18/07/2017.
 */

public class World {

    private static final int NO_IMAGE = -1;
    int imageResourceId = NO_IMAGE;
    String firstString;
    String secondString;



    public World(String firstString, String secondString){

        this.firstString = firstString;
        this.secondString = secondString;

    }

    public World(String firstString, String secondString, int imageResourceId){

        this.firstString = firstString;
        this.secondString = secondString;
        this.imageResourceId = imageResourceId;

    }


    public String getFirstString(){
        return firstString;
    }

    public String getSecondString(){
        return secondString;
    }

    public int getImageRousourceId(){

        return imageResourceId;
    }

    public  boolean hasImage(){
        return imageResourceId != NO_IMAGE;
    }



}
