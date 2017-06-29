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
import com.example.thiagohenry.tcc.Model.Request;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class CustomerActivityList extends AppCompatActivity {
    private AppCompatActivity act;
    //private TextView search = (EditText) findViewById(R.id.inputSearch);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        act = this;

        carregaListaCustomers();
    }

    public void carregaListaCustomers() {

        final TextView search = (EditText) findViewById(R.id.inputSearch);
        final Switch filter_by_code     = (Switch)      findViewById(R.id.filter_by_code);
        final Switch filter_by_name     = (Switch)      findViewById(R.id.filter_by_name);
        final Switch filter_by_phone    = (Switch)      findViewById(R.id.filter_by_phone);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (filter_by_code.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Customer> query  = realm.where(Customer.class);

                    query.contains("code", String.valueOf(search.getText()));
                    final RealmResults<Customer> result1 = query.findAll();
                    final ListView ListCustomers = (ListView) findViewById(R.id.customer_list);

                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, act);
                    ListCustomers.setAdapter(adapter);

                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View viewItem, final int position, long id) {

                        }
                    });
                }
                else if (filter_by_name.isChecked() == true){

                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Customer> query  = realm.where(Customer.class);

                    query.contains("name", String.valueOf(search.getText()));
                    final RealmResults<Customer> result1 = query.findAll();
                    final ListView ListCustomers = (ListView) findViewById(R.id.customer_list);

                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, act);
                    ListCustomers.setAdapter(adapter);

                    // Here's when the the user click on customer of the list and then add to list of
                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                            Intent act_cust     = new Intent(act, RequestCreateActivity.class);
                            Bundle bundle       = new Bundle();
                            // Set parameters to fill the list of the selected customer
                            bundle.putLong      ("id", result1.get(position).getId());
                            bundle.putString    ("fragment", "customer");

                            act_cust.putExtras  (bundle);
                            startActivity       (act_cust);
                        }
                    });
                }
                else if (filter_by_phone.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Customer> query  = realm.where(Customer.class);

                    query.contains("phone_1", String.valueOf(search.getText()));
                    final RealmResults<Customer> result1 = query.findAll();
                    final ListView ListCustomers = (ListView) findViewById(R.id.customer_list);

                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, act);
                    ListCustomers.setAdapter(adapter);

                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(act, RequestCreateActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("id", result1.get(position).getId());
                            bundle.putString("fragment", "customer");
                            act_cust.putExtras(bundle);
                            startActivity(act_cust);
                        }
                    });
                }
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

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaCustomers();
    }

}