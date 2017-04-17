package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call Views
        ImageButton cliente     = (ImageButton) findViewById(R.id.Cliente);
        ImageButton venda       = (ImageButton) findViewById(R.id.Venda);
        ImageButton sync        = (ImageButton) findViewById(R.id.Sincronizacao);
        ImageButton pagamento   = (ImageButton) findViewById(R.id.Pagamento);
        ImageButton produto     = (ImageButton) findViewById(R.id.Produto);
        ImageButton opcao       = (ImageButton) findViewById(R.id.Opcao);

        cliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_cliente = new Intent (MainActivity.this, ListaClienteActivity.class);
                startActivity(form_cliente);
            }
        });

        venda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_venda = new Intent (MainActivity.this, VendaActivity.class);
                startActivity(form_venda);
            }
        });

//        sync.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_sync = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_sync);
//            }
//        });
//
//        pagamento.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_pagamento = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_pagamento);
//            }
//        });
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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Cliente) {
            Intent form_cliente = new Intent (MainActivity.this, ListaClienteActivity.class);
            startActivity(form_cliente);
        } else if (id == R.id.Venda) {
            Intent form_venda = new Intent (MainActivity.this, VendaActivity.class);
            startActivity(form_venda);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
