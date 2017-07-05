package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;
import com.example.thiagohenry.tcc.Model.Status;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class RequestActivityDetails extends AppCompatActivity {
    private AppCompatActivity act;
    //private TextView search = (EditText) findViewById(R.id.inputSearch);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_details);
        act = this;

        TextView customer       = (TextView) findViewById(R.id.customer);
        TextView status         = (TextView) findViewById(R.id.status);
        TextView due_date       = (TextView) findViewById(R.id.due_date);
        TextView value_total    = (TextView) findViewById(R.id.value_total);

        ListView price_list     = (ListView) findViewById(R.id.list_product_cart);

        Bundle extras = getIntent().getExtras();
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Request> realmQuery      = realm.where(Request.class).equalTo("id", extras.getLong("id"));
        RealmResults<Request> realmResults  = realmQuery.findAll();

        Customer customer1  = realmResults.get(0).getCustomer_id();
        Status   status1    = realmResults.get(0).getStatus_id();

        customer.setText    (customer1.getName());
        status.setText      (status1.getDescription());
        due_date.setText    (realmResults.get(0).getDue_date().toString());
        value_total.setText (realmResults.get(0).getValue_total().toString());

        RealmQuery<RequestItem>     requestItemRealmQuery       = realm.where(RequestItem.class).equalTo("request_id.id", realmResults.get(0).getId());
        RealmResults<RequestItem>   requestItemRealmResults     = requestItemRealmQuery.findAll();

        RequestAdapterCartDetails adapter_price = new RequestAdapterCartDetails(requestItemRealmResults, act);
        price_list.setAdapter(adapter_price);
    }
}