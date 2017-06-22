package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class RequestCreateTabProductDetailDialogStockAdapter extends BaseAdapter{
    private final Product product;
    private final Activity act;

    public static EditText    price;

    public RequestCreateTabProductDetailDialogStockAdapter(Product product, Activity act) {
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
        final View view = act.getLayoutInflater().inflate(R.layout.request_create_tab_product_detail_dialog_list_stock, parent, false);
        System.out.println(product + " RESUUUUUUUULT PRODUCT");
        RealmQuery<ProductStock> realmProducStock       = realm.where(ProductStock.class).equalTo("product_id.id", product.getId());
        RealmResults<ProductStock> resultProductStock   = realmProducStock.findAll();

        System.out.println(resultProductStock + " RESUUUUUUUULT STOOOOCK");
        //final Product products            = product;

        TextView branch     = (TextView) view.findViewById(R.id.branch);
        TextView quantity   = (TextView) view.findViewById(R.id.quantity);

        branch.       setText(resultProductStock.get(0).getBranch());
        quantity.     setText(resultProductStock.get(0).getQuantity().toString());

        return view;
    }

}
