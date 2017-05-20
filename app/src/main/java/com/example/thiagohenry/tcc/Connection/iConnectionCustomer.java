package com.example.thiagohenry.tcc.Connection;

import com.example.thiagohenry.tcc.Model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by thiagohenry on 01/05/17.
 */

public interface iConnectionCustomer {
    @POST("customer/create")
    Call<Void> insertCustomer(@Body Customer customer);

    @GET("customer/list")
    //Quando retorna apenas um
    //Call<Customer> getCustomer(@Path("customer") String customer);
    Call<List<Customer>> getCustomer();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/Angus/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
