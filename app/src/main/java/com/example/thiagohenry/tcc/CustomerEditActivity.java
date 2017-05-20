package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.Customer;

import java.util.List;

import io.realm.Realm;

public class CustomerEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit);

        final Realm realm = Realm.getDefaultInstance();

        final long id           = getIntent().getLongExtra("id", 0);
        //System.out.println(id);
        final Customer customer = realm.where(Customer.class).equalTo("id", id).findFirst();
        //System.out.println(customer.getId());
        final EditText  name            =   (EditText) findViewById(R.id.name_edit);
        final EditText  fantasy_name    =   (EditText) findViewById(R.id.fantasy_name_edit);
        final EditText  phone           =   (EditText) findViewById(R.id.phone_edit);

        //System.out.println(customer.getName());
        name.setText(           customer.getName());
        fantasy_name.setText(   customer.getFantasy_name());
        phone.setText(          customer.getPhone_1());

        Button alterar  = (Button) findViewById(R.id.customer_alterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_list = new Intent(CustomerEditActivity.this, CustomerActivityList.class);
                startActivity(go_to_list);

                realm.beginTransaction();

                customer.setName(           name.getText()          .toString());
                customer.setFantasy_name(   fantasy_name.getText()  .toString());
                customer.setPhone_1(        phone.getText()         .toString());

                realm.copyToRealm(customer);
                realm.commitTransaction();

                Toast.makeText(getBaseContext(), "Cliente alterado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        Button remover  = (Button) findViewById(R.id.customer_remover);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_list = new Intent(CustomerEditActivity.this, CustomerActivityList.class);
                startActivity(go_to_list);

                realm.beginTransaction();
                customer.deleteFromRealm();
                realm.commitTransaction();

                Toast.makeText(getBaseContext(), "Cliente removido com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
