package com.example.thiagohenry.tcc.Model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class Payment extends RealmObject {
    @PrimaryKey
    private Long                id;
    private Customer            customer_id;
    private Request             request;
    private int                 type;
    private int                 parcel;
    private Date                release_date;
    private Date                due_date;
    private int                 doc_number;
    private float               value;
    private float               amount_received;
    private Date                last_update;
    private boolean             is_paid;
    private float               balance;

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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getParcel() {
        return parcel;
    }

    public void setParcel(int parcel) {
        this.parcel = parcel;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public int getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(int doc_number) {
        this.doc_number = doc_number;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getAmount_received() {
        return amount_received;
    }

    public void setAmount_received(float amount_received) {
        this.amount_received = amount_received;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public boolean is_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
