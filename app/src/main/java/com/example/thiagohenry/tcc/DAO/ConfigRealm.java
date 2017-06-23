package com.example.thiagohenry.tcc.DAO;

import android.app.Application;
import android.net.wifi.WifiConfiguration;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;
import com.example.thiagohenry.tcc.Model.Status;
import com.example.thiagohenry.tcc.Model.User;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by thiagohenry on 27/04/17.
 */

public class ConfigRealm extends Application{
    final User user                       = new User();
    final Customer customer               = new Customer();
    final CustomerAddress customerAddress = new CustomerAddress();
    final Price price                     = new Price();
    final Product product                 = new Product();
    final ProductPrice productPrice       = new ProductPrice();
    final ProductStock productStock       = new ProductStock();
    final Status status                   = new Status();

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        // creation of the Realm configuration
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);

//        try (Realm realm = Realm.getDefaultInstance()) {
//            realm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//                    //Status status2                  = new Status();
//
//                    for (int i = 0; i < 1; i++) {
//                        System.out.println(i);
//                        //User
//                        user.setId((long) i);
//                        user.setName("John");
//                        user.setLastName("malkovich");
//                        user.setUsername("4");
//                        user.setPassword("4");
//                        realm.insert(user);
//                    }
//                    for (int i = 0; i < 1; i++) {
//                        // Customer
//                        customer.setId((long) i);
//                        customer.setCode("2");
//                        customer.setFantasy_name("fantasy name");
//                        customer.setName("Jooseeee");
//                        customer.setCurrency("U$");
//                        customer.setEmail("j@gmail.com");
//                        customer.setPhone_1("3333-3333");
//                        customer.setPhone_2("5555-5555");
//                        customer.setRuc("2222");
//                        realm.insert(customer);
//                    }
//                    for (int i = 0; i < 1; i++) {
//                        // CUSTOMER ADdress
//                        customerAddress.setId((long) i);
//                        customerAddress.setCustomer(customer);
//                        customerAddress.setStreet("Rua Taruma");
//                        customerAddress.setBlock("Centro");
//                        customerAddress.setCity("Foz");
//                        customerAddress.setState("Parana");
//                        customerAddress.setCountry("Brasil");
//                        realm.insert(customerAddress);
//                    }
//                    for (int i = 0; i < 1; i++) {
////                        // Price
//                        price.setId((long) i);
//                        price.setName("preço 1");
//                        realm.insert(price);
//                    }
//                    for (int i = 0; i < 1; i++) {
////                        //Product
//
//                        product.setId((long) i);
//                        product.setName("Porta sanfonada p");
//                        product.setDescription("porta sanfonada de plastico");
//                        product.setCategory("Porta");
//                        product.setMark("PortasBoas");
//                        product.setUnity("UN");
//                        realm.insert(product);
//                    }
//                    for (int i = 0; i < 1; i++) {
//                        //Product Price
//                        productPrice.setId((long) i + 2);
//                        productPrice.setProduct(product);
//                        productPrice.setPrice(price);
//                        productPrice.setCurrency("U$");
//                        productPrice.setValue((double) 1000);
//                        realm.insert(productPrice);
//                    }
//                    for (int i = 0; i < 1; i++) {
//                        // Product Stock
//
//                        productStock.setId((long) i);
//                        productStock.setProduct(product);
//                        productStock.setBranch("CDE");
//                        productStock.setQuantity(1000);
//                        realm.insert(productStock);
//                    }
//                    for (int i = 0; i < 1; i++) {
//                        status.setId((long) i);
//                        status.setDescription("EN MARCHA");
//                        realm.insert(status);
//                    }
////
////                        status.setId((long) i + 2);
////                        status.setDescription("");
////                        realm.insert(status2);
////                    }
//                }
//            });
//        }


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
