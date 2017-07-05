package com.example.thiagohenry.tcc.DAO;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by thiagohenry on 27/04/17.
 */

public class ConfigRealm extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        // creation of the Realm configuration
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        //Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }
}
