//package com.example.waymovies;
//
//
//import android.util.Log;
//
//import com.google.common.collect.ImmutableMap;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.io.IOException;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
// // String BASE_URL = "https://api.themoviedb.org/3/";
//public class Controller implements Callback<Response> {
//
//
//    public void start() {
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        APIInterface testApi = retrofit.create(APIInterface.class);
//        Call<Response> apiCall = testApi.callApi(ImmutableMap.<String, String>of("api_key",Query.API_KEY, "query", Query.getQuery()));
//        apiCall.enqueue(this);
//    }
//
//    @Override
//    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//        if(response.isSuccessful()) {
//            Response res = response.body();
//            Log.v("PAGE_NO", String.valueOf(res.getPage()));
//            List<Result> results = res.getResults();
//
//            for(Result result: results) {
//                String mediaType = result.getMediaType();
//            //     Log.v("test$mediaType", mediaType);
//                SearchResult searchResult = null;
//                if(mediaType.equals("tv")) {
//                    Log.v("test$tvName", mediaType+", "+result.getName());
//                    searchResult = new SearchResult(result.getName(), mediaType, result.getPosterPath());
//                } else if(mediaType.equals("movie")) {
//                    Log.v("test$movieTitle", result.getTitle());
//                    searchResult = new SearchResult(result.getTitle(), mediaType, result.getPosterPath());
//                } else if(mediaType.equals("person")) {
//                    Log.v("test$personName", result.getName());
//                    searchResult = new SearchResult(result.getName(), mediaType, result.getProfilePath());
//                }
//                SearchData.setData(searchResult);
//            }
//            Log.e("test$fromController", String.valueOf(SearchData.getData().size()));
//
//            // response successfully received..
//
//        } else {
//            Log.e("APP ERROR", String.valueOf(response.errorBody().toString()));
//        }
//    }
//
//    @Override
//    public void onFailure(Call<Response> call, Throwable t) {
//        t.printStackTrace();
//    }
//}
