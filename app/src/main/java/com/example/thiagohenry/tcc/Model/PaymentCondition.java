package com.example.thiagohenry.tcc.Model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thiagohenry on 13/05/17.
 */

public class PaymentCondition extends RealmObject {
    @PrimaryKey
    private Long                id;
    private String              group_num;
    private String              description;
    private int                 payment_quantity;
    private Date                last_update;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_num() {
        return group_num;
    }

    public void setGroup_num(String group_num) {
        this.group_num = group_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPayment_quantity() {
        return payment_quantity;
    }

    public void setPayment_quantity(int payment_quantity) {
        this.payment_quantity = payment_quantity;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
