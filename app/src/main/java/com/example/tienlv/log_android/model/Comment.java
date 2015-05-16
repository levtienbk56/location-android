package com.example.tienlv.log_android.model;

/**
 * Created by Tienlv on 5/16/2015.
 */


/**
 * classify into {dish, location}
 * check by "type" att
 */
public class Comment {
    private String userId;
    private String abstractId;
    private String time;
    private String content;

    public Comment(){
        userId = "";
        abstractId = "";
        time = "";
        content = "";
    }

    public Comment(String userId, String abstractId, String time, String content) {
        this.userId = userId;
        this.abstractId = abstractId;
        this.time = time;
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAbstractId() {
        return abstractId;
    }

    public void setAbstractId(String abstractId) {
        this.abstractId = abstractId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
