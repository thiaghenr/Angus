package com.example.thiagohenry.tcc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.CustomerAddress;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.Status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by thiagohenry on 26/04/17.
 */

public class RequestAdapter extends BaseAdapter {

    private List<Request> requests;
    private Activity act;

    public RequestAdapter(List<Request> requests, Activity act) {
        this.requests = requests;
        this.act = act;
    }

    public int getCount() {
        return requests.size();
    }

    public Object getItem(int position) {
        return requests.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater().inflate(R.layout.request_list_custom_by_line, parent, false);
        Request request = requests.get(position);
        System.out.println(request + "       Request" + " Position " + position);
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Customer> query_customer     = realm.where(Customer.class).equalTo("id", request.getCustomer_id().getId());
        RealmQuery<Status> query_status         = realm.where(Status.class).equalTo("id", request.getStatus_id().getId());

        RealmResults<Customer> result_customer  = query_customer.findAll();
        RealmResults<Status> result_status      = query_status.findAll();

        System.out.println(result_customer.get(0) + "         REsult Customer");

        if(result_customer.isLoaded() && result_status.isLoaded()){
            Customer customer_find = realm.where(Customer.class).equalTo("id", result_customer.get(0).getId()).findFirst();
            Status   status_find   = realm.where(Status.class).equalTo("id", result_status.get(0).getId()).findFirst();
            TextView customer           = (TextView) view.findViewById(R.id.customer);
            TextView status             = (TextView) view.findViewById(R.id.status);
            TextView currency           = (TextView) view.findViewById(R.id.currency);
            TextView due_date           = (TextView) view.findViewById(R.id.due_date);
            TextView total              = (TextView) view.findViewById(R.id.total);

            SimpleDateFormat due_date_request = request.getDue_date();

            customer.setText(customer_find.getName());
            status  .setText(status_find.getDescription());
            currency.setText(               request.getCurrency());
            due_date.setText(due_date_request.toString());
            total   .setText("55.000");

            return view;
        }
        return view;
    }
}
