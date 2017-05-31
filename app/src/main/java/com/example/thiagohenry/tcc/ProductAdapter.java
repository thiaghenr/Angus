package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;

import java.util.List;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductAdapter extends BaseAdapter{
    private final List<Product> productss;
    private final Activity act;

    public ProductAdapter(List<Product> productss, Activity act) {
        this.productss = productss;
        this.act = act;
    }

    @Override
    public int getCount() {
        return productss.size();
    }

    @Override
    public Object getItem(int position) {
        return productss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.product_list_custom_by_line, parent, false);

        Product products            = productss.get(position);
        //ProductPrice productPrice   = productss.get(position);

        TextView name           = (TextView) view.findViewById(R.id.name);
        name.setText(products.getName());

        TextView description    = (TextView) view.findViewById(R.id.description);
        description.setText(products.getDescription());

        TextView category       = (TextView) view.findViewById(R.id.category);
        category.setText(products.getCategory());

        TextView unity       = (TextView) view.findViewById(R.id.unity);
        unity.setText(products.getUnity());

        TextView packag       = (TextView) view.findViewById(R.id.packag);
        packag.setText(products.getPac());

        TextView mark            = (TextView) view.findViewById(R.id.mark);
        mark.setText(products.getMark());


        //TextView qtd            = (TextView)  view.findViewById(R.id.qtd);
        //TextView price          = (TextView)  view.findViewById(R.id.price);
        return view;
    }
}
