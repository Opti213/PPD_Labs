package com.example.lab_03;

import android.arch.persistence.room.Room;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bInfo;
    private Button bAdd;
    private Button bChange;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.BLUE);

        bInfo = findViewById(R.id.bInfo);
        bAdd = findViewById(R.id.bAdd);
        bChange = findViewById(R.id.bChange);
        text = findViewById(R.id.textView);

        AppDatabase db;
        db = App.getInstance().getDatabase();
        StudentDao dao = db.studentDao();

    }
}
