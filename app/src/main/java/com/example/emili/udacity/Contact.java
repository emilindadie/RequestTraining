package com.example.emili.udacity;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by emili on 14/07/2017.
 */

public class Contact implements Serializable {

   private String nom;
   private String email;
    private String genre;

    public Contact(){


    }

    public Contact(String nom, String email, String genre){

        this.nom = nom;
        this.email = email;
        this.genre = genre;
    }

    public void setNom(String nom){

        this.nom = nom;
    }

    public String getNom(){

        return nom;
    }

    public void setEmail(String email){

        this.email = email;
    }

    public String getEmail(){

        return email;
    }

    public void setGenre(String genre){

        this.genre = genre;
    }

    public String getGenre(){

        return genre;
    }

}
