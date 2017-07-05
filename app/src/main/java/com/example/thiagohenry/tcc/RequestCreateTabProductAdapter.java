package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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

public class RequestCreateTabProductAdapter extends BaseAdapter{
    final Context context;
    private final List<Product> productss;
    private final Activity act;
    private ImageButton add_prod;
    public static EditText    price;

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
        // In this function we build the line with the details of the product
        final View view = act.getLayoutInflater().inflate(R.layout.request_create_tab_product_by_line, parent, false);

        final Product products            = productss.get(position);
        //ProductPrice productPrice   = productss.get(position);

        final TextView name             = (TextView) view.findViewById(R.id.name);
        TextView description            = (TextView) view.findViewById(R.id.description);
        TextView category               = (TextView) view.findViewById(R.id.category);
        TextView unity                  = (TextView) view.findViewById(R.id.unity);
        TextView mark                   = (TextView) view.findViewById(R.id.mark);

        name.       setText(products.getName());
        description.setText(products.getDescription());
        category.   setText(products.getCategory());
        unity.      setText(products.getUnity());
        mark.       setText(products.getMark());

        add_prod                 = (ImageButton) view.findViewById(R.id.add_product_in_list);

        add_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onFocusChange(view, false);
            // building the dialog to user set the quantity and the price of the selected product
            final Dialog dialog = new Dialog(context);

            dialog.setContentView(R.layout.request_create_tab_product_adding_dialog);
            dialog.setTitle("Elija el precio y el valor ...");

            final EditText    qty    = (EditText)     dialog.findViewById(R.id.quantity_product_selected);
                              price  = (EditText)     dialog.findViewById(R.id.price_product_selected);

            Button add_product_dialog = (Button) dialog.findViewById(R.id.add_product_dialog);
            // if button is clicked, close the custom dialog
            add_product_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                // Here we made calc of the total value of the selected item
                Double total = Double.parseDouble(qty.getText().toString()) * Double.parseDouble(price.getText().toString());

                RequestCreateTabProduct.newRequestItem(products, qty.getText().toString(), total);
                dialog.dismiss();
                }
            });

            dialog.show();
            }
        });

        ImageButton prod_detail  =   (ImageButton) view.findViewById(R.id.product_detail);
        prod_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.request_create_tab_product_detail_dialog);
                dialog.setTitle("Title...");
                Product p = productss.get(position);
                // set the custom dialog components - text, image and button
                TextView product_selected_in_detail_dialog                          = (TextView) dialog.findViewById(R.id.product_selected_in_detail_dialog);
                TextView brand_product_selected_in_detail_dialog                    = (TextView) dialog.findViewById(R.id.brand_product_selected_in_detail_dialog);

                ListView ProductsPriceList                                          = (ListView) dialog.findViewById(R.id.price_selected_in_detail_dialog);
                ListView ProductsStockList                                          = (ListView) dialog.findViewById(R.id.stock_selected_in_detail_dialog);

                RequestCreateTabProductDetailDialogPriceAdapter adapterPrice        = new RequestCreateTabProductDetailDialogPriceAdapter(p, act);
                ProductsPriceList.setAdapter(adapterPrice);

                RequestCreateTabProductDetailDialogStockAdapter adapterStock        = new RequestCreateTabProductDetailDialogStockAdapter(p, act);
                ProductsStockList.setAdapter(adapterStock);

                product_selected_in_detail_dialog.setText(products.getName());
                brand_product_selected_in_detail_dialog.setText(products.getMark());

                dialog.show();
            }
        });
        return view;
    }


    public void onFocusChange(View v, boolean hasFocus)
    {
        if (false == hasFocus) {
            ((InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    add_prod.getWindowToken(), 0);
        }
    }
}
