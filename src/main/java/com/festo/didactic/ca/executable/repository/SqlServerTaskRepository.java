package com.festo.didactic.ca.executable.repository;

import com.festo.didactic.ca.executable.task.Task;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class SqlServerTaskRepository implements TaskRepository {
    private final Connection connection;

    public SqlServerTaskRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Task> findAll() {
        return Arrays.asList(
            new Task(1, "Test"),
            new Task(2, "Test")
        );
    }
}
