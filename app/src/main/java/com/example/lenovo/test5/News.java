package com.example.lenovo.test5;

import java.util.Date;

public class News {
    private String title;
    private String time;
    private String author;
    private int photos;

    public News(String title,String time,String author,int photos){
        this.title = title;
        this.time =  time;
        this.author = author;
        this.photos = photos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPhotos() {
        return photos;
    }

    public void setPhotos(int photos) {
        this.photos = photos;
    }
}
