package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Connection.iConnection;
import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;
import com.example.thiagohenry.tcc.Model.Status;
import com.example.thiagohenry.tcc.Model.User;
import com.google.gson.JsonArray;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText)  findViewById(R.id.username);
        final EditText password = (EditText)  findViewById(R.id.password);
        final Button login      = (Button)    findViewById(R.id.btn_login);


//        if(ConnectionVerify() == true) {
//            syncUser();
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //checkUser(username.getText().toString(), password.getText().toString());
                Intent act_dash = new Intent(getBaseContext(), DashboardActivity.class);
                startActivity(act_dash);
                //checkUser(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private boolean checkUser(String username, String password) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> realmObjects = realm.where(User.class).findAll();
        for (User myRealmObject : realmObjects) {
            if (username.equals(myRealmObject.getUsername()) && password.equals(myRealmObject.getPassword())) {
                Toast.makeText(getApplicationContext(), "Olá " + username, Toast.LENGTH_LONG).show();
                Intent act_dash = new Intent(getBaseContext(), DashboardActivity.class);
                startActivity(act_dash);

                return true;
            }
        }
        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
        return false;
    }

    public void syncUser(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getUsers();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listaUsers = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(User.class, listaUsers.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public  boolean ConnectionVerify() {
        boolean connected;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null && conectivtyManager.getActiveNetworkInfo().isAvailable() && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            connected = true;
        } else {
            connected = false;
        }
        return connected;
    }
}
