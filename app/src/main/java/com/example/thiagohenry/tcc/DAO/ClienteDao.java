package com.example.thiagohenry.tcc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.thiagohenry.tcc.Model.Cliente;
import com.example.thiagohenry.tcc.VendaCreateTabCliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ClienteDao extends SQLiteOpenHelper{

    public ClienteDao(Context context) {
        super(context, "Tcc", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE app_client(id INTEGER PRIMARY KEY, price_id varchar(255), name varchar(255), fantasy_name varchar(255), ruc varchar(30), currency varchar(5), contact varchar(100), phone1 varchar(30), phone2 varchar(30), seller int(11), last_update varchar(30), app_id varchar(255));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("cliente" + db);
        String sql = "DROP TABLE IF EXISTS app_client";
        db.execSQL(sql);
        onCreate(db);
    }

    public void Insert(Cliente cliente) {

        SQLiteDatabase db   = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("name",           cliente.getName());
        dados.put("fantasy_name",   cliente.getFantasy_name());
        dados.put("phone1",         cliente.getPhone_1());
        //dados.put("last_update",    System.currentTimeMillis());

        db.insert("app_client", null, dados);
    }

    public List<Cliente> buscaClientes() {

        String sql              = "SELECT * FROM app_client;";
        SQLiteDatabase db       = getReadableDatabase();
        Cursor c                = db.rawQuery(sql, null);
        List<Cliente> clientes  = new ArrayList<Cliente>();

        while (c.moveToNext()){
            Cliente cliente = new Cliente();

            cliente.setName         (c.getString(c.getColumnIndex("name")));
            cliente.setFantasy_name (c.getString(c.getColumnIndex("fantasy_name")));
            cliente.setPhone_1      (c.getString(c.getColumnIndex("phone1")));

            clientes.add(cliente);
        }

        c.close();
        System.out.println(clientes);
        return clientes;
    }
}
