package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.app.admin.SystemUpdatePolicy;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;

import java.util.List;
import java.util.Queue;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class RequestCreateTabCustomerSelected extends BaseAdapter {

    private List<Customer> customers;
    private Activity act;
    //private TextWatcher textWatcher;
    //private RequestCreateTabCustomerSelectedFragment textWatcher;
    //private RealmResults<Customer> result1;

    public RequestCreateTabCustomerSelected(List<Customer> customers, Activity act) {
        this.customers = customers;
        this.act = act;
    }

//    public RequestCreateTabCustomerSelected(List<Customer> customers /*RequestCreateTabCustomerSelectedFragment textWatcher*/) {
//        this.customers = customers;
//        //this.textWatcher = textWatcher;
//    }



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

        View view = act.getLayoutInflater().inflate(R.layout.request_create_tab_customer_selected_by_line, parent, false);

        Customer  customer = customers.get(position);
        // Here we create the instance of Realm;
        Realm realm                     = Realm.getDefaultInstance();
        RealmQuery<Customer> query      = realm.where(Customer.class).equalTo("id", customer.getId());
        RealmResults<Customer> c        = query.findAll();
        // and here we build the "query" ("query" because in realm there's no join) to find the address by customer
        CustomerAddress customerAddress = realm.where(CustomerAddress.class).equalTo("customer_id.id", c.get(position).getId()).findFirst();

        TextView code           = (TextView) view.findViewById(R.id.code);
        TextView name           = (TextView) view.findViewById(R.id.name);
        TextView fantasy_name   = (TextView) view.findViewById(R.id.fantasy_name);
        TextView phone          = (TextView) view.findViewById(R.id.phone1);
        TextView street_name    = (TextView) view.findViewById(R.id.street_name);
        TextView block          = (TextView) view.findViewById(R.id.block_name);
        TextView city           = (TextView) view.findViewById(R.id.city_name);
        TextView country        = (TextView) view.findViewById(R.id.country_name);

        code.setText            (                 customer.getCode());
        name.setText            (                 customer.getName());
        fantasy_name.setText    (                 customer.getFantasy_name());
        phone.setText           ("Telefone: "   + customer.getPhone_1());
        street_name.setText     ("Calle : "     + customerAddress.getStreet());
        block.setText           ("Barrio: "     + customerAddress.getBlock());
        city.setText            ("Ciudad: "     + customerAddress.getCity());
        country.setText         ("País: "       + customerAddress.getCountry());


        return view;
    }
}
