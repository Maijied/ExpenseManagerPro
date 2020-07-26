package com.example.expensemanagerpro;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
  @FormUrlEncoded
  @POST("save.php")
    Call<Income> saveIncome(
            @Field("name") String name,
            @Field("amount") int amount,
            @Field("category") String category,
            @Field("note") String note,
            @Field("color") int color
  );
}
