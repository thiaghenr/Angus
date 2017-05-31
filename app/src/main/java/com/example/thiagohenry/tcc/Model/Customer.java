package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class Customer extends RealmObject{
    @PrimaryKey
    private Long                id;
    @Index
    private String              code;
    private Price               price_id;
    @Index
    private String              name;
    private String              fantasy_name;
    private String              ruc;
    private String              currency;
    private String              contact;
    @Index
    private String              phone_1;
    private String              phone_2;
    private Integer             seller_id;
    private String              app_id;
    //private SimpleDateFormat    last_update;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String erp_id) {
        this.app_id = app_id;
    }

    public Price getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Price price_id) {
        this.price_id = price_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFantasy_name() {
        return fantasy_name;
    }

    public void setFantasy_name(String fantasy_name) {
        this.fantasy_name = fantasy_name;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone_1() {
        return phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

//    public SimpleDateFormat getLast_update() {
//        return last_update;
//    }
//
//    public void setLast_update(SimpleDateFormat last_update) {
//        this.last_update = last_update;
//    }

}
