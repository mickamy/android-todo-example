package com.mickamy.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAddTask();
            }
        });
        List<Task> tasks = TaskStorage.getInstance().getAll();
        Log.d(TAG, "onCreate: " + tasks);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Task> tasks = TaskStorage.getInstance().getAll();
        Log.d(TAG, "onResume: " + tasks);
    }

    private void startAddTask() {
        Intent intent = AddTaskActivity.createIntent(this);
        startActivity(intent);
    }
}
