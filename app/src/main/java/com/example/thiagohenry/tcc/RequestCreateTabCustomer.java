package com.example.thiagohenry.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

//import com.example.thiagohenry.tcc.DAO.CustomerDao;
import com.example.thiagohenry.tcc.Model.Customer;

import io.realm.Realm;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabCustomer extends Fragment{
    private static final String TAG = "RequestCreateTabCustomer";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(inflater + " inflateeeeer");
        final View view = inflater.inflate(R.layout.request_create_tab_customer, container, false);

//        final EditText  name            =   (EditText) view.findViewById(R.id.name_edit);
//        final EditText  fantasy_name    =   (EditText) view.findViewById(R.id.fantasy_name_edit);
//        final EditText  phone           =   (EditText) view.findViewById(R.id.phone_edit);

        if (getArguments() != null){
            String strtext = getArguments().getString("id");
            System.out.println(strtext + "olaaaaajsiasuinaisniansinansianiudbubfubusbchkbdshjkbsd");
        }

        final ImageButton tab_customer = (ImageButton) view.findViewById(R.id.tab_customer);
        //tab_customer.setVisibility(view.VISIBLE);

        tab_customer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent list_customer = new Intent (getActivity().getApplication(), CustomerActivityList.class);
                //startActivity(list_customer);
                tab_customer.setVisibility(view.INVISIBLE);
                startActivityForResult(list_customer, 1);
            }
        });

        return view;
    }
//
//    public void carregaListaCustomers(View view) {
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//
//        List<Customer> customers = realm.where(Customer.class).findAll();
//        ListView ListaCustomers = (ListView) view.findViewById(R.id.customer_list);
//        CustomerAdapter adapter = new CustomerAdapter(customers, this.getActivity());
//        ListaCustomers.setAdapter(adapter);
//
//        realm.commitTransaction();
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        System.out.println(getArguments() + " arguments");
//        if (getArguments() != null){
//            String strtext = getArguments().getString("id");
//            System.out.println(strtext + "olaaaaajsiasuinaiiansinansianiudbubfubusbchkbdshjkbsd");
//        }
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//////        System.out.println("aa");
//////        LayoutInflater inflater = LayoutInflater.from(getContext());
//        ViewGroup container = null;
////        final View view = inflater.inflate(R.layout.request_create_tab_customer_list, container, false);
//////        //view.bringToFront();
//////        //view.forceLayout();
////          view.setVisibility(View.VISIBLE);
////        System.out.println(view + " view  ");
//        //final RelativeLayout list = (RelativeLayout) view.findViewById(R.id.new_request_tab_customer);
//        //tab_customer.setVisibility(view.VISIBLE);
//        //list.setVisibility(view.VISIBLE);
////        System.out.println(view + " view");
////        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////        LinearLayout myRoot = new LinearLayout(getContext());
////        View itemView = inflater.inflate(R.layout.request_create_tab_customer_list, myRoot);
//
////        View v;
////        View a = getView()findViewById();
////
////        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        //LinearLayout myRoot = new LinearLayout(getContext());
//        final View itemView = getActivity().getLayoutInflater().inflate(R.layout.request_create_tab_customer_list, container);
//
//        final Realm realm = Realm.getDefaultInstance();
//
//        final long id           = resultCode;
//
//        System.out.println(id + " id......");
//        final Customer customer = realm.where(Customer.class).equalTo("id", id).findFirst();
//        System.out.println(customer.getId() + " customer.getId");
//        final EditText  name            =   (EditText) itemView.findViewById(R.id.name_edit);
//        final EditText  fantasy_name    =   (EditText) itemView.findViewById(R.id.fantasy_name_edit);
//        final EditText  phone           =   (EditText) itemView.findViewById(R.id.phone_edit);
//        System.out.println(name);
//        System.out.println(customer.getName());
//        name.setText(           customer.getName());
//        fantasy_name.setText(   customer.getFantasy_name());
//        phone.setText(          customer.getPhone_1());
//
//        itemView.setVisibility(View.VISIBLE);
//        System.out.println(name);
//        System.out.println(fantasy_name);
//        System.out.println(phone);
//
//    }
////
////    public View listCustomer(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
////        final View view_list = inflater.inflate(R.layout.request_create_tab_customer_list, container, false);
////        return view_list;
////    }
}


