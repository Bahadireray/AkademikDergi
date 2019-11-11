package com.bahadireray.dergilik.model;

public class Article {
    private int id;
    private String title;
    private String explanation;
    private String text;
    private String path;
    private Users users;

    public Article(int id, String title, String explanation, String text, String path, Users users) {
        this.id = id;
        this.title = title;
        this.explanation = explanation;
        this.text = text;
        this.path = path;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
