package com.example.lenovo.test5;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class Share extends DataSupport implements Serializable {
    private static final long serialVersionUID = 1847583745983459834L;

    private int imageId;
    private String title;
    private User user;
    private String content;


    public Share(int imageId, String title, User user, String content) {
        this.imageId = imageId;
        this.title = title;
        this.user = user;
        this.content = content;
    }

    public Share(){

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
