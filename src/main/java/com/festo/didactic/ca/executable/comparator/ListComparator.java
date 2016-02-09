package com.festo.didactic.ca.executable.comparator;

import java.util.List;

public interface ListComparator<T> {
    List<Difference<T>> compare(List<T> entities1, List<T> entities2);
}
