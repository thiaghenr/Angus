package com.example.thiagohenry.tcc;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thiagohenry.tcc.Model.Request;

import io.realm.Realm;

import static android.R.attr.contentAgeHint;
import static android.R.attr.id;
import static android.R.attr.isScrollContainer;
import static com.example.thiagohenry.tcc.R.id.container;


/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateActivity extends AppCompatActivity {
    private static final String TAG = "RequestCreateActivity";
    private RequestSectionsPageAdapter vRequestSectionsPageAdapter;
    private ViewPager requestViewPager;
    private Long id;
    private String act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_create);

        vRequestSectionsPageAdapter = new RequestSectionsPageAdapter(getSupportFragmentManager());
//        if (this.id == null){
//            this.id = (long) 0;
//        }
        // Set up the ViewPager with the sections adapter.
        requestViewPager = (ViewPager) findViewById(container);
        setupViewPager(requestViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(requestViewPager);

        Realm realm     = Realm.getDefaultInstance();
        realm.beginTransaction();
        Request request = new Request();

        request.setId((long) getNextKey(request));

        realm.copyToRealm(request);
        realm.commitTransaction();
    }

    private void setupViewPager(ViewPager viewPager){
        RequestSectionsPageAdapter adapter  = new RequestSectionsPageAdapter(getSupportFragmentManager());
//        final Realm realm                   = Realm.getDefaultInstance();
//        Bundle extras                       = getIntent().getExtras();
//
//        if (extras != null){
//            this.id         = extras.getLong("id", 0);
//            this.act        = extras.getString("fragment");
//        }
//
//        if(this.act != null && this.act.equals("customer")){
//            Bundle bundle                       = new Bundle();
//            bundle.putLong("id", id);
//            RequestCreateTabCustomer fragobj    = new RequestCreateTabCustomer();
//            fragobj.setArguments(bundle);
//            // AQUI DEVO FAZER UM IF PARA VERIFICAR SE JA EXISTE UM PRODUTO
//            adapter.addFragment(new RequestCreateTabCustomerSelected(),     "Cliente");
//            adapter.addFragment(new RequestCreateTabProduct(), "Producto");
//            adapter.addFragment(new RequestCreateTabPayment(), "Pago");
//            adapter.addFragment(new RequestCreateTabDelivery(), "Entrega");
//
//            viewPager.setAdapter(adapter);
//            viewPager.setCurrentItem(0);
//        }
//
//        if(this.act != null && this.act.equals("product")){
//            Bundle bundle                   = new Bundle();
//            bundle.putLong("id", id);
//            RequestCreateTabProduct fragobj = new RequestCreateTabProduct();
//            fragobj.setArguments(bundle);
//            // AQUI DEVO FAZER UM IF PARA VERIFICAR SE JA EXISTE UM CLIENTE
//            adapter.addFragment(new RequestCreateTabCustomerSelected(), "Cliente");
//            adapter.addFragment(new RequestCreateTabProductSelected(),  "Producto");
//            adapter.addFragment(new RequestCreateTabPayment(),          "Pago");
//            adapter.addFragment(new RequestCreateTabDelivery(),         "Entrega");
//
//            viewPager.setAdapter(adapter);
//            viewPager.setCurrentItem(1);
//        }
//
//        if (extras == null) {
            adapter.addFragment(new RequestCreateTabCustomerListFragment(), "Cliente");
            adapter.addFragment(new RequestCreateTabProduct(),  "Producto");
            adapter.addFragment(new RequestCreateTabPayment(),  "Pago");
            adapter.addFragment(new RequestCreateTabDelivery(), "Entrega");
            viewPager.setAdapter(adapter);
        //}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.request_create_action_button, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private int getNextKey(Request request) {
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(Request.class).max("id") == null){
            return 1;
        } else {
            return realm.where(request.getClass()).max("id").intValue() + 1;
        }
    }
}
