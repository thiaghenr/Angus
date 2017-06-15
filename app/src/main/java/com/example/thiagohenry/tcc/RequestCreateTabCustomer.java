package com.example.thiagohenry.tcc;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

//import com.example.thiagohenry.tcc.DAO.CustomerDao;
import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.Status;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.internal.Util;

import static io.realm.Sort.DESCENDING;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabCustomer extends Fragment {
    private RequestSectionsPageAdapter mRequestSectionsPageAdapter;
    private RequestActivityHelper helper;
    private static View request_create_tab_customer_view;
    private static final String TAG = "RequestCreateTabCustomer";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view1 = inflater.inflate(R.layout.request_create_tab_customer, container, false);
        request_create_tab_customer_view = view1;
        carregaListaCustomers(view1);
        view1.setVisibility(View.INVISIBLE);
//
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//
//        Request r = realm.where(Request.class).findAll().last();
//
//        RealmQuery<Status> query_status = realm.where(Status.class).contains("description", "Aberto");
//        RealmResults<Status> result_status = query_status.findAll();
//
//
//        Status status   = realm.where(Status.class).equalTo("id", result_status.get(0).getId()).findFirst();
//
//        r.setStatus_id          (status);
//
//        realm.insertOrUpdate(r);
//        realm.commitTransaction();
//        realm.close();

        return view1;
    }

    public void carregaListaCustomers(final View view) {

        final TextView search           = (EditText)    view.findViewById(R.id.inputSearch);
        final Switch filter_by_code     = (Switch)      view.findViewById(R.id.filter_by_code);
        final Switch filter_by_name     = (Switch)      view.findViewById(R.id.filter_by_name);
        final Switch filter_by_phone    = (Switch)      view.findViewById(R.id.filter_by_phone);

        filter_by_code.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    filter_by_name.setChecked(false);
                    filter_by_phone.setChecked(false);
                }
            }
        });

        filter_by_name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked == true){
                    filter_by_code.setChecked(false);
                    filter_by_phone.setChecked(false);
                }
            }
        });

        filter_by_phone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked == true){
                    filter_by_code.setChecked(false);
                    filter_by_name.setChecked(false);
                }
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (filter_by_code.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Customer> query  = realm.where(Customer.class);

                    query.contains("code", String.valueOf(search.getText()));
                    final RealmResults<Customer> result1 = query.findAll();
                    final ListView ListCustomers = (ListView) view.findViewById(R.id.customer_list);

                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, getActivity());
                    ListCustomers.setAdapter(adapter);

                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View viewItem, final int position, long id) {

                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();

                        Request r = realm.where(Request.class).findAll().last();

                        Customer customer   = realm.where(Customer.class).equalTo("id", result1.get(position).getId()).findFirst();

                        r.setCustomer_id          (customer);
                        ArrayList<Customer> customers    = new ArrayList<>();
                        customers.add(customer);
                        ListView listCusomersSelected = (ListView) view.findViewById(R.id.customer_selected_listed);
                        RequestCreateTabCustomerSelected customerAdapterSelected = new RequestCreateTabCustomerSelected(customers, getActivity());
                        listCusomersSelected.setAdapter(customerAdapterSelected);


//                        final TextView  name            =   (TextView) view.findViewById(R.id.name_edit);
//                        final TextView  fantasy_name    =   (TextView) view.findViewById(R.id.fantasy_name_edit);
//                        final TextView  phone           =   (TextView) view.findViewById(R.id.phone_edit);
//
//                        name.setText(           customer.getName());
//                        fantasy_name.setText(   customer.getFantasy_name());
//                        phone.setText(          customer.getPhone_1());

                        realm.insertOrUpdate(r);

                        realm.commitTransaction();
                        realm.close();
                        }
                    });
                }
                else if (filter_by_name.isChecked() == true){

                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Customer> query  = realm.where(Customer.class);

                    query.contains("name", String.valueOf(search.getText()));
                    final RealmResults<Customer> result1 = query.findAll();
                    final ListView ListCustomers = (ListView) view.findViewById(R.id.customer_list);

                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, getActivity());
                    ListCustomers.setAdapter(adapter);

                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(getActivity(), RequestCreateActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("id", result1.get(position).getId());
                            bundle.putString("fragment", "customer");
                            act_cust.putExtras(bundle);
                            startActivity(act_cust);
                        }
                    });
                }
                else if (filter_by_phone.isChecked() == true){
                    Realm realm                 = Realm.getDefaultInstance();
                    RealmQuery<Customer> query  = realm.where(Customer.class);

                    query.contains("phone_1", String.valueOf(search.getText()));
                    final RealmResults<Customer> result1 = query.findAll();
                    final ListView ListCustomers = (ListView) view.findViewById(R.id.customer_list);

                    RequestCreateTabCustomerAdapter adapter = new RequestCreateTabCustomerAdapter(result1, getActivity());
                    ListCustomers.setAdapter(adapter);

                    ListCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Intent act_cust = new Intent(getActivity(), RequestCreateActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putLong("id", result1.get(position).getId());
                            bundle.putString("fragment", "customer");
                            act_cust.putExtras(bundle);
                            startActivity(act_cust);
                        }
                    });
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
                //Toast.makeText(act, "beforechanged", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Toast.makeText(act, "afterchanged", Toast.LENGTH_SHORT).show();
                //search.setError(null);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        carregaListaCustomers(getView());
    }
}


