package com.festo.didactic.ca.executable;

import com.festo.didactic.ca.executable.comparator.Difference;
import com.festo.didactic.ca.executable.comparator.ListComparator;
import com.festo.didactic.ca.executable.comparator.SimpleListComparator;
import com.festo.didactic.ca.executable.repository.ExcelTaskRepository;
import com.festo.didactic.ca.executable.repository.SqlServerTaskRepository;
import com.festo.didactic.ca.executable.repository.TaskRepository;
import com.festo.didactic.ca.executable.task.Task;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SupportTaskManager {
    public void run(File configurationFile) {

        try (Connection connection = null) {
            TaskRepository taskRepository1 = new ExcelTaskRepository(new File("")); // FIXME
            TaskRepository taskRepository2 = new SqlServerTaskRepository(connection);

            ListComparator<Task> listComparator = new SimpleListComparator<>();
            List<Difference<Task>> differences = listComparator.compare(taskRepository1.findAll(), taskRepository2.findAll());

            for (Difference<Task> difference : differences) {
                System.out.println(difference);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("configuration file missing");
            return;
        }

        File configurationFile = new File(args[0]);

        if (!configurationFile.exists() || !configurationFile.isFile()) {
            System.out.println("configuration file not existent");
            return;
        }

        new SupportTaskManager().run(configurationFile);
    }
}
