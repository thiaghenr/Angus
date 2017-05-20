//package com.example.thiagohenry.tcc.DAO;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.thiagohenry.tcc.Model.Produto;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by thiagohenry on 25/04/17.
// */
//
//public class ProdutoDao extends SQLiteOpenHelper{
//
//
//    public ProdutoDao(Context context) {
//        super(context, "Tcc", null, 3);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql = "CREATE TABLE app_product(id INTEGER PRIMARY KEY, app_id int(50), name varchar(255), description varchar(255), category varchar(150), unity varchar(255), pac varchar(11), fee varchar(30), last_update varchar(100), mark varchar(255));";
//        db.execSQL(sql);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE IF EXISTS app_product";
//        db.execSQL(sql);
//        onCreate(db);
//    }
//
//    public void Insert(Produto produto) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues dados = new ContentValues();
//
//        dados.put("name",           produto.getName());
//        dados.put("description",    produto.getDescription());
//        dados.put("category",       produto.getCategory());
//        dados.put("pac",            produto.getPac());
//        dados.put("last_update",    System.currentTimeMillis());
//
//        db.insert("app_product", null, dados);
//    }
//
//    public List<Produto> buscaProdutos() {
//        String sql              = "SELECT * FROM app_product;";
//        SQLiteDatabase db       = getReadableDatabase();
//        Cursor c                = db.rawQuery(sql, null);
//        List<Produto> produtos  = new ArrayList<Produto>();
//
//        while (c.moveToNext()){
//            Produto produto = new Produto();
//
//            produto.setName         (c.getString(c.getColumnIndex("name")));
//            produto.setDescription  (c.getString(c.getColumnIndex("description")));
//            produto.setCategory     (c.getString(c.getColumnIndex("category")));
//            produto.setPac          (c.getString(c.getColumnIndex("pac")));
//
//            produtos.add(produto);
//        }
//        c.close();
//        return produtos;
//    }
//}
