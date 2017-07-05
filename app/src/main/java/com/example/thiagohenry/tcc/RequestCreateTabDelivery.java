package com.example.thiagohenry.tcc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiagohenry.tcc.Model.Customer;
import com.example.thiagohenry.tcc.Model.Product;
import com.example.thiagohenry.tcc.Model.Request;
import com.example.thiagohenry.tcc.Model.RequestItem;
import com.example.thiagohenry.tcc.Model.Status;
import com.example.thiagohenry.tcc.Model.User;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.zip.Inflater;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static android.view.View.inflate;
import static com.example.thiagohenry.tcc.R.id.action_context_bar;
import static com.example.thiagohenry.tcc.R.id.container;
import static com.example.thiagohenry.tcc.RequestCreateTabCart.listItems;

/**
 * Created by thiagohenry on 16/04/17.
 */

public class RequestCreateTabDelivery extends Fragment{
    private static final String TAG = "RequestCreateTabDelivery";
    public static TextView total_request_value;;
    public String payment_condition;
    public Spinner spinner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.request_create_tab_delivery, container, false);
        total_request_value = (TextView) view.findViewById(R.id.request_total_value);
        spinner = (Spinner) view.findViewById(R.id.spinner_condicao);

        finishSale(view);
        populateSpinnerCondicao(view);
        populateSpinnerFatura(view);
        setTotalRequestValue();
        return view;
    }

    public void finishSale(final View view){
        final Button finish_sale    = (Button)      view.findViewById(R.id.finish_sale);

        finish_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            listItems.clear();
            ProgressDialog dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Carregando...");
            dialog.setCancelable(false);
            dialog.show();
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Request request = realm.where(Request.class).findAll().last();

            // Set status "NO PAGADO" to request
            Status status   = realm.where(Status.class).equalTo("description", "NO PAGADO").findFirst();
            request.setStatus_id(status);

            // Set logged user to request
            User user = realm.where(User.class).equalTo("logged", true).findFirst();
            request.setUser_id(user);

            request.setSync(0);

            Date date = request.getDue_date();

            payment_condition = spinner.getSelectedItem().toString();

            System.out.println(payment_condition);

            if (payment_condition.equals("30 dias")){
                request.setDue_date(addOneMonth(date));
            }
            else if (payment_condition.equals("60 dias")){
                request.setDue_date(addTwoMonths(date));
            }
            else if (payment_condition.equals("90 dias")){
                request.setDue_date((addThreeMonths(date)));
            }

            realm.insertOrUpdate(request);
            realm.commitTransaction();
            realm.close();

            onDestroyView();

            timerDelayRemoveDialog(1000, dialog);
            }
        });
    }

    public void populateSpinnerCondicao(View view){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.condicao_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                Object item = parent.getItemAtPosition(pos);
//            }
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

        System.out.println(payment_condition);
    }

    public void populateSpinnerFatura(View view){

        Spinner spinner                     = (Spinner) view.findViewById(R.id.spinner_fatura);
        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this.getContext(), R.array.fatura_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void timerDelayRemoveDialog(long time, final ProgressDialog d){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            d.dismiss();
            Toast.makeText(getContext(), "Venda Efetuada com Sucesso", Toast.LENGTH_LONG).show();
            Intent act_main = new Intent(getActivity(), DashboardActivity.class);
            startActivity(act_main);
            getActivity().finish();
            }
        }, time);
    }

    public void setTotalRequestValue(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Request request = realm.where(Request.class).findAll().last();
        total_request_value.setText(request.getValue_total().toString());
        realm.commitTransaction();
        realm.close();
    }

    public static Date addOneMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }

    public static Date addTwoMonths(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 2);
        return cal.getTime();
    }

    public static Date addThreeMonths(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public void onResume() {
        super.onResume();
        setTotalRequestValue();
    }
}
