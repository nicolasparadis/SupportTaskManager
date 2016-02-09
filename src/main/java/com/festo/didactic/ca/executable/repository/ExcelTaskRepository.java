package com.festo.didactic.ca.executable.repository;

import com.festo.didactic.ca.executable.task.Task;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ExcelTaskRepository implements TaskRepository {
    private final File excelFile;

    public ExcelTaskRepository(File excelFile) {
        this.excelFile = excelFile;
    }

    @Override
    public List<Task> findAll() {
        return Arrays.asList(
            new Task(1, "Test", new Date()),
            new Task(3, "Test", new Date())
        );
    }
}
