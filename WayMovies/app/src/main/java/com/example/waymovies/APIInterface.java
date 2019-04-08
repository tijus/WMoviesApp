package com.example.waymovies;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIInterface {
    String query = Query.getQuery();
    @GET("search/multi")
    Call<Response> callApi(@QueryMap Map<String, String> queryParams);
}


