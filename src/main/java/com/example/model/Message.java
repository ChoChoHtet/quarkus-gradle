package com.example.model;

public class Message {
    private String msg;
    private String source;

    private String date;
    public Message(String msg,String source){
        this.msg = msg;
        this.source = source;
    }
    public Message(String msg,String source,String date){
        this.msg = msg;
        this.source = source;
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
