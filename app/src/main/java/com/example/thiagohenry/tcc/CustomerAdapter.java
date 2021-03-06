package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;

import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class CustomerAdapter extends BaseAdapter {

    private List<Customer> customers;
    private Activity act;
    //private TextWatcher textWatcher;
    //private RequestCreateTabCustomerSelectedFragment textWatcher;
    //private RealmResults<Customer> result1;

    public CustomerAdapter(List<Customer> customers, Activity act) {
        this.customers = customers;
        this.act = act;
    }

    public CustomerAdapter(List<Customer> customers /*RequestCreateTabCustomerSelectedFragment textWatcher*/) {
        this.customers = customers;
        //this.textWatcher = textWatcher;
    }

    public int getCount() {
        return customers.size();
    }

    public Object getItem(int position) {
        return customers.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // In this function we build the line with the details of the customer
        View view = act.getLayoutInflater().inflate(R.layout.customer_list_custom_by_line, parent, false);

        Customer customer = customers.get(position);

        TextView code           = (TextView) view.findViewById(R.id.code);
        TextView name           = (TextView) view.findViewById(R.id.name);
        TextView fantasy_name   = (TextView) view.findViewById(R.id.fantasy_name);
        TextView phone          = (TextView) view.findViewById(R.id.phone1);

        code.setText        (               customer.getCode());
        name.setText        (               customer.getName());
        fantasy_name.setText(               customer.getFantasy_name());
        phone.setText       ("Phone: " +    customer.getPhone_1());

        return view;
    }
}
