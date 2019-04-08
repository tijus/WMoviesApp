package com.example.waymovies;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements View.OnClickListener {

    public List<SearchResult> data = new ArrayList<>();

    // List<SearchResult> data = SearchData.getData();
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchViewHolder searchViewHolder, int index) {

        // TODO: handle empty result
            String text = data.get(index).mediaType + data.get(index).movie;
            Log.e("test$debugData", text);
            String url = "https://image.tmdb.org/t/p/original"+data.get(index).imageUrl;
            Uri uri = Uri.parse(url);
            searchViewHolder.itemImage.setImageURI(uri);
            searchViewHolder.itemTitle.setText(data.get(index).movie);
            searchViewHolder.itemType.setText(data.get(index).mediaType.toUpperCase());
            searchViewHolder.itemType.setBackgroundResource(data.get(index).colorType);
            searchViewHolder.itemImage.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(SearchResult newSearchResult) {
        data.add(newSearchResult);
    }

    public List<SearchResult> getData() {
        return data;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(v.getContext(), DetailScreen.class);
        v.getContext().startActivity(intent);
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle, itemType;
        SimpleDraweeView itemImage;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.item_title);
            itemImage = itemView.findViewById(R.id.item_image);
            itemType = itemView.findViewById(R.id.item_media_type);
        }
    }
}
