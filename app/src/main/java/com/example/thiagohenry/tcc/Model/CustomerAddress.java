package com.example.thiagohenry.tcc.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 27/04/17.
 */

public class CustomerAddress extends RealmObject{
    @SerializedName("id")
    @PrimaryKey
    private Long       id;

    @SerializedName("customer")
    private Customer   customer;

    @SerializedName("street")
    private String     street;

    @SerializedName("number")
    private Integer    number;

    @SerializedName("block")
    private String     block;

    @SerializedName("city")
    private String     city;

    @SerializedName("state")
    private String     state;

    @SerializedName("country")
    private String     country;

    @SerializedName("type")
    private String     type;

    @SerializedName("last_update")
    private String last_update;

//    @SerializedName("app_id")
//    private String     app_id;

    // start getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

//    public String getApp_id() {
//        return app_id;
//    }
//
//    public void setApp_id(String app_id) {
//        this.app_id = app_id;
//    }
}
