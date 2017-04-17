package com.example.thiagohenry.tcc;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


/**
 * Created by thiagohenry on 16/04/17.
 */

public class VendaCreateActivity extends AppCompatActivity {
    private static final String TAG = "VendaCreateActivity";
    private VendasSectionsPageAdapter vVendasSectionsPageAdapter;
    private ViewPager vendaViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.venda_create);

        vVendasSectionsPageAdapter = new VendasSectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        vendaViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(vendaViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vendaViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        VendasSectionsPageAdapter adapter = new VendasSectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new VendaCreateTabCliente(),    "Cliente");
        adapter.addFragment(new VendaCreateTabProduto(),    "Produto");
        adapter.addFragment(new VendaCreateTabPagamento(),  "Pagamento");
        adapter.addFragment(new VendaCreateTabEntrega(),    "Entrega");

        viewPager.setAdapter(adapter);
    }
}
