package com.example.thiagohenry.tcc.Model;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class Product extends RealmObject{
    @SerializedName("id")
    @PrimaryKey
    private Long        id;

    @SerializedName("name")
    private String      name;

    @SerializedName("description")
    private String      description;

    @SerializedName("category")
    private String      category;

    @SerializedName("unity")
    private String      unity;

    @SerializedName("last_update")
    private String        last_update;

    @SerializedName("mark")
    private String      mark;

//    @SerializedName("app_id")
//    private String      app_id;

    // start getters and setters
    public void setId(Long id) {
        this.id = id;
    }

//    public String getApp_id() {
//        return app_id;
//    }
//
//    public void setApp_id(String app_id) {
//        this.app_id = app_id;
//    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

}
