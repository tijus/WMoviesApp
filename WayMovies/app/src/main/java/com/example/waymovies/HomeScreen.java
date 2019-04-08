package com.example.waymovies;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView browseText;
    private SearchView searchView;
    private SimpleDraweeView bgImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        browseText = (TextView)findViewById(R.id.browse);
        searchView = (SearchView)findViewById(R.id.search);

        browseText.setOnClickListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("testsubmit", "testSubmit");
                // Toast.makeText(this, query, Toast.LENGTH_LONG).show();
                searchView.clearFocus();
                Intent i = new Intent(HomeScreen.this, SearchScreen.class);
                Bundle bundle = new Bundle();
                // TODO: add checks for no keyword
                bundle.putString("keyWord", query);
                i.putExtras(bundle);
                startActivity(i);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        Uri uri = Uri.parse("https://image.tmdb.org/t/p/original/uxzzxijgPIY7slzFvMotPv8wjKA.jpg");
        bgImage = (SimpleDraweeView) findViewById(R.id.bg_image);
        bgImage.setImageURI(uri);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.browse:
                Intent browseInent = new Intent(this, BrowseScreen.class);
                startActivity(browseInent);
                break;
        }
    }

}
