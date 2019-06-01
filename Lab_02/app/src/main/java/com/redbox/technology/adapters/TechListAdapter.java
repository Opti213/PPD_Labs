package com.redbox.technology.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.redbox.technology.R;
import com.redbox.technology.models.Technology;
import com.squareup.picasso.*;

import java.lang.reflect.Type;
import java.util.List;

public class TechListAdapter extends RecyclerView.Adapter<TechListAdapter.ViewHolder> {
    private Context mContext;
    private List<Technology> technologies;

    public TechListAdapter() {
    }

    public TechListAdapter(Context context, @NonNull String rawList) {
        this.mContext = context;

        Type listType = new TypeToken<List<Technology>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        technologies = gson.fromJson(rawList, listType);
        technologies.remove(0);

    }

    public TechListAdapter(Context context, List<Technology> technologies) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView iconImageView;

        ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.techNameTextView);
            iconImageView = view.findViewById(R.id.iconImageView);
        }
    }

    @Override
    public int getItemCount() {
        if (technologies != null) return technologies.size();
        else return 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tech_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Technology technology = technologies.get(i);
        viewHolder.nameTextView.setText(technology.getName());

        Picasso.get().load(mContext.getResources().getString(R.string.img_url) + technology.getGraphic()).into(viewHolder.iconImageView);

    }
}
