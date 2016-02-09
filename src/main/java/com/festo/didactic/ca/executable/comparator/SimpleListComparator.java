package com.festo.didactic.ca.executable.comparator;

import java.util.ArrayList;
import java.util.List;

public class SimpleListComparator<T> implements ListComparator<T> {
    @Override
    public List<Difference<T>> compare(List<T> entities1, final List<T> entities2) {
        List<Difference<T>> differences = new ArrayList<>();

        addAllMissing(entities1, entities2, differences);
        addAllExisting(entities1, entities2, differences);
        addAllExceeding(entities1, entities2, differences);

        return differences;
    }

    private void addAllMissing(List<T> entities1, List<T> entities2, List<Difference<T>> differences) {
        List<T> entities2Copy = new ArrayList<>(entities2);
        entities2Copy.removeAll(entities1);

        entities2Copy.stream().forEach(t -> differences.add(Difference.createExceeding(t)));
    }

    private void addAllExisting(List<T> entities1, List<T> entities2, List<Difference<T>> differences) {
        for (T entity1 : entities1) {
            for (T entity2 : entities2) {
                if (entity1.equals(entity2))
                    differences.add(Difference.createExisting(entity1, entity2));
            }
        }
    }

    private void addAllExceeding(List<T> entities1, List<T> entities2, List<Difference<T>> differences) {
        List<T> entities1Copy = new ArrayList<>(entities1);
        entities1Copy.removeAll(entities2);

        entities1Copy.stream().forEach(t -> differences.add(Difference.createMissing(t)));
    }
}