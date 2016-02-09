package com.festo.didactic.ca.executable.repository;

import com.festo.didactic.ca.executable.task.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
}
