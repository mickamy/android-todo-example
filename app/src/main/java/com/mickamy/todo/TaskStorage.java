package com.mickamy.todo;

import java.util.List;

import io.realm.Realm;

public class TaskStorage {

    private static TaskStorage instance;

    public static TaskStorage getInstance() {
        if (instance == null) {
            instance = new TaskStorage();
        }
        return instance;
    }

    private Realm realm;

    private TaskStorage() {
        realm = Realm.getDefaultInstance();
    }

    public void add(final Task task) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(task);
            }
        });
    }

    public List<Task> getAll() {
        return realm.where(Task.class).findAll();
    }
}
