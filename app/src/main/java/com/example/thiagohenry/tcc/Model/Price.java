package com.example.thiagohenry.tcc.Model;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class Price extends RealmObject {
    @SerializedName("id")
    @PrimaryKey
    private Long            id;

    @SerializedName("name")
    private String          name;

    @SerializedName("last_update")
    private String last_update;

    // start getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
