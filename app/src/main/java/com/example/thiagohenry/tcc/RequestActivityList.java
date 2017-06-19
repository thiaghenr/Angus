package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.Status;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class RequestActivityList extends AppCompatActivity{
    private AppCompatActivity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_search_request, menu);
        act = this;

        Button new_request = (Button) findViewById(R.id.new_request);
        new_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_form = new Intent(RequestActivityList.this, RequestCreateActivity.class);
                startActivity(go_to_form);
            }
        });

        loadRequests();

        return super.onCreateOptionsMenu(menu);
    }

    public void loadRequests() {

        final TextView search               = (EditText)    findViewById(R.id.inputSearch);
        final Switch filter_by_status       = (Switch)      findViewById(R.id.filter_by_status);
        final Switch filter_by_customer     = (Switch)      findViewById(R.id.filter_by_customer);
        final Switch filter_by_value        = (Switch)      findViewById(R.id.filter_by_value);

        filter_by_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    filter_by_customer.setChecked(false);
                    filter_by_value.setChecked(false);
                }
            }
        });

        filter_by_customer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked == true){
                    filter_by_status.setChecked(false);
                    filter_by_value.setChecked(false);
                }
            }
        });

        filter_by_value.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked == true){
                    filter_by_status.setChecked(false);
                    filter_by_customer.setChecked(false);
                }
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (filter_by_status.isChecked() == true){
                    Realm realm                         = Realm.getDefaultInstance();
                    RealmQuery<Request> requestRealmQuery   = realm.where(Request.class);
                    requestRealmQuery.contains("status_id.description", String.valueOf(search.getText()));

                    final RealmResults<Request> requestRealmResults = requestRealmQuery.findAll();
                    final ListView ListRequest                      = (ListView) findViewById(R.id.request_list);

                    RequestAdapter adapter = new RequestAdapter(requestRealmResults, act);
                    ListRequest.setAdapter(adapter);
                }
                else if (filter_by_customer.isChecked() == true){
                    Realm realm                             = Realm.getDefaultInstance();
                    RealmQuery<Request> requestRealmQuery   = realm.where(Request.class);

                    requestRealmQuery.contains("customer_id.name", String.valueOf(search.getText()));

                    final RealmResults<Request> requestRealmResults = requestRealmQuery.findAll();
                    final ListView ListRequest                      = (ListView) findViewById(R.id.request_list);

                    RequestAdapter adapter  = new RequestAdapter(requestRealmResults, act);
                    ListRequest.setAdapter(adapter);
                }
//                else if (filter_by_value.isChecked() == true){
//                    Realm realm                 = Realm.getDefaultInstance();
//                    RealmQuery<Customer> query  = realm.where(Customer.class);
//
//                    query.contains("phone_1", String.valueOf(search.getText()));
//                    final RealmResults<Customer> result1 = query.findAll();
//                    final ListView ListCustomers = (ListView) view.findViewById(R.id.customer_list);
//
//                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, getActivity());
//                    ListCustomers.setAdapter(adapter);
//
//                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//                            Intent act_cust = new Intent(getActivity(), RequestCreateActivity.class);
//                            Bundle bundle = new Bundle();
//                            bundle.putLong("id", result1.get(position).getId());
//                            bundle.putString("fragment", "customer");
//                            act_cust.putExtras(bundle);
//                            startActivity(act_cust);
//                        }
//                    });
//                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
                //Toast.makeText(act, "beforechanged", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Toast.makeText(act, "afterchanged", Toast.LENGTH_SHORT).show();
                //search.setError(null);
            }
        });
    }

}
