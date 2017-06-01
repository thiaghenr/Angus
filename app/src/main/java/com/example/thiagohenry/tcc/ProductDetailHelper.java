package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;

import java.util.List;

import io.realm.Realm;

public class ProductDetailHelper extends AppCompatActivity {

    private DetailHelper helper;
    private final TextView detalheCodigo;
    private final TextView detailDescription;
    private final TextView detailMark;
    private final TextView detailTotalStock;

    public ProductDetailHelper(ProductDetail activity){
        detalheCodigo       = (TextView) activity.findViewById(R.id.detalheCodigo);
        detailDescription   = (TextView) activity.findViewById(R.id.detailDescription);
        detailMark          = (TextView) activity.findViewById(R.id.detailMark);
        detailTotalStock    = (TextView) activity.findViewById(R.id.detailTotalStock);
    }

    public void preencheFormulario(Product product) {
        detalheCodigo.setText       ("Codigo: "+product.getCod_erp());
        detailDescription.setText   (product.getDescription());
        if(product.getMark() != null)
            detailMark.setText("Marca: "+product.getMark());
        //detailTotalStock.setText("Cant: "+product.getQtd_total().toString());
    }


}
