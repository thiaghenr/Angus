package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class ProductAdapterStockDetails extends BaseAdapter {

    private List<ProductStock> productStocks;
    private Activity act;
    //private TextWatcher textWatcher;
    //private RequestCreateTabCustomerSelectedFragment textWatcher;
    //private RealmResults<Customer> result1;

    public ProductAdapterStockDetails(List<ProductStock> productStocks, Activity act) {
        this.productStocks = productStocks;
        this.act = act;
    }

    public ProductAdapterStockDetails(List<ProductStock> productStocks /*RequestCreateTabCustomerSelectedFragment textWatcher*/) {
        this.productStocks = productStocks;
        //this.textWatcher = textWatcher;
    }

    public int getCount() {
        return productStocks.size();
    }

    public Object getItem(int position) {
        return productStocks.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // In this function we build the line with the details of the customer
        View view = act.getLayoutInflater().inflate(R.layout.product_details_stock_by_line, parent, false);

        ProductStock productStock = productStocks.get(position);

        TextView stock_name             = (TextView) view.findViewById(R.id.stock_name);
        TextView quantity               = (TextView) view.findViewById(R.id.quantity);

        stock_name.setText      (productStock.getBranch());
        quantity.setText        (Double.toString(productStock.getQuantity()));

        return view;
    }
}
