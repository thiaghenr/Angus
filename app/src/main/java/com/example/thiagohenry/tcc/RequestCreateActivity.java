package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;
import com.example.thiagohenry.tcc.Model.Status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static android.R.attr.contentAgeHint;
import static android.R.attr.id;
import static android.R.attr.isScrollContainer;
import static com.example.thiagohenry.tcc.R.id.container;


/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateActivity extends AppCompatActivity {
    Realm realm;
    private RequestSectionsPageAdapter vRequestSectionsPageAdapter;
    private ViewPager                   requestViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_create);

        vRequestSectionsPageAdapter = new RequestSectionsPageAdapter(getSupportFragmentManager());

        requestViewPager = (ViewPager) findViewById(container);
        setupViewPager(requestViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(requestViewPager);

        // Create request
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Request request = new Request();

        request.setId((long) getNextKey(request));
        //request.setLast_update(now);

        realm.copyToRealm(request);
        realm.commitTransaction();
        realm.close();

        // Update Request created above and set status "Open"
        realm.beginTransaction();

        Request r = realm.where(Request.class).findAll().last();

        RealmQuery<Status> query_status = realm.where(Status.class).contains("description", "Aberto");
        RealmResults<Status> result_status = query_status.findAll();

        Status status   = realm.where(Status.class).equalTo("id", result_status.get(0).getId()).findFirst();
        Date today = new Date();

        // Here we set some default datas to start the request
        r.setStatus_id          (status);
        r.setCurrency("U$");
        r.setDue_date(today);
        r.setValue_total(0.0);

        realm.insertOrUpdate(r);
        realm.commitTransaction();
        realm.refresh();
        realm.close();
    }

    private void setupViewPager(ViewPager viewPager){
        RequestSectionsPageAdapter adapter  = new RequestSectionsPageAdapter(getSupportFragmentManager());
        
            adapter.addFragment(new RequestCreateTabCustomer(), "Cliente");
            adapter.addFragment(new RequestCreateTabProduct(),  "Producto");
            adapter.addFragment(new RequestCreateTabCart(),     "Carrito");
            adapter.addFragment(new RequestCreateTabDelivery(), "Entrega");
            viewPager.setAdapter(adapter);
    }

    private int getNextKey(Request request) {
        // That's the default function to generate id
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(Request.class).max("id") == null){
            return 1;
        } else {
            return realm.where(request.getClass()).max("id").intValue() + 1;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Delete Request when the user back to main menu
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Request request = realm.where(Request.class).findAll().last();

        RealmQuery<RequestItem> requestItemRealmQuery       = realm.where(RequestItem.class).equalTo("request_id.id", request.getId());
        RealmResults<RequestItem> requestItemRealmResults   = requestItemRealmQuery.findAll();

        for (int i = requestItemRealmResults.size() - 1; i >= 0; i--){
            // Delete itens from list and from requestItem table in realm database
            RequestCreateTabProduct.listItems.remove(requestItemRealmResults.get(i));
            requestItemRealmResults.deleteFromRealm(i);
        }
        // Could used "deleteAllFromRealm" but we needed delete the itens from list too
        //requestItemRealmResults.deleteAllFromRealm();
        request.deleteFromRealm();
        realm.commitTransaction();

        Intent act_cust = new Intent(this, DashboardActivity.class);
        RequestCreateActivity.this.finish();
        startActivity(act_cust);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
