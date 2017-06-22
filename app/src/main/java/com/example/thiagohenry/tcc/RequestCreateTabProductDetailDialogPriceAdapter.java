package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class RequestCreateTabProductDetailDialogPriceAdapter extends BaseAdapter{
    private final Product product;
    private final Activity act;

    public static EditText    price;

    public RequestCreateTabProductDetailDialogPriceAdapter(Product product, Activity act) {
        this.product = product;
        this.act = act;
    }

    @Override
    public int getCount() {
        return product.getId().intValue();
    }

    @Override
    public Object getItem(int position) {
        return product;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        // In this function we build the line with the details of the price
        Realm realm = Realm.getDefaultInstance();
        final View view = act.getLayoutInflater().inflate(R.layout.request_create_tab_product_detail_dialog_list_price, parent, false);

        RealmQuery<ProductPrice> realmProducPrice       = realm.where(ProductPrice.class).equalTo("product_id.id", product.getId());
        RealmResults<ProductPrice> resultProductPrice   = realmProducPrice.findAll();

        //final Product products            = product;

        //ProductPrice productPrice   = productss.get(position);
        TextView currency     = (TextView) view.findViewById(R.id.currency);
        TextView value        = (TextView) view.findViewById(R.id.value);

        currency.       setText(resultProductPrice.get(0).getCurrency());
        value.          setText(resultProductPrice.get(0).getValue().toString());

        return view;
    }

}
