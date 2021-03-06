package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.annotations.Index;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class Request extends RealmObject{
    @SerializedName("id")
    @PrimaryKey
    private Long                id;

    @SerializedName("customer_id")
    private Customer            customer_id;

    @SerializedName("status_id")
    private Status              status_id;

    @SerializedName("currency")
    private String              currency;

    @SerializedName("due_date")
    private Date                due_date;

    @SerializedName("observation")
    private String              observation;

    @SerializedName("value_total")
    private Double              value_total;

    @SerializedName("last_update")
    private Date                last_update;

    @SerializedName("user_id")
    private User                user_id;

    @SerializedName("sync")
    private Integer             sync;

    @SerializedName("app_id")
    private String              app_id;

    // start getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Status getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Status status_id) {
        this.status_id = status_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Double getValue_total() {
        return value_total;
    }

    public void setValue_total(Double value_total) {
        this.value_total = value_total;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Integer getSync() {
        return sync;
    }

    public void setSync(Integer sync) {
        this.sync = sync;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
