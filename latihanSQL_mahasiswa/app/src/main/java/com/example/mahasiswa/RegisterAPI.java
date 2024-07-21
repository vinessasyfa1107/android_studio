package com.example.mahasiswa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface RegisterAPI {

    @FormUrlEncoded
    @POST("/webServiceTest/insert.php")
    Call<Value> daftar(@Field("nim") String nim,
                       @Field("nama") String nama,
                       @Field("tlp") String tlp,
                       @Field("prodi") String prodi);
}
