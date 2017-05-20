package com.example.thiagohenry.tcc.Model;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class Request extends RealmObject{
    private Long id;
    private Customer customer_id;
    private PaymentCondition payment_condition_id;
    private Status status_id;
    private String courier;
    private String currency;
    private String observation;
    private Long value; //FIELD VALOR
    private Long discount;
    private Long value_total;
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
