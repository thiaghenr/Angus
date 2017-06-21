package com.example.thiagohenry.tcc.Model;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class ProductStock extends RealmObject {
    @SerializedName("id")
    @PrimaryKey
    private Long                id;

    @SerializedName("product_id")
    private Product             product_id;

    @SerializedName("branch")
    private String              branch;

    @SerializedName("quantity")
    private Integer             quantity;

    @SerializedName("last_update")
    private Date                last_update;

    // start getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
