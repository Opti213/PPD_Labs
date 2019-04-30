package com.example.lab_03;

import android.arch.persistence.room.Room;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.lab_03.DataBases.AppDatabase;
import com.example.lab_03.Interfaces.StudentDao;
import com.example.lab_03.Types.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Color.RED);

        //db connection
        AppDatabase db =  Room.databaseBuilder(this, AppDatabase.class, "StudentsDB").allowMainThreadQueries().build();
        StudentDao dao = db.studentDao();

        //test db
        //addTestStudents(5, dao);  //todo
        //ArrayList<Student> arr = (ArrayList<Student>) dao.getAll();
        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, studentToString(arr));
        //listView = findViewById(R.id.checkView);
        //listView.setAdapter(itemsAdapter);
    }

    void addTestStudents(int count, StudentDao dao){
        for (int i=0; i < count;i++){
            dao.insert(new Student(i,"testStudent", "now"));
        }
    }

    ArrayList<String> studentToString(ArrayList<Student> students){
        ArrayList<String> res = null;
        for (Student student : students){
            res.add(student.toString());
        }
        return res;
    }
}
