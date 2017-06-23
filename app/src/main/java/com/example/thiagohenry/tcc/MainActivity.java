package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Connection.iConnection;
import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Price;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.ProductPrice;
import com.example.thiagohenry.tcc.Model.ProductStock;
import com.example.thiagohenry.tcc.Model.Status;
import com.example.thiagohenry.tcc.Model.User;
import com.google.gson.JsonArray;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Realm realm = Realm.getDefaultInstance();
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.beginTransaction();
//                //User
//                User user = realm.createObject(User.class);
//                user.setId((long) 10.0);
//                user.setName("John");
//                user.setLastName("malkovich");
//                user.setUsername("4");
//                user.setPassword("4");
//
//                // Customer
//                Customer customer = realm.createObject(Customer.class);
//                customer.setId((long) 2);
//                customer.setCode("2");
//                customer.setFantasy_name("fantasy name");
//                customer.setName("Jooseeee");
//                customer.setCurrency("U$");
//                customer.setEmail("j@gmail.com");
//                customer.setPhone_1("3333-3333");
//                customer.setPhone_2("5555-5555");
//                customer.setRuc("2222");
//
//                // CUSTOMER ADdress
//                CustomerAddress customerAddress = realm.createObject(CustomerAddress.class);
//                customerAddress.setId((long) 2);
//                customerAddress.setCustomer(customer);
//                customerAddress.setStreet("Rua Taruma");
//                customerAddress.setBlock("Centro");
//                customerAddress.setCity("Foz");
//                customerAddress.setState("Parana");
//                customerAddress.setCountry("Brasil");
//
//                // Price
//                Price price = realm.createObject(Price.class);
//                price.setId((long) 3);
//                price.setName("preço 1");
//
//                //Product
//                Product product = realm.createObject(Product.class);
//                product.setId((long) 3);
//                product.setName("Porta sanfonada p");
//                product.setDescription("porta sanfonada de plastico");
//                product.setCategory("Porta");
//                product.setMark("PortasBoas");
//                product.setUnity("UN");
//
//                //Product Price
//                ProductPrice productPrice = realm.createObject(ProductPrice.class);
//                productPrice.setId((long) 3);
//                productPrice.setProduct(product);
//                productPrice.setPrice(price);
//                productPrice.setCurrency("U$");
//                productPrice.setValue((double)1000);
//
//                // Product Stock
//                ProductStock productStock = realm.createObject(ProductStock.class);
//                productStock.setId((long) 2);
//                productStock.setProduct(product);
//                productStock.setBranch("CDE");
//                productStock.setQuantity(1000);
//
//                Status status = realm.createObject(Status.class);
//                status.setId((long) 1);
//                status.setDescription("EN MARCHA");
//
//                Status status2 = realm.createObject(Status.class);
//                status.setId((long) 2);
//                status.setDescription("");
//
//                realm.insert(user);
//                realm.insert(customer);
//                realm.insert(customerAddress);
//                realm.insert(price);
//                realm.insert(product);
//                realm.insert(productPrice);
//                realm.insert(productStock);
//                realm.insert(status);
//                realm.insert(status2);
//
//                realm.commitTransaction();
//                realm.close();
//            }
//        });

        final EditText username = (EditText)  findViewById(R.id.username);
        final EditText password = (EditText)  findViewById(R.id.password);
        final Button login      = (Button)    findViewById(R.id.btn_login);


//        if(ConnectionVerify() == true) {
//            syncUser();
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            checkUser(username.getText().toString(), password.getText().toString());
//                Intent act_dash = new Intent(getBaseContext(), DashboardActivity.class);
//                startActivity(act_dash);
                //checkUser(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private boolean checkUser(String username, String password) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> realmObjects = realm.where(User.class).findAll();
        for (User myRealmObject : realmObjects) {
            if (username.equals(myRealmObject.getUsername()) && password.equals(myRealmObject.getPassword())) {
                Toast.makeText(getApplicationContext(), "Olá " + username, Toast.LENGTH_LONG).show();
                Intent act_dash = new Intent(getBaseContext(), DashboardActivity.class);
                startActivity(act_dash);

                return true;
            }
        }
        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
        return false;
    }

    public void syncUser(){
        iConnection connection = iConnection.retrofit.create(iConnection.class);
        final Call<JsonArray> call = connection.getUsers();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                final JsonArray listaUsers = response.body();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createAllFromJson(User.class, listaUsers.toString());
                realm.commitTransaction();
                realm.close();
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public  boolean ConnectionVerify() {
        boolean connected;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null && conectivtyManager.getActiveNetworkInfo().isAvailable() && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            connected = true;
        } else {
            connected = false;
        }
        return connected;
    }
}
