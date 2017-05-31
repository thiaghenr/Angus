package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

import io.realm.RealmObject;
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
    @Index
    @Required
    private String currency;
    private String observation;
    private Long value; //FIELD VALOR
    private Long discount;
    @Index
    @Required
    private Long value_total;
    @Index
    @Required
    private Long value_total_invoiced;
    private String erp_error_code;
    private String erp_error_message;
    private String status_erp;
    private Date request_date;
    //private DateTimeKeyListener last_update;
    //private Integer user_id;
    private String app_id;
    private Float mobile_version;


}
