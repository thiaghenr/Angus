package com.example.thiagohenry.tcc.Connection;

import com.example.thiagohenry.tcc.Model.Customer;
import com.google.gson.JsonArray;

import java.util.List;

import okhttp3.ResponseBody;
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

public interface iConnection {
    // This one will insert the request
//    @POST("customer/create")
//    Call<Void> insertCustomer(@Body Customer customer);

    @GET("route/app_client.php")
    //Quando retorna apenas um
    //Call<Customer> getCustomer(@Path("customer") String customer);
    Call<JsonArray> getCustomer();

    @GET("route/app_client_address.php")
    Call<JsonArray> getCustomerAddress();

    @GET("route/app_price.php")
    Call<JsonArray> getPrice();

    @GET("route/app_product.php")
    Call<JsonArray> getProduct();

    @GET("route/app_product_price.php")
    Call<JsonArray> getProductPrice();

    @GET("route/app_product_stock.php")
    Call<JsonArray> getProductStock();

    @GET("route/app_status.php")
    Call<JsonArray> getStatus();

    @GET("route/app_user.php")
    Call<JsonArray> getUsers();

//    @POST("pedido")
//    Call<Object> postRequest(@Body List<Request> request);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.aracruz.com.py/angus/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
