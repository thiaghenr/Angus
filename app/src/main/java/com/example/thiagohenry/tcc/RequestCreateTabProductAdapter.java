package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.RequestItem;

import java.util.List;

import io.realm.Realm;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class RequestCreateTabProductAdapter extends BaseAdapter{
    final Context context;
    private final List<Product> productss;
    private final Activity act;

    public RequestCreateTabProductAdapter(Context context, List<Product> productss, Activity act) {
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

        final View view = act.getLayoutInflater().inflate(R.layout.request_create_tab_product_by_line, parent, false);

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

        final Button add_prod                 = (Button) view.findViewById(R.id.add_product_in_list);

        add_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // custom dialog
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.request_create_tab_product_adding_dialog);
            dialog.setTitle("Escolha o preço e o valor...");

            // set the custom dialog components - text, image and button
            EditText    qty    = (EditText)     dialog.findViewById(R.id.quantity_product_selected);
            EditText    price  = (EditText)     dialog.findViewById(R.id.price_product_selected);

            Button add_product_dialog = (Button) dialog.findViewById(R.id.add_product_dialog);
            // if button is clicked, close the custom dialog
            add_product_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RequestCreateTabProduct.newRequestItem(products);
                    //f.newRequestItem(products);
                    dialog.dismiss();
                }
            });

            dialog.show();
            }
        });

        Button prod_detail  =   (Button) view.findViewById(R.id.product_detail);
        prod_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicaaaaaaaaaaaadoooooo");
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.request_create_tab_product_detail_dialog);
                dialog.setTitle("Title...");

                // set the custom dialog components - text, image and button
                TextView qty = (TextView) dialog.findViewById(R.id.quantity_product);
                final TextView price = (TextView) dialog.findViewById(R.id.price_product);

                qty.setText("Android custom dialog example!");
                price.setText("222222");

                Button dialogButton = (Button) dialog.findViewById(R.id.add_product_dialog);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //RequestCreateTabProduct.newRequestItem(products);
                        //new_item.newRequestItem(products);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        //TextView qtd            = (TextView)  view.findViewById(R.id.qtd);
        //TextView price          = (TextView)  view.findViewById(R.id.price);
        return view;
    }

    public static int getNextKey(RequestItem requestItem) {
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(RequestItem.class).max("id") == null){
            return 1;
        } else {
            return realm.where(requestItem.getClass()).max("id").intValue() + 1;
        }
    }
}
