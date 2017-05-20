package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabDelivery extends Fragment{
    private static final String TAG = "RequestCreateTabDelivery";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_create_tab_delivery, container, false);
        return view;
    }
}
