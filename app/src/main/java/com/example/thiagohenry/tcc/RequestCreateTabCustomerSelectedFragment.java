//package com.example.thiagohenry.tcc;
//
//import android.support.v4.app.Fragment;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//
//import com.example.thiagohenry.tcc.Model.Customer;
//import com.example.thiagohenry.tcc.Model.Request;

//import java.util.List;
//
//import io.realm.Realm;
//import io.realm.RealmQuery;
//import io.realm.RealmResults;
//
///**
// * Created by thiagohenry on 16/04/17.
// */
//
//public class RequestCreateTabCustomerSelectedFragment extends Fragment {
//    private static final String TAG = "RequestCreateTabCustomerSelected";
//    private Long id;
//
//    @Nullable
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        final View view = inflater.inflate(R.layout.request_create_tab_customer_selected, container, false);
//
//        final Realm realm = Realm.getDefaultInstance();
//        RealmResults<Request> id = realm.where(Request.class).findAllSorted("last_update");
//        long lastInsertedId = id.last().getId();
//        Customer c = id.last().getCustomer_id();
//        //final long id           = getActivity().getIntent().getExtras().getLong("id");
//        System.out.println(lastInsertedId);
//        System.out.println(c);
//        //final Customer customer = realm.where(Customer.class).equalTo("id", id).findFirst();
//        //System.out.println(customer.getId());
//        //final EditText  code            =   (EditText) view.findViewById(R.id.code_edit);
//        final EditText  name            =   (EditText) view.findViewById(R.id.name_edit);
//        final EditText  fantasy_name    =   (EditText) view.findViewById(R.id.fantasy_name_edit);
//        final EditText  phone           =   (EditText) view.findViewById(R.id.phone_edit);
//
//        //System.out.println(customer.getName());
//        name.setText(           c.getName());
//        fantasy_name.setText(   c.getFantasy_name());
//        phone.setText(          c.getPhone_1());
//
//        view.setVisibility(View.VISIBLE);
//        return view;
//    }
//}


