package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import static java.lang.Math.toIntExact;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Connection.iConnectionCustomer;
import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class CustomerActivityList extends AppCompatActivity {
    private CustomerActivityHelper helper;
    private AppCompatActivity act;
    //private TextView search = (EditText) findViewById(R.id.inputSearch);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        helper = new CustomerActivityHelper(this);
        act = this;


//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//
//        Customer  customer_address = helper.pegaCustomer();
//        realm.copyToRealm(customer_address);
//
//        realm.commitTransaction();
//        realm.close();

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
                final RealmResults<Customer> result1 = query.findAll();
                final ListView ListCustomers = (ListView) findViewById(R.id.customer_list);

                CustomerAdapter adapter = new CustomerAdapter(result1, act);
                ListCustomers.setAdapter(adapter);
                //Toast.makeText(act, "onchange", Toast.LENGTH_SHORT).show();
                ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//                        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
//                        pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
//                        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);


                    Intent list_customer_in_request = new Intent(CustomerActivityList.this, RequestCreateActivity.class);
                    System.out.println(result1.get(position).getId() + "resssssuult");
                    list_customer_in_request.putExtra("id", result1.get(position).getId());
                    Long a = result1.get(position).getId();
                    //startActivityForResult(list_customer_in_request, 1);
                    int b = a.intValue();
                    setResult(b);
                    finish();
                    //startActivity(list_customer_in_request);
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

//
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        //Para Trazer um customer apenas
//        //Customer customer = realm.where(Customer.class).findFirst();
//
//        final List<Customer> customers = realm.where(Customer.class).findAll();
//        final ListView ListCustomers = (ListView) findViewById(R.id.customer_list);
//
//        CustomerAdapter adapter = new CustomerAdapter(customers, this);
//
//        ListCustomers.setAdapter(adapter);
//
//        ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent edit_customer = new Intent(CustomerActivityList.this, CustomerEditActivity.class);
//                edit_customer.putExtra("id", customers.get(position).getId());
//
//                System.out.println(customers.get(position).getId());
//                startActivity(edit_customer);
//            }
//        });
//
//        realm.commitTransaction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Button new_customer = (Button) findViewById(R.id.new_customer);

        new_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_form = new Intent(CustomerActivityList.this, CustomerCreateActivity.class);
                startActivity(go_to_form);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaCustomers();
    }

}