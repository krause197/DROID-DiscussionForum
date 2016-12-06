package com.epicodus.discussionforum.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Guest on 12/6/16.
 */
public class Message {
    private String title;
    private String content;
    private String author;
//    private Date date;
//    List<String> categories = new ArrayList<>();

    public Message(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
//        this.date = new Date();
//        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public List<String> getCategories() {
//        return categories;
//    }
}
