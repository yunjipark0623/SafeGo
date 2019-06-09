package com.example.fragmenttest.vo;

public class CommentList {
    private String time;
    private String contents;

    public CommentList(String[] contents) {
        this.contents = contents[0];
        this.time = contents[2].substring(0,contents[2].length()-2);
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
