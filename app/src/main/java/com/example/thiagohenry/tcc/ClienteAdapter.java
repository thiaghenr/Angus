package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Cliente;

import java.util.List;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class ClienteAdapter extends BaseAdapter {

    private final List<Cliente> clientes;
    private final Activity act;

    public ClienteAdapter(List<Cliente> clientes, Activity act) {
        this.clientes = clientes;
        this.act = act;
    }

    public int getCount() {
        return clientes.size();
    }

    public Object getItem(int position) {
        return clientes.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.cliente_lista_custom_by_line, parent, false);

        Cliente cliente = clientes.get(position);

        TextView name           = (TextView) view.findViewById(R.id.name);
        name.setText(cliente.getName());

        TextView fantasy_name   = (TextView) view.findViewById(R.id.fantasy_name);
        fantasy_name.setText(cliente.getFantasy_name());

        TextView phone          = (TextView) view.findViewById(R.id.phone1);
        phone.setText("Phone: " + cliente.getPhone_1());

        return view;
    }
}
