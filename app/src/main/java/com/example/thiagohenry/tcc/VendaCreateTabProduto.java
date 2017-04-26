package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thiagohenry.tcc.DAO.ProdutoDao;
import com.example.thiagohenry.tcc.Model.Produto;

import java.util.List;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class VendaCreateTabProduto extends Fragment{
    private static final String TAG = "VendaCreateTabProduto";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.venda_create_tab_produto, container, false);
        carregaListaProdutos(view);
        return view;
    }

    private void carregaListaProdutos(View view) {

        ProdutoDao dao          = new ProdutoDao(this.getContext());
        List<Produto> produtos  = dao.buscaProdutos();
        dao.close();

        ListView ListaProdutos = (ListView) view.findViewById(R.id.list_produtos);
        ProdutoAdapter adapter = new ProdutoAdapter(produtos, this.getActivity());
        ListaProdutos.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        carregaListaProdutos(getView());
    }
}
