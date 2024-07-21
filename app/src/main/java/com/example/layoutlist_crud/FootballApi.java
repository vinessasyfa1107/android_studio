package com.example.layoutlist_crud;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballApi {
    @GET("apa.json")
    Call<PlayerResponse<PlayerItem>> getPlayer();

}
