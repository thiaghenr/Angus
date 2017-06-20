package com.example.thiagohenry.tcc.Model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 16/06/17.
 */

public class User extends RealmObject {
    @SerializedName("id")
    @PrimaryKey
    @Required
    private Long   id;

    @SerializedName("name")
    @Required
    private String name;

    @SerializedName("lastName")
    @Required
    private String lastName;

    @SerializedName("username")
    @Required
    private String username;

    @SerializedName("password")
    @Required
    private String password;

    @SerializedName("confirmPassword")
    @Required
    private String confirmPassword;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
