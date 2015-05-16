package com.example.tienlv.log_android.model;

/**
 * Created by Tienlv on 5/16/2015.
 */

/**
 * classify into {dish, location}
 * check by "type" att
 */
public class Like {
    private String userId;
    private String abstractId;
    private int mark;

    public Like(){
        userId = "";
        abstractId = "";
        mark = 0;
    }

    public Like(String userId, String abstractId,int mark) {
        this.userId = userId;
        this.abstractId = abstractId;
        this.mark = mark;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
