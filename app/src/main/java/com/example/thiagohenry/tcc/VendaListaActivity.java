package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class VendaListaActivity extends AppCompatActivity{
    //Switch switchAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venda_lista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_search_venda, menu);

        MenuItem itemSwitch = menu.findItem(R.id.switchId);

        itemSwitch.setActionView(R.layout.venda_toogle_button_filter_codigo);

        //final Switch sw = (Switch) menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);

        //String[] venda  =   {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        //ListView listaVendas = (ListView) findViewById(R.id.lista_vendas);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(){this}

        Button new_venda = (Button) findViewById(R.id.new_venda);
        System.out.println(new_venda);
        new_venda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_form = new Intent(VendaListaActivity.this, VendaCreateActivity.class);
                startActivity(go_to_form);
            }
        });

        //switchAB = (Switch) menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);

        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.filter_search_venda, menu);
//
//        switchAB = (Switch)menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);
//
//        switchAB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,
//                                         boolean isChecked) {
//                if (isChecked) {
//                    Toast.makeText(getApplication(), "ON", Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//                    Toast.makeText(getApplication(), "OFF", Toast.LENGTH_SHORT)
//                            .show();
//                }
//            }
//        });
//        return true;
//    }
}
