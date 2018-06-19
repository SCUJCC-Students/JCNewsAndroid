package com.example.lenovo.test5;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends DataSupport implements Serializable {
    private static final long serialVersionUID = 1212121L;

    private int head;
    private String email;
    private String name;
    private String password;
    private List<Share> shareList = new ArrayList<>();

    public User(int head, String name) {
        this.head = head;
        this.name = name;
    }

    public User(){

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Share> getShareList() {
        return shareList;
    }

    public void setShareList(List<Share> shareList) {
        this.shareList = shareList;
    }
}
