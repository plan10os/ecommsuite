package com.ltmg;
public class Message {

    private final String author;
    private final String body;

    public Message(String author, String body) {
        this.author = author;
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

}