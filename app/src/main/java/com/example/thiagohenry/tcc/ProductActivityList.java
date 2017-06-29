package com.example.thiagohenry.tcc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductActivityList extends AppCompatActivity{
    private AppCompatActivity act;
    private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        act     = this;
        context = getBaseContext();
    }

    private void carregaListaProdutos() {
        final TextView search                           = (EditText)    findViewById(R.id.inputSearch_product);
        final Switch filter_by_name_product             = (Switch)      findViewById(R.id.filter_by_name_product);
        final Switch filter_by_brand                    = (Switch)      findViewById(R.id.filter_by_brand);
        final Switch filter_by_category                 = (Switch)      findViewById(R.id.filter_by_category);

        filter_by_name_product.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    filter_by_brand.setChecked(false);
                    filter_by_category.setChecked(false);
                }
            }
        });

        filter_by_brand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked == true){
                    filter_by_name_product.setChecked(false);
                    filter_by_category.setChecked(false);
                }
            }
        });

        filter_by_category.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked == true){
                    filter_by_name_product.setChecked(false);
                    filter_by_brand.setChecked(false);
                }
            }
        });

        search.addTextChangedListener(new TextWatcher() {

            //OnCheckedChangeListener:
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (filter_by_name_product.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Product> query  = realm.where(Product.class);

                    query.contains("name", String.valueOf(search.getText()));
                    final RealmResults<Product> result1 = query.findAll();
                    final ListView ListProducts = (ListView) findViewById(R.id.products_list);

                    ProductAdapter adapter = new ProductAdapter(context, result1, act);
                    ListProducts.setAdapter(adapter);
                }
                else if (filter_by_brand.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Product> query  = realm.where(Product.class);

                    query.contains("description", String.valueOf(search.getText()));
                    final RealmResults<Product> result1 = query.findAll();
                    final ListView ListProducts = (ListView) findViewById(R.id.products_list);

                    ProductAdapter adapter = new ProductAdapter(context, result1, act);
                    ListProducts.setAdapter(adapter);

                    ListProducts.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(act, RequestCreateActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("id", result1.get(position).getId());
                            bundle.putString("fragment", "product");
                            act_cust.putExtras(bundle);
                            startActivity(act_cust);
                        }
                    });
                }
                else if (filter_by_category.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Product> query  = realm.where(Product.class);

                    query.contains("category", String.valueOf(search.getText()));
                    final RealmResults<Product> result1 = query.findAll();
                    final ListView ListProducts = (ListView) findViewById(R.id.products_list);

                    ProductAdapter adapter = new ProductAdapter(context, result1, act);
                    ListProducts.setAdapter(adapter);

                    ListProducts.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(act, RequestCreateActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("id", result1.get(position).getId());
                            bundle.putString("fragment", "product");
                            act_cust.putExtras(bundle);
                            startActivity(act_cust);
                        }
                    });
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
                //Toast.makeText(act, "beforechanged", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Toast.makeText(act, "afterchanged", Toast.LENGTH_SHORT).show();
                //search.setError(null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaProdutos();
    }
}
