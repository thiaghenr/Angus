package com.example.thiagohenry.tcc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.gson.JsonArray;

import java.sql.Connection;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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
                iConnection connection = iConnection.retrofit.create(iConnection.class);
                System.out.println(connection);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();
                final Call<JsonArray> call = connection.getCustomer();
                System.out.println(call.toString() + "   CAAAAAAAAAL     .TOSTRING()");
                call.enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();
                        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
                        System.out.println(response.body()   +   "   REEEESSSPOOOONSEEE BODY");
                        final JsonArray listaCustomer = response.body();
                        System.out.println(listaCustomer);

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
}
