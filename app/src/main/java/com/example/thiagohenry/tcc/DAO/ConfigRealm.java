package com.example.thiagohenry.tcc.DAO;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

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
        Realm.setDefaultConfiguration(config);

//        // Example migration adding a new class
//        RealmMigration migration = new RealmMigration() {
//            @Override
//            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//
//                // DynamicRealm exposes an editable schema
//                RealmSchema schema = realm.getSchema();
//
//                // Migrate to version 1: Add a new class.
//                // Example:
//                // public Person extends RealmObject {
//                //     private String name;
//                //     private int age;
//                //     // getters and setters left out for brevity
//                // }
//                if (oldVersion == 0) {
//                    schema.create("Person")
//                            .addField("name", String.class)
//                            .addField("age", int.class);
//                    oldVersion++;
//                }
//
//                // Migrate to version 2: Add a primary key + object references
//                // Example:
//                // public Person extends RealmObject {
//                //     private String name;
//                //     @PrimaryKey
//                //     private int age;
//                //     private Dog favoriteDog;
//                //     private RealmList<Dog> dogs;
//                //     // getters and setters left out for brevity
//                // }
//                if (oldVersion == 1) {
//                    schema.get("Person")
//                            .addField("id", long.class, FieldAttribute.PRIMARY_KEY)
//                            .addRealmObjectField("favoriteDog", schema.get("Dog"))
//                            .addRealmListField("dogs", schema.get("Dog"));
//                    oldVersion++;
//                }
//            }
//        };
    }
}
