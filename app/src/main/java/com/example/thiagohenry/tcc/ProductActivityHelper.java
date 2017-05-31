package com.example.thiagohenry.tcc;

import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;

import io.realm.Realm;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProductActivityHelper {

    private final TextView campoName;
    private final TextView campoDescription;
    private final TextView campoCategory;
    private final TextView campoPac;
    private final TextView campoUnity;
    private final TextView campoMark;

    public ProductActivityHelper(ProductCreateActivity productCreateActivity) {

        campoName           = (TextView) productCreateActivity.findViewById(R.id.name);
        campoDescription    = (TextView) productCreateActivity.findViewById(R.id.description);
        campoCategory       = (TextView) productCreateActivity.findViewById(R.id.category);
        campoUnity          = (TextView) productCreateActivity.findViewById(R.id.unity);
        campoPac            = (TextView) productCreateActivity.findViewById(R.id.packag);
        campoMark           = (TextView) productCreateActivity.findViewById(R.id.mark);
    }

    public Product pegaProduct() {
        Product product             = new Product();
        ProductPrice productPrice   = new ProductPrice();

        product.setId           ((long)             getNextKey(product));
        product.setName         (campoName.         getText().toString());
        product.setDescription  (campoDescription.  getText().toString());
        product.setCategory     (campoCategory.     getText().toString());
        product.setPac          (campoPac.          getText().toString());
        product.setUnity        (campoUnity.        getText().toString());
        product.setMark         (campoMark.         getText().toString());

        return product;
    }

    private int getNextKey(Product product) {
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(Product.class).max("id") == null){
            return 1;
        } else {
            return realm.where(product.getClass()).max("id").intValue() + 1;
        }
    }

    private int getNextKey(ProductPrice productPrice) {
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(ProductPrice.class).max("id") == null){
            return 1;
        } else {
            return realm.where(productPrice.getClass()).max("id").intValue() + 1;
        }
    }
}
