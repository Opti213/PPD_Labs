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
    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void dataTest(){
        for (int i = 0; i < 100; i++) {
            Item item = new Item("" + i, R.drawable.doggo);
            adapter.addItem(item);
        }
    }

}
