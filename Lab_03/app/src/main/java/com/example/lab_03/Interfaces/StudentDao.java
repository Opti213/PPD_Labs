package com.example.lab_03.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.example.lab_03.Types.Student;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM Student")
    List<Student> getAll();

    @Query("SELECT * FROM Student WHERE id = :id")
    Student getById(long id);

    @Query("SELECT * FROM Student WHERE id = (SELECT MAX(ID) FROM Student)")
    Student getLastStudent();

    @Query("DELETE FROM student")
    void nukeTable();

    @Insert
    void insert(Student student);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Student... students);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

}
