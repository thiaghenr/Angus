package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.Customer;

import io.realm.Realm;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class CustomerCreateActivity extends AppCompatActivity{
    private CustomerActivityHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_create);

        helper = new CustomerActivityHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.cliente_create_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_cliente:
                Intent go_to_list = new Intent(CustomerCreateActivity.this, CustomerActivityList.class);
                startActivity(go_to_list);
                //Here we don' use Intent because we want finish this
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();

                Customer customer = helper.pegaCustomer();

                realm.copyToRealm(customer);

                realm.commitTransaction();
                realm.close();

                Toast.makeText(CustomerCreateActivity.this, "Cliente " + customer.getName() + " Salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
