package com.example.lab_03.DataBases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lab_03.Interfaces.StudentDao;
import com.example.lab_03.Types.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
