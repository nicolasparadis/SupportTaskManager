package com.festo.didactic.ca.executable.task;

import java.util.Date;

public class Task {
    private final long id;
    private final String name;
    private final Date inputDate;

    public Task(long id, String name, Date inputDate) {
        this.id = id;
        this.name = name;
        this.inputDate = inputDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id == task.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}
