package com.example.thiagohenry.tcc;

import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;

/**
 * Created by thiagohenry on 31/05/17.
 */

public class DetailHelper {

    private final TextView detalheCodigo;
    private final TextView detailDescription;
    private final TextView detailMark;
    private final TextView detailTotalStock;
    //

    public DetailHelper(ProductDetail activity){

        detalheCodigo       = (TextView) activity.findViewById(R.id.detalheCodigo);
        detailDescription   = (TextView) activity.findViewById(R.id.detailDescription);
        detailMark          = (TextView) activity.findViewById(R.id.detailMark);
        detailTotalStock    = (TextView) activity.findViewById(R.id.detailTotalStock);
    }


    public void preencheFormulario(Product product) {
        detalheCodigo.setText("Codigo: "+product.getCod_erp());
        detailDescription.setText(product.getDescription());
        if(product.getMark() != null)
            detailMark.setText("Marca: "+product.getMark());
        //detailTotalStock.setText("Cant: "+product.getQtd_total().toString());


    }
}
