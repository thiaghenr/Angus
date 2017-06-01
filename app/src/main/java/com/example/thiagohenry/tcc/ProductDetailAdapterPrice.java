package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.ProductPrice;

import java.util.List;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class ProductDetailAdapterPrice extends BaseAdapter {

    private List<ProductPrice> productPrices;
    private Activity act;
    private ProductDetail textWatcher;

    public ProductDetailAdapterPrice(List<ProductPrice> productPrices, ProductDetail textWatcher) {
        this.productPrices = productPrices;
        this.textWatcher = textWatcher;
    }

    public int getCount() {
        return productPrices.size();
    }

    public Object getItem(int position) {
        return productPrices.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.price_list_custom_by_line, parent, false);
        //View view = acts.getLayoutInflater().inflate(R.layout.activity_produto_detalhe_price, parent, false);

        ProductPrice productPrice   = productPrices.get(position);
        TextView price_id           = (TextView) view.findViewById(R.id.price_id);
        TextView value              = (TextView) view.findViewById(R.id.value);

        price_id.setText    (productPrice.getPrice_id().toString());
        value.setText       ((int) productPrice.getValue());

        return view;
    }
}
