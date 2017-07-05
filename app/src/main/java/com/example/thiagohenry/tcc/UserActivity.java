package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Connection.iConnection;
import com.example.thiagohenry.tcc.Model.User;
import com.google.gson.JsonArray;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity{
    private AppCompatActivity act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        act = this;

        TextView name                       = (TextView) findViewById(R.id.name);
        TextView last_name                  = (TextView) findViewById(R.id.last_name);
        final EditText username             = (EditText) findViewById(R.id.username);
        final EditText password             = (EditText) findViewById(R.id.password);
        final EditText confirm_password     = (EditText) findViewById(R.id.confirm_password);
        Button   change_password            = (Button)   findViewById(R.id.change_password);

        final Realm realm = Realm.getDefaultInstance();

        final User user = realm.where(User.class).equalTo("logged", true).findFirst();

        name.setText        (user.getName());
        last_name.setText   (user.getLastName());
        username.setText    (user.getUsername());

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().trim().matches(confirm_password.getText().toString().trim())){
                    realm.beginTransaction();
                    if(password.getText().toString() == "" || confirm_password.getText().toString() == ""){
                        return;
                    }
                    user.setPassword(password.getText().toString());
                    user.setConfirmPassword(confirm_password.getText().toString());
                    user.setUsername(username.getText().toString());
                    realm.insertOrUpdate(user);
                    realm.commitTransaction();
                    realm.close();

                    Toast.makeText(getBaseContext(), "Contraseña intercambiada con éxito", Toast.LENGTH_LONG).show();
                    Intent act_dash = new Intent(act, DashboardActivity.class);
                    startActivity(act_dash);
                } else {
                    Toast.makeText(getBaseContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

