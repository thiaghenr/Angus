package com.example.thiagohenry.tcc.Model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class StatusHistoric extends RealmObject {
    private Long id;
    private Status Status;
    private Request Request;
    private Date date_event;
    private String Source_event;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.example.thiagohenry.tcc.Model.Status getStatus() {
        return Status;
    }

    public void setStatus(com.example.thiagohenry.tcc.Model.Status status) {
        Status = status;
    }

    public com.example.thiagohenry.tcc.Model.Request getRequest() {
        return Request;
    }

    public void setRequest(com.example.thiagohenry.tcc.Model.Request request) {
        Request = request;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public String getSource_event() {
        return Source_event;
    }

    public void setSource_event(String source_event) {
        Source_event = source_event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
