package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.thiagohenry.tcc.DAO.ClienteDao;
import com.example.thiagohenry.tcc.Model.Cliente;

import java.util.List;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class ClienteListaActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
    }

    public void carregaListaClientes() {
        ClienteDao dao          = new ClienteDao(this);
        List<Cliente> clientes  = dao.buscaClientes();
        dao.close();

        ListView ListaClientes = (ListView) findViewById(R.id.list_clientes);
        ClienteAdapter adapter = new ClienteAdapter(clientes, this);
        ListaClientes.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Button new_cliente = (Button) findViewById(R.id.new_cliente);

        new_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_form = new Intent(ClienteListaActivity.this, ClienteCreateActivity.class);
                startActivity(go_to_form);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaClientes();
    }
}
