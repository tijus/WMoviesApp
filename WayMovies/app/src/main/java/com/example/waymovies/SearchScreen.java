package com.example.waymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchScreen extends AppCompatActivity implements Callback<Response>, SearchView.OnQueryTextListener {

    TextView searchText;
    RecyclerView searchView;
    SearchAdapter searchAdapter;
    SearchView searchBar;
    int count =0;
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        Bundle bundle = getIntent().getExtras();
        String query = bundle.getString("keyWord");
        Query.setQuery(query);

        Log.d("SearchActivityStart", "testt");
        mToolBar = (Toolbar) findViewById(R.id.searchToolBar);
        searchText = (TextView)findViewById(R.id.searchText);
        searchText.setText("Search Results for '"+ Query.getQuery()+"'");

        searchView = findViewById(R.id.searchView);

        searchBar = findViewById(R.id.searchBar);
        searchBar.setOnQueryTextListener(this);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        this.callApi();
    }

    public void callApi() {

        Log.e("testAPI", "testApiCalls"+(++count));
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIInterface testApi = retrofit.create(APIInterface.class);
        Call<Response> apiCall = testApi.callApi(ImmutableMap.<String, String>of("api_key",Query.API_KEY, "query", Query.getQuery()));
        apiCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
        if(response.isSuccessful()) {
            Response res = response.body();
            // Log.v("PAGE_NO", String.valueOf(res.getPage()));

            List<Result> results = res.getResults();

            searchAdapter = new SearchAdapter();
            searchView.setAdapter(searchAdapter);
            searchView.setLayoutManager(new GridLayoutManager(this, 1));

            for(Result result: results) {
                String mediaType = result.getMediaType();
                //     Log.v("test$mediaType", mediaType);
                SearchResult searchResult = null;
                if(mediaType.equals("tv")) {
             //       Log.v("test$tvName", mediaType+", "+result.getName());
                    searchResult = new SearchResult(result.getName(), mediaType, result.getPosterPath(), R.color.sTVBg);
                } else if(mediaType.equals("movie")) {
               //     Log.v("test$movieTitle", result.getTitle());
                    searchResult = new SearchResult(result.getTitle(), mediaType, result.getPosterPath(), R.color.sMovieBg);
                } else if(mediaType.equals("person")) {
                 //   Log.v("test$personName", result.getName());
                    searchResult = new SearchResult(result.getName(), mediaType, result.getProfilePath(), R.color.sPersonBg);
                }
                searchAdapter.addData(searchResult);
            }
        } else {
            Log.e("APP ERROR", String.valueOf(response.errorBody().toString()));
        }
    }

    @Override
    public void onFailure(Call<Response> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchBar.clearFocus();
        if(!query.isEmpty()) {

            Query.setQuery(query);
            this.callApi();
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
