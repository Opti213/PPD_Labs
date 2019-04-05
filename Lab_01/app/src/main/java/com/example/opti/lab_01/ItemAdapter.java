package com.example.opti.lab_01;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    //Hold list
    private ArrayList<Item> items;

    //constructor
    public ItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void bind(Item item) {

    }

    //manipulation with List functions
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addItem(ArrayList<Item> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        items.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //init obj
        private ConstraintLayout cLayout;
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            cLayout = (ConstraintLayout) view.findViewById(R.id.cLayout);
        }

        public void bind(Item item) {
            textView.setText(item.str);
            textView.setTextColor(Color.BLACK);
            imageView.setImageResource(item.img);
            cLayout.setBackgroundColor(item.color);
        }

        public void bindBackground(int color) {
            cLayout.setBackgroundColor(color);
        }
    }


}
