package com.example.suneh.sqlitelab7;

/**
 * Created by suneh on 4/8/2018.
 */

public class Book
{


    public int id;
    public int rating;
    public String title;
    public String author;

    Book() {
    }

    Book(String title, String author,int rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\t\t\t Book [id = " + getId() + ",rating = " + getRating() + ",title = " + getTitle() + ",author = " + getAuthor() + "]";

    }

}


