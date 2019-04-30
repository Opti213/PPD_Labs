package com.example.lab_03.Types;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey
    public int id;
    public String name;
    public String date;

    public Student(int id, String name, String date){
        this.date = date;
        this.name = name;
        this.id = id;
    }

    public String toString(){
        String res = Long.toString(id) + " : " + name + " : " + date;
        return res;
    }
}
