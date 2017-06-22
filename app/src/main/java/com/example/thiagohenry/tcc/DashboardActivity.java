package com.example.thiagohenry.tcc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Connection.iConnection;
import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;
import com.example.thiagohenry.tcc.Model.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.List;

import io.realm.Realm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Resources resources;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_angus);

        // Call Views
        ImageButton cliente     = (ImageButton) findViewById(R.id.Customer);
        ImageButton venda       = (ImageButton) findViewById(R.id.Request);
        ImageButton sync        = (ImageButton) findViewById(R.id.Sync);
        ImageButton pagamento   = (ImageButton) findViewById(R.id.Payment);
        ImageButton produto     = (ImageButton) findViewById(R.id.Product);
        ImageButton opcao       = (ImageButton) findViewById(R.id.Options);

        cliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_cliente = new Intent (DashboardActivity.this, CustomerActivityList.class);
                startActivity(form_cliente);
            }
        });

        venda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_venda = new Intent (DashboardActivity.this, RequestCreateActivity.class);
                startActivity(form_venda);
            }
        });

        produto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_produto = new Intent (DashboardActivity.this, ProductActivityList.class);
                startActivity(form_produto);
            }
        });

        sync.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            dialog = new ProgressDialog(DashboardActivity.this);
            dialog.setMessage("Carregando...");
            dialog.setCancelable(false);
            dialog.show();
            syncAll();
            timerDelayRemoveDialog(1000, dialog);
            }
        });
//
        pagamento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_pagamento = new Intent (DashboardActivity.this, RequestActivityList.class);
                startActivity(form_pagamento);
            }
        });
//
//        produto.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_produto = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_produto);
//            }
//        });
//
//        opcao.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_opcao = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_opcao);
//            }
//        });

        Toolbar toolbar     = (Toolbar)     findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Customer) {
            Intent form_cliente = new Intent (DashboardActivity.this, CustomerActivityList.class);
            startActivity(form_cliente);
        } else if (id == R.id.Request) {
            Intent form_venda = new Intent (DashboardActivity.this, RequestActivityList.class);
            startActivity(form_venda);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void syncAll(){
        syncCustomer();
        //syncCustomerAddress(); //tirar os C dos id
        syncPrice();
        syncProduct();
        //syncProductPrice(); dados repetidos
        //syncProductStock(); dados repetidos
        syncStatus();
    }

    public void syncCustomer(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getCustomer();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listaCustomer = response.body();

                //for (int i = 0; i < listaCustomer.size(); i++){
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                //String newCustomer = listaCustomer.get(i).toString();
                //System.out.println(newCustomer);
                realm.createAllFromJson(Customer.class, listaCustomer.toString());
                //realm.createAllFromJson(Customer.class, listaCustomer.toString()); aqui funcionou
                //realm.createOrUpdateAllFromJson(Customer.class, listaCustomer.getAsString());
                //realm.createOrUpdateObjectFromJson(Customer.class, newCustomer);
                realm.commitTransaction();
                realm.close();
                //}
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void syncCustomerAddress(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getCustomerAddress();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listaCustomerAddress = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(CustomerAddress.class, listaCustomerAddress.toString());
                realm.commitTransaction();
                realm.close();
                //}
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void syncPrice(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getPrice();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listPrice = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(Price.class, listPrice.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void syncProduct(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getProduct();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listProduct = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(Product.class, listProduct.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void syncProductPrice(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getProductPrice();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listProductPrice = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(ProductPrice.class, listProductPrice.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void syncProductStock(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getProductStock();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listProductStock = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(ProductStock.class, listProductStock.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void syncStatus(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getStatus();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listStatus = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(Status.class, listStatus.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                System.out.println(call);
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void timerDelayRemoveDialog(long time, final ProgressDialog d){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            d.dismiss();
            Toast.makeText(getBaseContext(), "Sincronizacíon Efetuada com Sucesso", Toast.LENGTH_LONG).show();
            }
        }, time);
    }
}
