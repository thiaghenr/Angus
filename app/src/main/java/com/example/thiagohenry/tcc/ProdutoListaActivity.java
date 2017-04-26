package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.thiagohenry.tcc.DAO.ProdutoDao;
import com.example.thiagohenry.tcc.Model.Produto;

import java.util.List;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProdutoListaActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
    }

    private void carregaListaProdutos() {
        ProdutoDao dao          = new ProdutoDao(this);
        List<Produto> produtos  = dao.buscaProdutos();
        dao.close();

        ListView ListaProdutos = (ListView) findViewById(R.id.list_produtos);
        ProdutoAdapter adapter = new ProdutoAdapter(produtos, this);
        ListaProdutos.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.filter_search_venda, menu);

        //MenuItem itemSwitch = menu.findItem(R.id.switchId);

        //itemSwitch.setActionView(R.layout.venda_toogle_button_filter_codigo);

        //final Switch sw = (Switch) menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);

        //String[] venda  =   {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        //ListView listaVendas = (ListView) findViewById(R.id.lista_vendas);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(){this}

        Button new_product = (Button) findViewById(R.id.new_produto);
        new_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_form = new Intent(ProdutoListaActivity.this, ProdutoCreateActivity.class);
                startActivity(go_to_form);
            }
        });

        //switchAB = (Switch) menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaListaProdutos();
    }
}
