package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Produto;

import java.util.List;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProdutoAdapter extends BaseAdapter{
    private final List<Produto> produtos;
    private final Activity act;

    public ProdutoAdapter(List<Produto> produtos, Activity act) {
        this.produtos = produtos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.produto_lista_custom_by_line, parent, false);

        Produto produto = produtos.get(position);

        TextView name           = (TextView) view.findViewById(R.id.name);
        name.setText(produto.getName());

        TextView description    = (TextView) view.findViewById(R.id.description);
        description.setText(produto.getDescription());

        TextView category       = (TextView) view.findViewById(R.id.category);
        category.setText(produto.getCategory());

        TextView pac            = (TextView) view.findViewById(R.id.pac);
        pac.setText(produto.getPac());
        //TextView qtd            = (TextView)  view.findViewById(R.id.qtd);
        //TextView price          = (TextView)  view.findViewById(R.id.price);
        return view;
    }
}
