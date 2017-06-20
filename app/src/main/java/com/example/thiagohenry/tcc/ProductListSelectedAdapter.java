package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Product;

import java.util.ArrayList;

public class ProductListSelectedAdapter extends BaseAdapter {
    final Context context;
    private ArrayList<Product> product = new ArrayList<>();
    private final Activity act;

    public ProductListSelectedAdapter(Context context, ArrayList<Product> products, Activity act) {
        this.context = context;
        this.product = products;
        this.act = act;
    }

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int position) {
        return product.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, final View convertView, final ViewGroup parent) {
        final View view                     =  LayoutInflater.from(parent.getContext()).inflate(R.layout.request_create_tab_cart_by_line, parent, false);
        final Product products              = product.get(position);

        final TextView product_selected     = (TextView) view.findViewById(R.id.product_selectec_added);
        final TextView product_final_price  = (TextView) view.findViewById(R.id.product_selected_added_final_price);

        product_selected.       setText(products.getName());
        product_final_price.    setText("cinquentamilhoes");

        return view;
    }

    public void addProduct(Product productSelected){
        product.add(productSelected);
        notifyDataSetChanged();
    }
}

//package com.example.thiagohenry.tcc;
//
//import android.app.ListActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//
//import com.example.thiagohenry.tcc.Model.Product;
//import com.example.thiagohenry.tcc.Model.Request;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.realm.Realm;
//
///**
// * Created by thiagohenry on 07/06/17.
// */
//
//public class ProductActivityListSelected extends ListActivity {
//    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
//    ArrayList<String> listItems = new ArrayList<String>();
//
//    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
//    ArrayAdapter<String> adapter;
//
//    Realm realm = Realm.getDefaultInstance();
//
//    Product product = realm.where(Product.class).findAll().last();
//
//    @Override
//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//        setContentView(R.layout.product_list_selected);
//        adapter = new ArrayAdapter<String>(this, android.R.layout., listItems);
//        setListAdapter(adapter);
//    }
//
//    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
//    public void addItems(Product product) {
//        listItems.add("Clicked : "+clickCounter++);
//        adapter.notifyDataSetChanged();
//    }
//
//
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.product_list_selected);
////    }
////
////    private void carregaListaProdutos() {
////
////        Realm realm = Realm.getDefaultInstance();
////        realm.beginTransaction();
////
////        List<Product> products = realm.where(Product.class).findAll();
////        ListView ProductsList = (ListView) findViewById(R.id.products_list_selected);
////        ProductAdapter adapter = new ProductAdapter(getBaseContext(), products, this);
////
////        ProductsList.setAdapter(adapter);
////
////        realm.commitTransaction();
////    }
////
////    @Override
////    protected void onResume() {
////        super.onResume();
////        carregaListaProdutos();
////    }
//}
