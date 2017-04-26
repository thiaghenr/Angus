package com.example.thiagohenry.tcc;

import android.widget.EditText;

import com.example.thiagohenry.tcc.Model.Cliente;
import com.example.thiagohenry.tcc.Model.Venda;
/**
 * Created by thiagohenry on 20/04/17.
 */

public class VendaActivityHelper {
    private final EditText fieldNrVenda;
    //private final EditText fieldNomeCliente;

    public VendaActivityHelper(VendaListaActivity vendaListaActivity){
        fieldNrVenda        = (EditText) vendaListaActivity.findViewById(R.id.nrVenda);
        //fieldNomeCliente    = (EditText) vendaListaActivity.findViewById(R.id.nomeCliente);
    }

    public void showSell(){
        Venda venda = new Venda();
        //venda.setNrVenda(fieldNrVenda.getText().toString());
    }
}
