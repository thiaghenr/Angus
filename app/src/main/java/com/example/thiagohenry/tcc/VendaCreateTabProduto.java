package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class VendaCreateTabProduto extends Fragment{
    private static final String TAG = "VendaCreateTabProduto";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.venda_create_tab_produto, container, false);
        return view;
    }
}
