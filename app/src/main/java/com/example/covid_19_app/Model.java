package com.example.covid_19_app;

public class Model {

        String title;
        String description;
        String date1;
        String id;

    public Model(String id, String title, String description, String date1) {
        this.title = title;
        this.description = description;
        this.date1 = date1;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
