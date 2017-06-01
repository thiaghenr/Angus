package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.ProductStock;

import java.util.List;

/**
 * Created by thiagohenry on 31/05/17.
 */

public class ProductDetailAdapterStock {
    private final List<ProductStock> produtoStocks;
    private final Activity act;

    public ProductDetailAdapterStock(List<ProductStock> productStocks, Activity act) {
        this.produtoStocks = productStocks;
        this.act = act;
    }


    public int getCount() {
        return produtoStocks.size();
    }


    public Object getItem(int position) {
        return produtoStocks.get(position);
    }


    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.product_detail_stock, parent, false);

        ProductStock produtoStock   = produtoStocks.get(position);
        TextView quantity           = (TextView) view.findViewById(R.id.quantity);
        TextView branch             = (TextView) view.findViewById(R.id.branch);

        quantity.setText((int) produtoStock.getQuantity());
        branch.setText(produtoStock.getBranch().toString());

        return view;
    }
}
