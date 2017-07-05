package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.ProductPrice;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class ProductAdapterPriceDetails extends BaseAdapter {

    private List<ProductPrice> productPrices;
    private Activity act;
    //private TextWatcher textWatcher;
    //private RequestCreateTabCustomerSelectedFragment textWatcher;
    //private RealmResults<Customer> result1;

    public ProductAdapterPriceDetails(List<ProductPrice> productPrices, Activity act) {
        this.productPrices = productPrices;
        this.act = act;
    }

    public ProductAdapterPriceDetails(List<ProductPrice> productPrices /*RequestCreateTabCustomerSelectedFragment textWatcher*/) {
        this.productPrices = productPrices;
        //this.textWatcher = textWatcher;
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

        // In this function we build the line with the details of the customer
        View view = act.getLayoutInflater().inflate(R.layout.product_details_price_by_line, parent, false);

        ProductPrice productPrice = productPrices.get(position);
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Price> priceRealmQuery       = realm.where(Price.class).equalTo("id", productPrice.getPrice().getId());
        RealmResults<Price> priceRealmResults   = priceRealmQuery.findAll();

        Price price = priceRealmResults.first();

        TextView name           = (TextView) view.findViewById(R.id.name);
        TextView value          = (TextView) view.findViewById(R.id.value);

        name.setText    (price.getName());

        value.setText   (productPrice.getCurrency() + ": " +  productPrice.getValue().toString());

        return view;
    }
}
