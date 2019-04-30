package com.example.lab_03;

import android.arch.persistence.room.Room;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lab_03.DataBases.AppDatabase;
import com.example.lab_03.Interfaces.StudentDao;
import com.example.lab_03.Types.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Color.RED);

        //db connection
        AppDatabase db =  Room.databaseBuilder(this, AppDatabase.class, "StudentsDB").allowMainThreadQueries().build();
        StudentDao dao = db.studentDao();

        addTestStudents(5, dao);
        ArrayList<Student> arr = (ArrayList<Student>) dao.getAll();

    }

    void addTestStudents(int count, StudentDao dao){
        for (int i=0; i < count;i++){
            dao.insert(new Student(i,"testStudent", "now"));
        }
    }
}
