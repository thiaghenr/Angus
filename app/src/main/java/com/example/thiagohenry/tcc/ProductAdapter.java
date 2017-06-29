package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductAdapter extends BaseAdapter{
    final Context context;
    private final List<Product> productss;
    private final Activity act;

    public ProductAdapter(Context context, List<Product> productss, Activity act) {
        this.context = context;
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
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        final View view = act.getLayoutInflater().inflate(R.layout.product_list_custom_by_line, parent, false);

        final Product products            = productss.get(position);
        //ProductPrice productPrice   = productss.get(position);

        final TextView name             = (TextView) view.findViewById(R.id.name);
        name.setText(products.getName());

        TextView description            = (TextView) view.findViewById(R.id.description);
        description.setText(products.getDescription());

        TextView category               = (TextView) view.findViewById(R.id.category);
        category.setText(products.getCategory());

        TextView unity                  = (TextView) view.findViewById(R.id.unity);
        unity.setText(products.getUnity());

        TextView mark                   = (TextView) view.findViewById(R.id.mark);
        mark.setText(products.getMark());

        //TextView qtd            = (TextView)  view.findViewById(R.id.qtd);
        //TextView price          = (TextView)  view.findViewById(R.id.price);
        return view;
    }
}
