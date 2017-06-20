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
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;

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
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Realm realm                 = Realm.getDefaultInstance();
                RealmQuery<Customer> query  = realm.where(Customer.class);

                query.contains("name", String.valueOf(search.getText()));
                final RealmResults<Customer> result1    = query.findAll();
                final ListView ListCustomers            = (ListView) findViewById(R.id.customer_list);

                CustomerAdapter adapter = new CustomerAdapter(result1, act);
                ListCustomers.setAdapter(adapter);
                ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent list_customer_in_request = new Intent(CustomerActivityList.this, RequestCreateActivity.class);
                    list_customer_in_request.putExtra("id", result1.get(position).getId());
                    Long a = result1.get(position).getId();
                    int b = a.intValue();
                    setResult(b);
                    finish();
                    }
                });
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