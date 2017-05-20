package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by thiagohenry on 20/04/17.
 */

public class RequestActivityList extends AppCompatActivity{
    //Switch switchAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_search_request, menu);

        MenuItem itemSwitch = menu.findItem(R.id.switchId);

        itemSwitch.setActionView(R.layout.request_toogle_button_filter_code);

        //final Switch sw = (Switch) menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);

        //String[] request  =   {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        //ListView listaRequests = (ListView) findViewById(R.id.lista_requests);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(){this}

        Button new_request = (Button) findViewById(R.id.new_request);
        //System.out.println(new_request);
        new_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_form = new Intent(RequestActivityList.this, RequestCreateActivity.class);
                startActivity(go_to_form);
            }
        });

        //switchAB = (Switch) menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);

        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.filter_search_request, menu);
//
//        switchAB = (Switch)menu.findItem(R.id.switchId).getActionView().findViewById(R.id.switchAB);
//
//        switchAB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,
//                                         boolean isChecked) {
//                if (isChecked) {
//                    Toast.makeText(getApplication(), "ON", Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//                    Toast.makeText(getApplication(), "OFF", Toast.LENGTH_SHORT)
//                            .show();
//                }
//            }
//        });
//        return true;
//    }
}
