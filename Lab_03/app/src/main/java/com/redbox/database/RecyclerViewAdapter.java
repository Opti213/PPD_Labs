package com.redbox.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<App.Student> list;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(Context context, List<App.Student> list) {
        this.mContext = context;
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView timeTextView;

        ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.name);
            timeTextView = view.findViewById(R.id.timeStamp);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        App.Student student = list.get(i);
        viewHolder.nameTextView.setText(student.id + " " + student.credentials);
        viewHolder.timeTextView.setText(student.timestamp);

    }
}