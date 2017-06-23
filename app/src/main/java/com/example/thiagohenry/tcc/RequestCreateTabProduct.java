package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabProduct extends Fragment{
    private static final String TAG                     = "RequestCreateTabProduct";
    private static       View                             mView;
    private static       Context                          context;
    private static       Activity                         act;
    public static ArrayList<RequestItem>    listItems    = new ArrayList<>();
    private static ArrayAdapter<Product>                   adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.request_create_tab_product, container, false);

        this.mView      = view;
        this.context    = getContext();
        this.act        = getActivity();

        carregaListaProducts(view);
        return view;
    }

    public void carregaListaProducts(final View view) {

        final TextView search                           = (EditText)    view.findViewById(R.id.inputSearch_product);
        final Switch filter_by_name_product             = (Switch)      view.findViewById(R.id.filter_by_name_product);
        final Switch filter_by_brand                    = (Switch)      view.findViewById(R.id.filter_by_brand);
        final Switch filter_by_category                 = (Switch)      view.findViewById(R.id.filter_by_category);

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

        search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ((InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        mView.getWindowToken(), 0);
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
                    final ListView ListProducts = (ListView) view.findViewById(R.id.products_list);

                    RequestCreateTabProductAdapter adapter = new RequestCreateTabProductAdapter(getContext(), result1, getActivity());
                    ListProducts.setAdapter(adapter);
                }
                else if (filter_by_brand.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Product> query  = realm.where(Product.class);

                    query.contains("description", String.valueOf(search.getText()));
                    final RealmResults<Product> result1 = query.findAll();
                    final ListView ListProducts = (ListView) view.findViewById(R.id.products_list);

                    RequestCreateTabProductAdapter adapter = new RequestCreateTabProductAdapter(getContext(), result1, getActivity());
                    ListProducts.setAdapter(adapter);

                    ListProducts.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(getActivity(), RequestCreateActivity.class);
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
                    final ListView ListProducts = (ListView) view.findViewById(R.id.products_list);

                    RequestCreateTabProductAdapter adapter = new RequestCreateTabProductAdapter(getContext(), result1, getActivity());
                    ListProducts.setAdapter(adapter);

                    ListProducts.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(getActivity(), RequestCreateActivity.class);
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
    public void onResume() {
        super.onResume();
        carregaListaProducts(getView());
    }

    public static void newRequestItem(Product product, String qty, Double total){
        Realm realm     = Realm.getDefaultInstance();
        //Create new Item to requestItem
        realm.beginTransaction();
        RequestItem newRequestItem = new RequestItem();

        newRequestItem.setId((long) getNextKeyRequestItem(newRequestItem));

        realm.copyToRealm(newRequestItem);
        realm.commitTransaction();

        realm.beginTransaction();

        // Build a query to get the product id
        RealmQuery<Product> query  = realm.where(Product.class);
        query.equalTo("id", product.getId());

        final RealmResults<Product> p_id = query.findAll().sort("id");

        RequestItem requestItem = realm.where(RequestItem.class).findAll().last();
        Request     request     = realm.where(Request.class).findAll().last();

        Product requestProduct   = realm.where(Product.class).equalTo("id", p_id.get(0).getId()).findFirst();
        // Build the object requestItem
        requestItem.setProduct(requestProduct);
        requestItem.setRequest_id(request);
        requestItem.setQuantity(Double.parseDouble(qty));
        requestItem.setValue_total(total);
        // Insert the object on the table RequestItem
        realm.insertOrUpdate(requestItem);

        realm.commitTransaction();
        realm.close();

        RequestCreateTabCart.newItem(requestItem);

        onFocusChange(mView, false);
    }



    public static void onFocusChange(View v, boolean hasFocus) {
        //This method is to keyboard's get down when the focus change.
        if (false == hasFocus) {
            ((InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    mView.getWindowToken(), 0);
        }
    }

    public static int getNextKeyRequestItem(RequestItem requestItem) {
        // That's the default function to generate id
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(RequestItem.class).max("id") == null){
            return 1;
        } else {
            return realm.where(requestItem.getClass()).max("id").intValue() + 1;
        }
    }

    public static void calcRequestTotalValue(){
        // in this function we made the calc of the value total of the request when the user add an item on the shopping cart
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Request request = realm.where(Request.class).findAll().last();
        RequestItem requestItem = realm.where(RequestItem.class).findAll().last();
        Double total = request.getValue_total();
        if (total == null){
            total = 0.0;
        }
        total += requestItem.getValue_total();
        request.setValue_total(total);

        //RequestCreateTabCart.calcRequestTotalValueInvoice(total);

        realm.insertOrUpdate(request);
        realm.commitTransaction();
        realm.close();
    }
}
