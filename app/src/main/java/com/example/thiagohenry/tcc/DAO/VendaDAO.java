package com.example.thiagohenry.tcc.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thiagohenry on 19/04/17.
 */

public class VendaDao extends SQLiteOpenHelper {

    public VendaDao(Context context) {
        super(context, "Tcc", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE app_request (id int(11) NOT NULL AUTO_INCREMENT, " +
                " client_id varchar(255) ,\n" +
                " payment_condition_id int(11),\n" +
                " status_id int(11) ,\n" +
                " courier int(11),\n" +
                " currency varchar(2),\n" +
                " observation varchar(255) ,\n" +
                " VALOR decimal(15,2),\n" +
                " discount decimal(15,2),\n" +
                " value_total decimal(15,2),\n" +
                " value_total_invoiced` decimal(10,2),\n" +
                " status_erp varchar(50) ,\n" +
                " request_date datetime ,\n" +
                " last_update datetime,\n" +
                " sap_error_code varchar(200) ,\n" +
                " user_id` int(11),\n" +
                " app_id varchar(255) ,\n" +
                " sap_error_message varchar(200) ,\n" +
                " mobile_version varchar(40) ,\n" +
                "  PRIMARY KEY (`id`),\n" +
                ");";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS app_request";
        db.execSQL(sql);
        onCreate(db);
    }


}
