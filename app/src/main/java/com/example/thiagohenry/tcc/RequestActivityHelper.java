package com.example.thiagohenry.tcc;

import android.widget.EditText;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Request;

import io.realm.Realm;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class RequestActivityHelper {
    //private final Customer customer;
    //private final EditText fieldNrVenda;
    //private final EditText fieldNomeCliente;

    public RequestActivityHelper(RequestCreateActivity requestActivityCreate){
        //customer = (Customer) requestActivityCreate.findViewById(R.id.c);
        //fieldNomeCliente    = (EditText) vendaListaActivity.findViewById(R.id.nomeCliente);
    }

    public void showSell(){
        Request request = new Request();
        //venda.setNrVenda(fieldNrVenda.getText().toString());
    }

    public Request newResquest() {
        Realm realm = Realm.getDefaultInstance();

        Request request = new Request();

        request.setId           ((long) getNextKey(request));
        //customer.setCode         (campoCode.getText().toString());
//        customer.setName         (campoName.getText().toString());
//        customer.setFantasy_name (campoFantasyName.getText().toString());
//        customer.setPhone_1      (campoPhone1.getText().toString());

        return request;
    }

    private int getNextKey(Request request) {
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(Request.class).max("id") == null){
            return 1;
        } else {
            return realm.where(request.getClass()).max("id").intValue() + 1;
        }
    }
}
