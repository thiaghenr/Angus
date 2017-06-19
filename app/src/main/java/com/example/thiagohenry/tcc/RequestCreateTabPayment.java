package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.example.thiagohenry.tcc.RequestCreateTabProduct.calcRequestTotalValue;
import static com.example.thiagohenry.tcc.RequestCreateTabProduct.getNextKeyRequestItem;
import static com.example.thiagohenry.tcc.RequestCreateTabProduct.removeRequestItem;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabPayment extends Fragment{
    private static final String TAG = "RequestCreateTabPaymento";
    private static View mView;
    public static TextView total_invoice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_create_tab_payment, container, false);
        this.mView = view;
        populateSpinnerCondicao(view);
        populateSpinnerFatura(view);
        total_invoice = (TextView) view.findViewById(R.id.request_total_value);
        return view;
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

    public static void calcRequestTotalValueInvoice(Double current_total){
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();

        //Request request_recalc = realm.where(Request.class).findAll().last();

        //Double total = request_recalc.getValue_total();

        total_invoice.setText(current_total.toString());
        //System.out.println(total + "     kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//        realm.commitTransaction();
//        realm.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        populateSpinnerCondicao(mView);
        populateSpinnerFatura(mView);
        //calcRequestTotalValueInvoice();
    }
}
