package com.example.lab_03;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey
    public long id;

    public String name;
    public String date;

    public Student(int id, String name, String date){
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String toString(){
        String res = Long.toString(id) + " : " + name + " : " + date;
        return res;
    }
}
