package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class ProductActivityDetails extends AppCompatActivity {
    private AppCompatActivity act;
    //private TextView search = (EditText) findViewById(R.id.inputSearch);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        act = this;

        TextView name           = (TextView) findViewById(R.id.name);
        TextView description    = (TextView) findViewById(R.id.description);
        TextView category       = (TextView) findViewById(R.id.category);
        TextView unity          = (TextView) findViewById(R.id.unity);
        TextView mark           = (TextView) findViewById(R.id.mark);
        ListView price_list     = (ListView) findViewById(R.id.price_list);
        ListView stock_list     = (ListView) findViewById(R.id.stock_list);


        Bundle extras = getIntent().getExtras();
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Product> realmQuery      = realm.where(Product.class).equalTo("id", extras.getLong("id"));
        RealmResults<Product> realmResults  = realmQuery.findAll();

        name.setText            (realmResults.get(0).getName());
        description.setText     (realmResults.get(0).getDescription());
        category.setText        (realmResults.get(0).getCategory());
        unity.setText           (realmResults.get(0).getUnity());
        mark.setText            (realmResults.get(0).getMark());


        RealmQuery<ProductPrice> productPriceRealmQuery     = realm.where(ProductPrice.class).equalTo("product.id", realmResults.get(0).getId());
        RealmResults<ProductPrice> productPriceRealmResults = productPriceRealmQuery.findAll();

        ProductAdapterPriceDetails adapter_price = new ProductAdapterPriceDetails(productPriceRealmResults, act);
        price_list.setAdapter(adapter_price);

        RealmQuery<ProductStock> productStockRealmQuery     = realm.where(ProductStock.class).equalTo("product.id", realmResults.get(0).getId());
        RealmResults<ProductStock> productStockRealmResults = productStockRealmQuery.findAll();

        ProductAdapterStockDetails adapter_stock = new ProductAdapterStockDetails(productStockRealmResults, act);
        stock_list.setAdapter(adapter_stock);
    }
}