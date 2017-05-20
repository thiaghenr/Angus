package com.example.thiagohenry.tcc;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import io.realm.Realm;

import static android.R.attr.id;


/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateActivity extends AppCompatActivity {
    private static final String TAG = "RequestCreateActivity";
    private RequestSectionsPageAdapter vRequestSectionsPageAdapter;
    private ViewPager requestViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_create);

        vRequestSectionsPageAdapter = new RequestSectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        requestViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(requestViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(requestViewPager);

        final Realm realm = Realm.getDefaultInstance();

        final long id           = getIntent().getLongExtra("id", 0);

        Bundle bundle = new Bundle();
        bundle.putLong("id", id);

        RequestCreateTabCustomer fragobj = new RequestCreateTabCustomer();
        fragobj.setArguments(bundle);
    }

    private void setupViewPager(ViewPager viewPager){
        RequestSectionsPageAdapter adapter = new RequestSectionsPageAdapter(getSupportFragmentManager());
        System.out.println(id + "iddddddddddddd");
        adapter.addFragment(new RequestCreateTabCustomer(),     "Cliente");
        adapter.addFragment(new RequestCreateTabProduct(),      "Producto");
        adapter.addFragment(new RequestCreateTabPayment(),      "Pago");
        adapter.addFragment(new RequestCreateTabDelivery(),     "Entrega");

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.request_create_action_button, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
