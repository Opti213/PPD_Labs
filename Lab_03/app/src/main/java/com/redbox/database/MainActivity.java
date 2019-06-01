package com.redbox.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button info;
    private Button add;
    private Button change;
    private TextView count;

    private String[] names = new String[]{"Иван", "Петр", "Виктор", "Николай", "Александр"};
    private String[] second_names = new String[]{"Иванович", "Петрович", "Викторович", "Николаевич", "Александрович"};
    private String[] surnames = new String[]{"Иванов", "Петров", "Викторов", "Николаев", "Александров"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.infoButton);
        add = findViewById(R.id.addButton);
        change = findViewById(R.id.changeButton);
        count = findViewById(R.id.userCountTextView);

        App.StudentDatabase sb = App.getInstance().getStudentDatabase();

        final App.StudentDao sd = sb.studentDao();

        final List<App.Student> list = sd.getAll();

        if (!list.isEmpty()) {
            for (App.Student e : list) {
                sd.delete(e);
            }
        }

        list.clear();

        if (list.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                App.Student student = generate(i);
                list.add(student);
                sd.insert(student);
            }
        }

        for (App.Student e : list) {
            Log.d("T", "List: " + e.credentials + " " + e.timestamp);
        }

        count.setText("The database holds " + list.size() + " entries");

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.Student student = generate(list.size() + 1);
                list.add(student);
                sd.insert(student);
                for (App.Student e : list) {
                    Log.d("T", "List: " + e.credentials + " " + e.timestamp);
                }

                count.setText("The database holds " + list.size() + " entries");
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.Student student = list.get(list.size()-1);
                student.credentials = names[0] + " " + second_names[0] + " " + surnames[0];

                //student.name = names[0];
                //student.sec_name = second_names[0];
                //student.surname = surnames[0];

                sd.update(student);

                for (App.Student e : list) {
                    Log.d("T", "List: " + e.credentials + " " + e.timestamp);
                }

                Toast.makeText(getBaseContext(), "The entry was updated", Toast.LENGTH_LONG).show();

            }
        });

    }

    App.Student generate(int i) {
        App.Student student = new App.Student();

        student.id = i;

        if (i >= 5) {
            i = (int) (Math.random() * 4);
        }
        student.credentials = names[i] + " " + second_names[i] + " " + surnames[i];

        //student.name = names[i];
        //student.sec_name = second_names[i];
        //student.surname = surnames[i];

        student.timestamp = new Date().toString();
        return student;
    }

}
