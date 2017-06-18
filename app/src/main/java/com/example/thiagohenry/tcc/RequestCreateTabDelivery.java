package com.example.thiagohenry.tcc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.Request;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabDelivery extends Fragment{
    private static final String TAG = "RequestCreateTabDelivery";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_create_tab_delivery, container, false);
        finishSale(view);
        return view;
    }

    public void finishSale(View view){
        final Button finish_sale    = (Button)      view.findViewById(R.id.finish_sale);

        finish_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ProgressDialog dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Carregando...");
            dialog.setCancelable(false);
            dialog.show();
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Request request = realm.where(Request.class).findAll().last();

            realm.insertOrUpdate(request);
            realm.commitTransaction();
            realm.close();

            onDestroyView();

            timerDelayRemoveDialog(1000, dialog);
            }
        });
    }

    public void timerDelayRemoveDialog(long time, final ProgressDialog d){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            d.dismiss();
            Toast.makeText(getContext(), "Venda Efetuada com Sucesso", Toast.LENGTH_LONG).show();
            Intent act_main = new Intent(getActivity(), DashboardActivity.class);
            startActivity(act_main);
            getActivity().finish();
            }
        }, time);
    }
}
