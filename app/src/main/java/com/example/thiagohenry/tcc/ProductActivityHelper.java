package com.example.thiagohenry.tcc;

import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Product;

import io.realm.Realm;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductActivityHelper {

    private final TextView campoName;
    private final TextView campoDescription;
    private final TextView campoCategory;
    private final TextView campoPac;

    public ProductActivityHelper(ProductCreateActivity productCreateActivity) {

        campoName           = (TextView) productCreateActivity.findViewById(R.id.name);
        campoDescription    = (TextView) productCreateActivity.findViewById(R.id.description);
        campoCategory       = (TextView) productCreateActivity.findViewById(R.id.category);
        campoPac            = (TextView) productCreateActivity.findViewById(R.id.pac);

    }

    public Product pegaProduct() {
        Product product = new Product();

        //product.setId           ((long)             getNextKey(product));
        product.setName         (campoName.         getText().toString());
        product.setDescription  (campoDescription.  getText().toString());
        product.setCategory     (campoCategory.     getText().toString());
        product.setPac          (campoPac.          getText().toString());

        return product;
    }

//    private int getNextKey(Product product) {
//        Realm realm = Realm.getDefaultInstance();
//        if(realm.where(Product.class).max("id") == null){
//            return 1;
//        } else {
//            return realm.where(Product.class).max("id") + 1;
//        }
//    }
}
