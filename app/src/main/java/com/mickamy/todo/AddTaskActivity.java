package com.mickamy.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity {

    private static final String TAG = AddTaskActivity.class.getSimpleName();

    static Intent createIntent(Context context) {
        return new Intent(context, AddTaskActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final EditText titleEd = findViewById(R.id.edit_title);
        final EditText descriptionEd = findViewById(R.id.edit_description);
        final Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEd.getText().toString();
                String description = descriptionEd.getText().toString();
                createTask(title, description);
            }
        });
    }

    private void createTask(String title, String description) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            Log.d(TAG, "createTask: title or description is empty!");
            return;
        }
        Task created = new Task(title, description);
        Log.d(TAG, "createTask: " + created.toString());
    }
}
