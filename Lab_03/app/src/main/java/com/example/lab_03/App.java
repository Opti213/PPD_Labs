package com.example.lab_03;

import android.app.Application;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

public class App extends Application {
    public static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    @Entity
    public class Student {

        @PrimaryKey
        public long id;
        public String name;
        public Date date;
    }

    @Dao
    public interface EmployeeDao {

        @Query("SELECT * FROM Student")
        List<Student> getAll();

        @Query("SELECT * FROM Student WHERE id = :id")
        Student getById(long id);

        @Insert
        void insert(Student student);

        @Update
        void update(Student student);

        @Delete
        void delete(Student student);

    }

    @Database(entities = {Student.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract EmployeeDao employeeDao();
    }
}
