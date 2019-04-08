package com.example.waymovies;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

    String movie;
    String mediaType;
    String imageUrl;
    int colorType;

    public SearchResult(String movie, String mediaType, String imageUrl, int colorType) {
        this.movie = movie;
        this.mediaType = mediaType;
        this.imageUrl = imageUrl;
        this.colorType = colorType;
    }

}
