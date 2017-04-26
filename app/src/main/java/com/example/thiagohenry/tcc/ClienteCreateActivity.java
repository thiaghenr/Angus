package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thiagohenry.tcc.DAO.ClienteDao;
import com.example.thiagohenry.tcc.DAO.ProdutoDao;
import com.example.thiagohenry.tcc.Model.Cliente;
import com.example.thiagohenry.tcc.Model.Produto;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class ClienteCreateActivity extends AppCompatActivity{
    private ClienteActivityHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente_create);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        helper = new ClienteActivityHelper(this);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.cliente_create_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_cliente:
//                Produto produto = helper.pegaProduto();
//
//                ProdutoDao dao = new ProdutoDao(this);
//                dao.Insert(produto);
//
//                Toast.makeText(ProdutoCreateActivity.this, produto.getApp_id()+  "Botao Clicado", Toast.LENGTH_SHORT).show();
//                //finish();
//                break;
                Intent go_to_list = new Intent(ClienteCreateActivity.this, ClienteListaActivity.class);
                startActivity(go_to_list);
                //Here we don' use Intent because we want finish this
                Cliente cliente = helper.pegaCliente();
                ClienteDao cliente_dao = new ClienteDao(this);
                cliente_dao.Insert(cliente);
                cliente_dao.close();
                Toast.makeText(ClienteCreateActivity.this, "Cliente " + cliente.getName() + " Salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
