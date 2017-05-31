package com.example.thiagohenry.tcc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.thiagohenry.tcc.Model.Customer;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabCustomerSelected extends Fragment{
    private static final String TAG = "RequestCreateTabCustomerSelected";
    private Long id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.request_create_tab_customer_selected, container, false);

        final Realm realm = Realm.getDefaultInstance();
        final long id           = getActivity().getIntent().getExtras().getLong("id");
        System.out.println(id);
        final Customer customer = realm.where(Customer.class).equalTo("id", id).findFirst();
        //System.out.println(customer.getId());
        //final EditText  code            =   (EditText) view.findViewById(R.id.code_edit);
        final EditText  name            =   (EditText) view.findViewById(R.id.name_edit);
        final EditText  fantasy_name    =   (EditText) view.findViewById(R.id.fantasy_name_edit);
        final EditText  phone           =   (EditText) view.findViewById(R.id.phone_edit);

        //System.out.println(customer.getName());
        name.setText(           customer.getName());
        fantasy_name.setText(   customer.getFantasy_name());
        phone.setText(          customer.getPhone_1());

        return view;
    }

//    public void carregaCustomer(final View view) {
//        final Realm realm = Realm.getDefaultInstance();
//        System.out.println(getId() + "    ID CARREGADO ");
//        final long id           = view.ge
//                //getIntent().getLongExtra("id", 0);
//        //System.out.println(id);
//        final Customer customer = realm.where(Customer.class).equalTo("id", id).findFirst();
//        //System.out.println(customer.getId());
//        final EditText  name            =   (EditText) view.findViewById(R.id.name_edit);
//        final EditText  fantasy_name    =   (EditText) view.findViewById(R.id.fantasy_name_edit);
//        final EditText  phone           =   (EditText) view.findViewById(R.id.phone_edit);
//
//        //System.out.println(customer.getName());
//        name.setText(           customer.getName());
//        fantasy_name.setText(   customer.getFantasy_name());
//        phone.setText(          customer.getPhone_1());
//
//        realm.beginTransaction();
//        //Para Trazer um customer apenas
//        //Customer customer = realm.where(Customer.class).findFirst();
//
//        final List<Customer> customers = realm.where(Customer.class).findAll();
//        final ListView ListCustomers = (ListView) view.findViewById(R.id.customer_list);
//
//        CustomerAdapter adapter = new CustomerAdapter(customers, this);
//
//        ListCustomers.setAdapter(adapter);
//
////        ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Intent edit_customer = new Intent(CustomerActivityList.this, CustomerEditActivity.class);
////                edit_customer.putExtra("id", customers.get(position).getId());
////
////                System.out.println(customers.get(position).getId());
////                startActivity(edit_customer);
////            }
////        });
//
//        realm.commitTransaction();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        carregaCustomer(getView());
//    }
}


