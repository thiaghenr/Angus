package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class Venda {
    private Integer id;
    private Integer client_id;
    private Integer payment_condition_id;
    private Integer status_id;
    private String courier;
    private String currency;
    private String observation;
    private Long value; //FIELD VALOR
    private Long discount;
    private Long value_total;
    private Long value_total_invoiced;
    private String status_erp;
    private Date request_date;
    private DateTimeKeyListener last_update;
    private Integer user_id;
    private Integer app_id;
    private Float mobile_version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getPayment_condition_id() {
        return payment_condition_id;
    }

    public void setPayment_condition_id(Integer payment_condition_id) {
        this.payment_condition_id = payment_condition_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
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

    public Long getValue_total_invoiced() {
        return value_total_invoiced;
    }

    public void setValue_total_invoiced(Long value_total_invoiced) {
        this.value_total_invoiced = value_total_invoiced;
    }

    public String getStatus_erp() {
        return status_erp;
    }

    public void setStatus_erp(String status_erp) {
        this.status_erp = status_erp;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public DateTimeKeyListener getLast_update() {
        return last_update;
    }

    public void setLast_update(DateTimeKeyListener last_update) {
        this.last_update = last_update;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public Float getMobile_version() {
        return mobile_version;
    }

    public void setMobile_version(Float mobile_version) {
        this.mobile_version = mobile_version;
    }
}
