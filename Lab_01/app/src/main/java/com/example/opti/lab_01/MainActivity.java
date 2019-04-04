package com.example.opti.lab_01;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Item> items = new ArrayList<>();
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
        dataTest();
        for (int i = 1; i < 10; i++) {
            //todo recyclerView.findViewHolderForAdapterPosition(i).itemView.setBackgroundColor(Color.GRAY);
            //todo recyclerView.getLayoutManager().findViewByPosition(i).findViewById(R.id.textView).setBackgroundColor(Color.GRAY);
        }

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void dataTest() {
        for (int i = 0; i < 10000; i++) {
            Item item = new Item(IntToWord.convert(i), R.drawable.doggo);
            if (i % 2 == 0) item.setColor(Color.GRAY);
            adapter.addItem(item);
        }
    }

}
