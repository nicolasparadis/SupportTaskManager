package com.festo.didactic.ca.executable.repository;

import com.festo.didactic.ca.executable.task.Task;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SqlServerTaskRepository implements CrudRepository<Task> {
    public List<Task> findAll() {
        return Arrays.asList(
            new Task(1, "Test", new Date()),
            new Task(2, "Test", new Date())
        );
    }
}
