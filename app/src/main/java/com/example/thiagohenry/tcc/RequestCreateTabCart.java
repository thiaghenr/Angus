package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabCart extends Fragment{
    private static final String TAG = "RequestCreateTabPaymento";
    private static View mView;
    public static TextView total_invoice;
    private static Context context;
    private static Activity act;
    public static Double total;
    public static ArrayList<RequestItem> listItems    = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view   = inflater.inflate(R.layout.request_create_tab_cart, container, false);
        this.mView  = view;
        context     = this.getContext();
        act         = this.getActivity();
        return view;
    }

    public static void removeRequestItem(RequestItem requestItem){
        // First we remove item from list
        final ListView ListProductsSelected = (ListView) mView.findViewById(R.id.products_selected2);

        reCalcRequestTotalValue(requestItem);

        listItems.remove(requestItem);

        Realm realm     = Realm.getDefaultInstance();
        //Remove Item to from Request
        realm.beginTransaction();

        RequestItem requestItemRemoved = realm.where(RequestItem.class).equalTo("id", requestItem.getId()).findFirst();

        requestItemRemoved.deleteFromRealm();

        realm.commitTransaction();
        realm.close();


        RequestCreateTabCartAdapter adapterLocal = new RequestCreateTabCartAdapter(context, listItems, act);
        ListProductsSelected.setAdapter(adapterLocal);

    }

    public static void reCalcRequestTotalValue(RequestItem requestItem){
        // in this function we made the calc of the value total of the request when the user add an item on the shopping cart
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Request request = realm.where(Request.class).findAll().last();
        Double total = request.getValue_total();
        if (total == null){
            total = 0.0;
        }
        total -= requestItem.getValue_total();
        request.setValue_total(total);

        realm.insertOrUpdate(request);
        realm.commitTransaction();
        realm.close();
    }

    public static void newItem(RequestItem requestItem){
        final ListView ListProductsSelected = (ListView) mView.findViewById(R.id.products_selected2);

        listItems.add(requestItem);

        RequestCreateTabProduct.calcRequestTotalValue();

        RequestCreateTabCartAdapter adapterLocal = new RequestCreateTabCartAdapter(context, listItems, act);
        ListProductsSelected.setAdapter(adapterLocal);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
