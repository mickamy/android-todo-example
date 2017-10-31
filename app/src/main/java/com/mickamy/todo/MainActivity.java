package com.mickamy.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ListView listView;
    private ArrayAdapter<Task> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureLayout();

        List<Task> tasks = TaskStorage.getInstance().getAll();
        Log.d(TAG, "onCreate: " + tasks);
    }

    private void configureLayout() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAddTask();
            }
        });
        listView = findViewById(R.id.list_task);
        configureTaskList();
    }

    private void configureTaskList() {
        List<Task> tasks = TaskStorage.getInstance().getAll();
        int itemLayout = R.layout.item_task;
        int titleId = R.id.text_title;
        taskAdapter = new ArrayAdapter<>(this,
                itemLayout,
                titleId,
                tasks
        );
        listView.setAdapter(taskAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        configureTaskList();
    }

    private void startAddTask() {
        Intent intent = AddTaskActivity.createIntent(this);
        startActivity(intent);
    }
}
