package com.example.thiagohenry.tcc.Model;

import android.app.DownloadManager;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 23/04/17.
 */

public class RequestItem extends RealmObject{
    @SerializedName("id")
    @PrimaryKey
    private Long        id;

    @SerializedName("request_id")
    private Request     request_id;

    @SerializedName("product")
    private Product     product;

    @SerializedName("quantity")
    private Double      quantity;

    @SerializedName("value_total")
    private Double      value_total;

    // start getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Request request_id) {
        this.request_id = request_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getValue_total() {
        return value_total;
    }

    public void setValue_total(Double value_total) {
        this.value_total = value_total;
    }
}
