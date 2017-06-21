package com.example.thiagohenry.tcc.Model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class Status extends RealmObject {
    @SerializedName("id")
    @PrimaryKey
    private Long id;

    @SerializedName("description")
    private String description;

    // start getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
