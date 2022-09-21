package com.example;

public class Dvd {
    private String title;
    private String date;
    private double rating;
    private String directorName;
    private String userNote;

    public String getTitle(){
        return this.title;
    }

    public String setTitle(String title){
        return this.title = title;
    }

    public String getDate(){
        return this.date;
    }

    public String setDate(String date){
        return this.date = date;
    }

    public double getRating(){
        return this.rating;
    }

    public double setRating(double rating){
        return this.rating = rating;
    }

    public String getDirector(){
        return this.directorName;
    }

    public String setDirector(String director){
        return this.directorName = director;
    }

    public String getUserNote(){
        return this.userNote;
    }

    public String setUserNote(String director){
        return this.userNote = director;
    }

    public void setData(String title, String date, String rating, String directorName, String note){
        this.title = title;
        this.date = date;
        this.rating = Double.parseDouble(rating);
        this.directorName = directorName;
        this.userNote = note;
    }

    public String getData(){
        return "Title: " + this.title + ", Date: " + this.date + ", Rating: " + this.rating + ", DirectorName: " + this.directorName + ", Note: " + this.userNote;
    }
}
