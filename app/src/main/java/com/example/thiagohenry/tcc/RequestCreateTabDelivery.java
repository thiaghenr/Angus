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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;
import com.example.thiagohenry.tcc.Model.Status;

import java.util.zip.Inflater;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static android.view.View.inflate;
import static com.example.thiagohenry.tcc.R.id.action_context_bar;
import static com.example.thiagohenry.tcc.R.id.container;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabDelivery extends Fragment{
    private static final String TAG = "RequestCreateTabDelivery";
    public static TextView total_request_value;;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.request_create_tab_delivery, container, false);
        total_request_value = (TextView) view.findViewById(R.id.request_total_value);

        finishSale(view);
        populateSpinnerCondicao(view);
        populateSpinnerFatura(view);
        setTotalRequestValue();
        return view;
    }

    public void finishSale(final View view){
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

            Status status   = realm.where(Status.class).equalTo("description", "NO PAGADO").findFirst();
            request.setStatus_id(status);

            Customer customer = request.getCustomer_id();
            if (customer == null){
                Toast.makeText(getContext(), "Por favor elija un cliente", Toast.LENGTH_LONG).show();
                view.inflate(getContext(), R.layout.request_create_tab_customer, null);
                onStop();
//                request.deleteFromRealm();
//                realm.close();
            }

//            RealmResults<RequestItem> requestItem = realm.where(RequestItem.class).equalTo("request_id.id", request.getId()).findAll();
//            if (requestItem == null){
//                Toast.makeText(getContext(), "Por favor elija un producto", Toast.LENGTH_LONG).show();
//
//                view.inflate(getContext(), R.layout.request_create_tab_product, null);
//                onStop();
//            }

            realm.insertOrUpdate(request);
            realm.commitTransaction();
            realm.close();

            onDestroyView();

            timerDelayRemoveDialog(1000, dialog);
            }
        });
    }

    public void populateSpinnerCondicao(View view){
        Spinner spinner                     = (Spinner) view.findViewById(R.id.spinner_condicao);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.condicao_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void populateSpinnerFatura(View view){

        Spinner spinner                     = (Spinner) view.findViewById(R.id.spinner_fatura);
        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this.getContext(), R.array.fatura_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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

    public void setTotalRequestValue(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Request request = realm.where(Request.class).findAll().last();
        total_request_value.setText(request.getValue_total().toString());
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        setTotalRequestValue();
    }
}
