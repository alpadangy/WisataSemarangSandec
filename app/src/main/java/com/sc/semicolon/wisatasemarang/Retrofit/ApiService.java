package com.sc.semicolon.wisatasemarang.Retrofit;

import com.sc.semicolon.wisatasemarang.Model.WisataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cis on 01/06/2018.
 */

public interface ApiService {

//    @GET("getwisata.php")
//    Call<ArrayList<WisataModel>> getWisata();

    @GET("wisata/getAllWisata.php")
    Call<ArrayList<WisataModel>> getWisata();
}
