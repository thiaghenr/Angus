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
}
