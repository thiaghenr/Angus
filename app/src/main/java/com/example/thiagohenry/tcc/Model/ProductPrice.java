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

public class ProductPrice extends RealmObject {
    @SerializedName("id")
    @PrimaryKey
    private Long                id;

    @SerializedName("product_id")
    private Product             product_id;

    @SerializedName("price_id")
    private Price               price_id;

    @SerializedName("currency")
    private String              currency;

    @SerializedName("value")
    private Double              value;

    @SerializedName("last_update")
    private Date last_update;

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
