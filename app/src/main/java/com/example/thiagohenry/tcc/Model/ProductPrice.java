package com.example.thiagohenry.tcc.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class ProductPrice extends RealmObject {
    @PrimaryKey
    private Long                id;
    private Product             product_id;
    private Price               price_id;
    private String              currency;
    private Double              value;
    private Date last_update;

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

    public Price getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Price price_id) {
        this.price_id = price_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
