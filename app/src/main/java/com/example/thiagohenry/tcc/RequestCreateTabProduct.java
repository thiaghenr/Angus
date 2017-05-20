package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.thiagohenry.tcc.Model.Product;

import java.util.List;

import io.realm.Realm;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabProduct extends Fragment{
    private static final String TAG = "RequestCreateTabProduct";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_create_tab_product, container, false);
        carregaListaProducts(view);
        return view;
    }

    private void carregaListaProducts(View view) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<Product> products = realm.where(Product.class).findAll();
        ListView ListaProductss  = (ListView) view.findViewById(R.id.products_list);
        ProductAdapter adapter  = new ProductAdapter(products, this.getActivity());
        ListaProductss.setAdapter(adapter);

        realm.commitTransaction();
    }

    @Override
    public void onResume() {
        super.onResume();
        carregaListaProducts(getView());
    }
}
