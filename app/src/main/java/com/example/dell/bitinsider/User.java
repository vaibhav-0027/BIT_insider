package com.example.dell.bitinsider;

public class User {
    String name;
    String password;
    String rollnumber;
    String branch;
    String about;

    public User(String name, String password, String rollnumber, String branch, String about) {
        this.name = name;
        this.password = password;
        this.rollnumber = rollnumber;
        this.branch = branch;
        this.about = about;
    }

    public User() {


    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public User(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

