package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.RequestItem;

import java.util.ArrayList;

public class RequestCreateTabCartAdapter extends BaseAdapter {
    final Context context;
    private ArrayList<RequestItem> requestItem = new ArrayList<>();
    private final Activity act;

    public RequestCreateTabCartAdapter(Context context, ArrayList<RequestItem> requestItem, Activity act) {
        this.context = context;
        this.requestItem = requestItem;
        this.act = act;
    }

    @Override
    public int getCount() {
        return requestItem.size();
    }

    @Override
    public Object getItem(int position) {
        return requestItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, final View convertView, final ViewGroup parent) {
        // Here we build the shopphing cart or the list of the selected itens
        final View view                     =  LayoutInflater.from(parent.getContext()).inflate(R.layout.request_create_tab_cart_by_line, parent, false);
        final RequestItem request_item      = requestItem.get(position);

        final TextView product_selected     = (TextView) view.findViewById(R.id.product_selectec_added);
        final TextView product_final_price  = (TextView) view.findViewById(R.id.product_selected_added_final_price);
        final ImageButton remove_item       = (ImageButton)   view.findViewById(R.id.remove_selected_product);

        product_selected.       setText(request_item.getProduct_id().getName());
        product_final_price.    setText(String.valueOf(request_item.getValue_total()));

        remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling the function that remove a product of the shopping cart
                System.out.println(request_item + "     ONNN SELECTEEEEEED");
                RequestCreateTabCart.removeRequestItem(request_item);
            }
        });


        return view;
    }
}