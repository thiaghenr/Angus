package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class VendaCreateTabPagamento extends Fragment{
    private static final String TAG = "VendaCreateTabPagamento";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.venda_create_tab_pagamento, container, false);
        populateSpinnerCondicao(view);
        populateSpinnerFatura(view);
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

    @Override
    public void onResume() {
        super.onResume();
        populateSpinnerCondicao(getView());
        populateSpinnerFatura(getView());
    }
}

