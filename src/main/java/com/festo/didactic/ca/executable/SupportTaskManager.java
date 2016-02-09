package com.festo.didactic.ca.executable;

import com.festo.didactic.ca.executable.comparator.Difference;
import com.festo.didactic.ca.executable.comparator.ListComparator;
import com.festo.didactic.ca.executable.comparator.SimpleListComparator;
import com.festo.didactic.ca.executable.repository.CrudRepository;
import com.festo.didactic.ca.executable.repository.ExcelTaskRepository;
import com.festo.didactic.ca.executable.repository.SqlServerTaskRepository;
import com.festo.didactic.ca.executable.task.Task;

import java.util.List;

public class SupportTaskManager {
    public static void main(String[] args) {
        CrudRepository<Task> crudRepository1 = new ExcelTaskRepository();
        CrudRepository<Task> crudRepository2 = new SqlServerTaskRepository();

        ListComparator<Task> listComparator = new SimpleListComparator<>();
        List<Difference<Task>> differences = listComparator.compare(crudRepository1.findAll(), crudRepository2.findAll());

        for (Difference<Task> difference : differences) {
            System.out.println(difference);
        }
    }
}
