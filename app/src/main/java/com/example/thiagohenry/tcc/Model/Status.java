package com.example.thiagohenry.tcc.Model;

import io.realm.RealmObject;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class Status extends RealmObject {
    private Long id;
    private String description;

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
