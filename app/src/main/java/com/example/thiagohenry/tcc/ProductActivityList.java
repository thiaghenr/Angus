package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.thiagohenry.tcc.Model.Product;

import java.util.List;

import io.realm.Realm;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductActivityList extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    private void carregaListaProdutos() {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<Product> products = realm.where(Product.class).findAll();
        ListView ProductsList = (ListView) findViewById(R.id.products_list);
        ProductAdapter adapter = new ProductAdapter(getBaseContext(), products, this);

        ProductsList.setAdapter(adapter);

        realm.commitTransaction();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaProdutos();
    }
}
