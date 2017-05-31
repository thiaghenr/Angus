package com.example.thiagohenry.tcc.Model;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thiagohenry on 27/04/17.
 */

public class CustomerAddress extends RealmObject{
    @PrimaryKey
    private Long       id;
    private Customer   Customer_id;
    private String     address;
    private String     street;
    private String     block;
    private String     city;
    private String     state;
    private String     country;
    private String     type;
    //private Date     last_update;
    private String       app_id;

//    public Long getApp_id() {
//        return app_id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(Customer Customer_id) {
        this.Customer_id = Customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }
}
