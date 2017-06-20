package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;

import java.util.ArrayList;

public class ProductListSelectedAdapter extends BaseAdapter {
    final Context context;
    private ArrayList<Product> product = new ArrayList<>();
    private final Activity act;

    public ProductListSelectedAdapter(Context context, ArrayList<Product> products, Activity act) {
        this.context = context;
        this.product = products;
        this.act = act;
    }

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int position) {
        return product.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, final View convertView, final ViewGroup parent) {
        final View view                     = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_create_tab_cart_by_line, parent, false);
        final Product products              = product.get(position);

        final TextView product_selected     = (TextView) view.findViewById(R.id.product_selectec_added);
        final TextView product_final_price  = (TextView) view.findViewById(R.id.product_selected_added_final_price);

        product_selected.       setText(products.getName());
        product_final_price.    setText("cinquentamilhoes");

        return view;
    }
}