package com.example.thiagohenry.tcc;

import android.widget.EditText;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Cliente;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class ClienteActivityHelper {
    //private final EditText campoApp_id;
    //   private final EditText campoCod_erp;
    private final TextView campoName;
    private final TextView campoFantasyName;
    private final TextView campoPhone1;


    public ClienteActivityHelper(ClienteCreateActivity clienteCreateActivity) {

        campoName           = (TextView) clienteCreateActivity.findViewById(R.id.name);
        campoFantasyName    = (TextView) clienteCreateActivity.findViewById(R.id.fantasy_name);
        campoPhone1         = (TextView) clienteCreateActivity.findViewById(R.id.phone);

    }

    public Cliente pegaCliente() {
        Cliente cliente = new Cliente();

        cliente.setName         (campoName.getText().toString());
        cliente.setFantasy_name (campoFantasyName.getText().toString());
        cliente.setPhone_1      (campoPhone1.getText().toString());

        return cliente;
    }
}
