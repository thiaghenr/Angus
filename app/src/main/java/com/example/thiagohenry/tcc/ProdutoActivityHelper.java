package com.example.thiagohenry.tcc;

import android.widget.EditText;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Produto;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class ProdutoActivityHelper {

    private final TextView campoName;
    private final TextView campoDescription;
    private final TextView campoCategory;
    private final TextView campoPac;

    public ProdutoActivityHelper(ProdutoCreateActivity produtoCreateActivity) {

        campoName           = (TextView) produtoCreateActivity.findViewById(R.id.name);
        campoDescription    = (TextView) produtoCreateActivity.findViewById(R.id.description);
        campoCategory       = (TextView) produtoCreateActivity.findViewById(R.id.category);
        campoPac            = (TextView) produtoCreateActivity.findViewById(R.id.pac);

    }

    public Produto pegaProduto() {
        Produto produto = new Produto();

        produto.setName         (campoName.getText().toString());
        produto.setDescription  (campoDescription.getText().toString());
        produto.setCategory     (campoCategory.getText().toString());
        produto.setPac          (campoPac.getText().toString());

        return produto;
    }
}
