package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class Request extends RealmObject{
    @PrimaryKey
    private Long id;
    private Customer customer_id;
    private PaymentCondition payment_condition_id;
    private Status status_id;
    private String courier;
    private String currency;
    private String observation;
    private Long value;
    private Long discount;
    private Long value_total;
    private Date request_date;
    private Date last_update;
    //private Integer user_id;
    private String app_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public PaymentCondition getPayment_condition_id() {
        return payment_condition_id;
    }

    public void setPayment_condition_id(PaymentCondition payment_condition_id) {
        this.payment_condition_id = payment_condition_id;
    }

    public Status getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Status status_id) {
        this.status_id = status_id;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getValue_total() {
        return value_total;
    }

    public void setValue_total(Long value_total) {
        this.value_total = value_total;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
