package com.example.thiagohenry.tcc;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;

import io.realm.Realm;


/**
 * Created by thiagohenry on 27/05/17.
 */

public class RequestCreateTabProductSelected extends Fragment{
    private static final String TAG = "RequestCreateTabProductSelected";
    private Long id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.request_create_tab_product_selected, container, false);

        final Realm realm = Realm.getDefaultInstance();
        final long id                   =   getActivity().getIntent().getExtras().getLong("id");

        final Product product           =   realm.where(Product.class).equalTo("id", id).findFirst();
        final TextView  name            =   (TextView) view.findViewById(R.id.product_selected);

        name.setText(product.getName());
        return view;
    }
}
