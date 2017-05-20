package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.Product;

import io.realm.Realm;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductCreateActivity extends AppCompatActivity{
    private ProductActivityHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_create);
        helper = new ProductActivityHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.product_create_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_product:
                Intent go_to_list = new Intent(ProductCreateActivity.this, ProductActivityList.class);
                startActivity(go_to_list);
                //Here we don' use Intent because we want finish this
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();

                Product product = helper.pegaProduct();
                realm.copyToRealm(product);

                realm.commitTransaction();
                realm.close();

                Toast.makeText(ProductCreateActivity.this, "Product " + product.getName() + " Salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
