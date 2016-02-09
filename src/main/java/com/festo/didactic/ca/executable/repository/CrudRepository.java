package com.festo.didactic.ca.executable.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
}
