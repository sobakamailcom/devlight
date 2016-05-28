package com.loid.devlighttaskmanager.models;

/**
 * Created by LOID on 28.05.2016.
 */
public class Task {

    String title;
    String comment;

    public Task(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getName() {
        return title;
    }

    public String getComment() {
        return comment;
    }
}
