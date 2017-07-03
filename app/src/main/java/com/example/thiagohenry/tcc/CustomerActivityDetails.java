package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class CustomerActivityDetails extends AppCompatActivity {
    private AppCompatActivity act;
    //private TextView search = (EditText) findViewById(R.id.inputSearch);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_details);
        act = this;

        TextView code           = (TextView) findViewById(R.id.code);
        TextView name           = (TextView) findViewById(R.id.name);
        TextView phone_1        = (TextView) findViewById(R.id.phone1);
        TextView fantasy_name   = (TextView) findViewById(R.id.fantasy_name);
        TextView street_name    = (TextView) findViewById(R.id.street_name);
        TextView block_name     = (TextView) findViewById(R.id.block_name);
        TextView city_name      = (TextView) findViewById(R.id.city_name);
        TextView country_name   = (TextView) findViewById(R.id.country_name);


        Bundle extras = getIntent().getExtras();

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Customer> realmQuery = realm.where(Customer.class).equalTo("id", extras.getLong("id"));
        RealmResults<Customer> realmResults = realmQuery.findAll();

        code.setText            (realmResults.get(0).getCode());
        name.setText            (realmResults.get(0).getName());
        phone_1.setText         (realmResults.get(0).getPhone_1());
        fantasy_name.setText    (realmResults.get(0).getFantasy_name());

        CustomerAddress customerAddress = realm.where(CustomerAddress.class).equalTo("customer.id", realmResults.get(0).getId()).findFirst();

        street_name.setText     (customerAddress.getStreet());
        block_name.setText      (customerAddress.getBlock());
        city_name.setText       (customerAddress.getCity());
        country_name.setText    (customerAddress.getCountry());

        String value;
        if (extras != null) {
            value = extras.getString("id");
            System.out.println(value);
        }
    }
}