package com.example.waymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

public class BrowseScreen extends AppCompatActivity {


    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_screen);

        mToolBar = findViewById(R.id.searchToolBar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.t_ratedRV);

        BrowseAdapter tAdapter = new BrowseAdapter();
        recyclerView.setAdapter(tAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, true));

        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");
        tAdapter.addString("data1");

    }


}
