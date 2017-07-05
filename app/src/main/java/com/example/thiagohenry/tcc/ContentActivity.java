package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by thiagohenry on 23/03/17.
 */

public class ContentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        ImageButton cliente     = (ImageButton) findViewById(R.id.Customer);
        ImageButton venda       = (ImageButton) findViewById(R.id.Request);
        ImageButton sync        = (ImageButton) findViewById(R.id.Sync);
        ImageButton pagamento   = (ImageButton) findViewById(R.id.Payment);
        ImageButton produto     = (ImageButton) findViewById(R.id.Product);
        ImageButton opcao       = (ImageButton) findViewById(R.id.User);

        cliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_cliente = new Intent (ContentActivity.this, CustomerActivityList.class);
                startActivity(form_cliente);
            }
        });

        venda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_venda = new Intent (ContentActivity.this, RequestActivityList.class);
                startActivity(form_venda);
            }
        });

//        sync.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_sync = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_sync);
//            }
//        });
//
//        pagamento.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_pagamento = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_pagamento);
//            }
//        });
//
//        produto.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_produto = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_produto);
//            }
//        });
//
//        opcao.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent form_opcao = new Intent (ContentActivity.this, CLASS HERE);
//                startActivity(form_opcao);
//            }
//        });
    }

    public void CallVenda(){
        ImageButton venda       = (ImageButton) findViewById(R.id.Request);
        venda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent form_venda = new Intent (ContentActivity.this, RequestActivityList.class);
                startActivity(form_venda);
            }
        });
    }
}
