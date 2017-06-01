package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;

import java.util.List;

import io.realm.Realm;

public class ProductDetail extends AppCompatActivity {

    //   private ListView ListStock;
    //   private ListView ListPrice;

    private DetailHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_product);

        //      ListStock = (ListView) findViewById(R.id.list_stock);
        //      ListPrice = (ListView) findViewById(R.id.list_price);

        helper = new DetailHelper(this);

        Intent intent = getIntent();
        Product produto = (Product) intent.getSerializableExtra("produto");
        if(produto != null){
            helper.preencheFormulario(produto);
        }
    }

    private void buscaProdutoDetalhe(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<ProductStock> productsStock            = realm.where(ProductStock.class).findAll();
        ListView ProductsStockList                  = (ListView) findViewById(R.id.products_list);
        ProductDetailAdapterStock adapterStock      = new ProductDetailAdapterStock(productsStock, this);

        ProductsStockList.setAdapter((ListAdapter) adapterStock);

//        ProdutoDao dao = new ProdutoDao(this);
//        List<ProdutoStock> produtoStocks = dao.buscaProdutoDetalhe();
//        dao.close();
//
//        ListView ListaProdDet = (ListView) findViewById(R.id.list_stock);
//        ProdAdapterDetail adapterDetail = new ProdAdapterDetail(produtoStocks, this);
//        ListaProdDet.setAdapter(adapterDetail);
    }

    private void buscaProdutoDetalhePrice(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<ProductPrice> productPrice             = realm.where(ProductPrice.class).findAll();
        ListView ProductPricekList                  = (ListView) findViewById(R.id.list_price);
        ProductDetailAdapterPrice adapterPrice      = new ProductDetailAdapterPrice(productPrice, this);

        ProductPricekList.setAdapter(adapterPrice);

//        ListView ListaProdPrice = (ListView) findViewById(R.id.list_price);
//        ProdAdapterPrice adapterPrice = new ProdAdapterPrice(produtoPrices, this);
//        ListaProdPrice.setAdapter(adapterPrice);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscaProdutoDetalhe();
        buscaProdutoDetalhePrice();
    }


}
