package com.example.thiagohenry.tcc;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.thiagohenry.tcc.Model.Product;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by thiagohenry on 07/06/17.
 */

public class ProductActivityListSelected extends ListActivity {
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.product_list_selected);
        //adapter = new ArrayAdapter<String>(this, android.R.layout., listItems);
        //setListAdapter(adapter);
    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.product_list_selected);
//    }
//
//    private void carregaListaProdutos() {
//
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//
//        List<Product> products = realm.where(Product.class).findAll();
//        ListView ProductsList = (ListView) findViewById(R.id.products_list_selected);
//        ProductAdapter adapter = new ProductAdapter(getBaseContext(), products, this);
//
//        ProductsList.setAdapter(adapter);
//
//        realm.commitTransaction();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        carregaListaProdutos();
//    }
}
