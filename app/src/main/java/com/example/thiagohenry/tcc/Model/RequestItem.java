package com.example.thiagohenry.tcc.Model;

import android.app.DownloadManager;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 23/04/17.
 */

public class RequestItem extends RealmObject{
    @PrimaryKey
    private Long        id;
    private Request     request_id;
    private Product     product_id;
    private Double      quantity;
    private Double      value_total;

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

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
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
