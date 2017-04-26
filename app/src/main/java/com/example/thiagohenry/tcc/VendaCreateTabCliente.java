package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.thiagohenry.tcc.DAO.ClienteDao;
import com.example.thiagohenry.tcc.Model.Cliente;

import java.util.List;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class VendaCreateTabCliente extends Fragment{
    private static final String TAG = "VendaCreateTabCliente";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.venda_create_tab_cliente, container, false);
        carregaListaClientes(view);
        return view;
    }

    public void carregaListaClientes(View view) {
        ClienteDao dao          = new ClienteDao(this.getContext());
        List<Cliente> clientes  = dao.buscaClientes();
        dao.close();

        ListView ListaClientes = (ListView) view.findViewById(R.id.list_clientes);
        ClienteAdapter adapter = new ClienteAdapter(clientes, this.getActivity());
        ListaClientes.setAdapter(adapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        carregaListaClientes(getView());
    }
}
