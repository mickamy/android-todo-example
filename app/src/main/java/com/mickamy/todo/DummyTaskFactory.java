package com.mickamy.todo;

import java.util.ArrayList;
import java.util.List;

public class DummyTaskFactory {

    public static List<Task> create(int size) {
        List<Task> dummy = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Task task = new Task("Dummy title " + i, "Dummy description " + i);
            dummy.add(task);
        }
        return dummy;
    }
}
