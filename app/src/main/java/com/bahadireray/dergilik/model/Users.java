package com.bahadireray.dergilik.model;

public class Users {
    private int   id;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private String university;
    private String userType;
    private String tc;
    private String passportNo;
    private String keywords;

    public Users(String name, String surname, String mail, String password, String university, String userType) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.university = university;
        this.userType = userType;
    }

    public Users(int id, String name, String surname, String mail, String password, String university, String userType, String tc, String passportNo, String keywords) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.university = university;
        this.userType = userType;
        this.tc = tc;
        this.passportNo = passportNo;
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
