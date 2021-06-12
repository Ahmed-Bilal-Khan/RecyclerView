package com.example.recyclerview_191113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview_191113.Adapter.RecyclerViewAdapter;
import com.example.recyclerview_191113.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> studentlist = new ArrayList<>();
    RecyclerView recycle;
    RecyclerViewAdapter recycleAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle = findViewById(R.id.recycle);
        studentlist.add(new Student("Ahmed","191113"));
        studentlist.add(new Student("Abdullah","191169"));
        studentlist.add(new Student("Saad","191013"));
        studentlist.add(new Student("Mohid","191223"));
        studentlist.add(new Student("Salman","190113"));
        studentlist.add(new Student("Ahad","191913"));
        studentlist.add(new Student("Arslan","191311"));
        studentlist.add(new Student("Saroosh","181114"));
        recycleAdapt = new RecyclerViewAdapter(MainActivity.this,studentlist);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(recycleAdapt);
        recycle.setHasFixedSize(true);
    }
}