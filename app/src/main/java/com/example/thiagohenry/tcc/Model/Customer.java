package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class Customer extends RealmObject{
    @SerializedName("id")
    @PrimaryKey
    @Required
    private Long                id;

    @SerializedName("code")
    @Required
    private String              code;

    @SerializedName("name")
    @Required
    private String              name;

    @SerializedName("fantasy_name")
    private String              fantasy_name;

    @SerializedName("ruc")
    private String              ruc;

    @SerializedName("currency")
    private String              currency;

    @SerializedName("email")
    private String              email;

    @SerializedName("phone_1")
    private String              phone_1;

    @SerializedName("phone_2")
    private String              phone_2;

    @SerializedName("app_id")
    private String              app_id;

    @SerializedName("last_update")
    private Date                last_update;

    // start getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    //    public Date getLast_update() {
//        return last_update;
//    }
//
//    public void setLast_update(Date last_update) {
//        this.last_update = last_update;
//    }

}
