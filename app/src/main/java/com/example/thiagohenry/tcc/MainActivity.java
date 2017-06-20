package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.User;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText)  findViewById(R.id.username);
        final EditText password = (EditText)  findViewById(R.id.password);
        final Button login      = (Button)    findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act_dash = new Intent(getBaseContext(), DashboardActivity.class);
                startActivity(act_dash);
                //checkUser(username.getText().toString(), password.getText().toString());
            }
        });
    }

//    private boolean checkUser(String username, String password) {
//        Realm realm = Realm.getDefaultInstance();
//        RealmResults<User> realmObjects = realm.where(User.class).findAll();
//        for (User myRealmObject : realmObjects) {
//            if (username.equals(myRealmObject.getUsername()) && password.equals(myRealmObject.getPassword())) {
//                System.out.println("aa");
//                Toast.makeText(getApplicationContext(), "Olá " + username, Toast.LENGTH_LONG).show();
//                Intent act_dash = new Intent(getBaseContext(), DashboardActivity.class);
//                startActivity(act_dash);
//
//                return true;
//            }
//        }
//        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
//        return false;
//    }
}
