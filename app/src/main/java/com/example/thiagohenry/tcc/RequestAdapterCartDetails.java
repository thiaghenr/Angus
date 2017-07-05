package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.RequestItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class RequestAdapterCartDetails extends BaseAdapter {

    private List<RequestItem> requestItems;
    private Activity act;

    public RequestAdapterCartDetails(List<RequestItem> requestItems, Activity act) {
        this.requestItems = requestItems;
        this.act = act;
    }

    public RequestAdapterCartDetails(List<RequestItem> requestItems /*RequestCreateTabCustomerSelectedFragment textWatcher*/) {
        this.requestItems = requestItems;
        //this.textWatcher = textWatcher;
    }

    public int getCount() {
        return requestItems.size();
    }

    public Object getItem(int position) {
        return requestItems.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // In this function we build the line with the details of the customer
        View view = act.getLayoutInflater().inflate(R.layout.request_details_cart_by_line, parent, false);

        RequestItem requestItem = requestItems.get(position);
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Product> productRealmQuery           = realm.where(Product.class).equalTo("id", requestItem.getProduct().getId());
        RealmResults<Product> productRealmResults       = productRealmQuery.findAll();

        Product product = productRealmResults.first();

        TextView name           = (TextView) view.findViewById(R.id.product);
        TextView qty            = (TextView) view.findViewById(R.id.qty);
        TextView value          = (TextView) view.findViewById(R.id.value_total);

        name.setText    (product.getName());
        qty.setText     (requestItem.getQuantity().toString());
        value.setText   (requestItem.getValue_total().toString());

        return view;
    }
}
