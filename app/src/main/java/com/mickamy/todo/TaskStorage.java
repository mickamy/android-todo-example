package com.mickamy.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    private static TaskStorage instance;

    public static TaskStorage getInstance() {
        if (instance == null) {
            instance = new TaskStorage();
        }
        return instance;
    }

    private List<Task> tasks;

    private TaskStorage() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public List<Task> getAll() {
        return tasks;
    }
}
