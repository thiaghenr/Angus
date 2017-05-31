package com.example.thiagohenry.tcc;

import android.widget.EditText;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;

import io.realm.Realm;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class CustomerActivityHelper {

    private final TextView campoCode;
    private final TextView campoName;
    private final TextView campoFantasyName;
    private final TextView campoPhone1;


    public CustomerActivityHelper(CustomerCreateActivity customerCreateActivity) {
        campoCode           = (TextView) customerCreateActivity.findViewById(R.id.code);
        campoName           = (TextView) customerCreateActivity.findViewById(R.id.name);
        campoFantasyName    = (TextView) customerCreateActivity.findViewById(R.id.fantasy_name);
        campoPhone1         = (TextView) customerCreateActivity.findViewById(R.id.phone);
    }

    public CustomerActivityHelper(CustomerActivityList customerActivityList) {
        campoCode           = (TextView) customerActivityList.findViewById(R.id.code);
        campoName           = (TextView) customerActivityList.findViewById(R.id.name);
        campoFantasyName    = (TextView) customerActivityList.findViewById(R.id.fantasy_name);
        campoPhone1         = (TextView) customerActivityList.findViewById(R.id.phone);

        EditText fieldSearch = (EditText) customerActivityList.findViewById(R.id.inputSearch);
    }

    public Customer pegaCustomer() {
        Customer customer = new Customer();

        customer.setId           ((long) getNextKey(customer));
        customer.setCode         (campoCode.getText().toString());
        customer.setName         (campoName.getText().toString());
        customer.setFantasy_name (campoFantasyName.getText().toString());
        customer.setPhone_1      (campoPhone1.getText().toString());

        return customer;
    }

    private int getNextKey(Customer customer) {
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(Customer.class).max("id") == null){
            return 1;
        } else {
            return realm.where(customer.getClass()).max("id").intValue() + 1;
        }
    }
}



