package com.redbox.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.List;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        App.StudentDatabase sb = App.getInstance().getStudentDatabase();

        final App.StudentDao sd = sb.studentDao();

        final List<App.Student> list = sd.getAll();

        for (App.Student e : list) {
            Log.d("T", "List: " + e.credentials + " " + e.timestamp);
        }

        RecyclerView recyclerView = findViewById(R.id.list);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), list);

        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        recyclerViewAdapter.notifyDataSetChanged();


    }
}
