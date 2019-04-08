package com.example.waymovies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseDataHolder> {

    ArrayList<String> data = new ArrayList<>();

    @NonNull
    @Override
    public BrowseDataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse_item, viewGroup, false);
        return new BrowseDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseDataHolder browseDataHolder, int index) {
        browseDataHolder.textView.setText(data.get(index));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addString(String newData) {
        data.add(newData);
    }


    class BrowseDataHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public BrowseDataHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
        }
    }

}
