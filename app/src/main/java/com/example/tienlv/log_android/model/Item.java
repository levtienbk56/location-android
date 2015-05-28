package com.example.tienlv.log_android.model;

public abstract class Item {
    protected String id;
    protected String name;
    protected String description;
    protected String type;
    protected String thumbnail;
    protected String createBy;

    //<editor-fold desc=" ---- constructor ------">

    public Item(){
        id = "";
        name = "";
        description = "";
        type = "";
        thumbnail = "";
        createBy = "";
    }

    protected Item(String id, String name, String description, String type, String thumbnail, String createBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.thumbnail = thumbnail;
        this.createBy = createBy;
    }
    //</editor-fold >

    //<editor-fold desc=" ------ getter & setter ----------">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    //</editor-fold >
}
