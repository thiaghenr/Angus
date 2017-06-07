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
    private Long id;
    private Price   price_id;
    private Request request_id;
    private RealmList<Product> product_id;
    private Long quantity;
    private Long invoiced_amount;
    private Long discount;
    private Long value_unit;
    private Long value_total;
    private String observation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Price getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Price price_id) {
        this.price_id = price_id;
    }

    public Request getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Request request_id) {
        this.request_id = request_id;
    }

    public RealmList<Product> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(RealmList<Product> product_id) {
        this.product_id = product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getInvoiced_amount() {
        return invoiced_amount;
    }

    public void setInvoiced_amount(Long invoiced_amount) {
        this.invoiced_amount = invoiced_amount;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getValue_unit() {
        return value_unit;
    }

    public void setValue_unit(Long value_unit) {
        this.value_unit = value_unit;
    }


    public Long getValue_total() {
        return value_total;
    }

    public void setValue_total(Long value_total) {
        this.value_total = value_total;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
