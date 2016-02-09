package com.festo.didactic.ca.executable.comparator;

public class Difference<T> {
    private final T entity1;
    private final T entity2;
    private final DiffenceType diffenceType;

    private Difference(T entity1, T entity2, DiffenceType diffenceType) {
        this.entity1 = entity1;
        this.entity2 = entity2;
        this.diffenceType = diffenceType;
    }

    public static <T> Difference<T> createMissing(T entity) {
        return new Difference<T>(null, entity, DiffenceType.MISSING);
    }

    public static <T> Difference<T> createExceeding(T entity) {
        return new Difference<T>(entity, null, DiffenceType.EXCEEDING);
    }

    public static <T> Difference<T> createExisting(T entity1, T entity2) {
        return new Difference<T>(entity1, entity2, DiffenceType.EXISTING);
    }

    @Override
    public String toString() {
        switch (diffenceType) {
            case EXCEEDING:
                return entity1.toString() + " missing";
            case EXISTING:
                return entity1.toString() + " = " + entity2.toString();
            case MISSING:
                return entity2.toString() + " exceeding";
            default:
                return "";
        }
    }

    private enum DiffenceType {
        MISSING, EXCEEDING, EXISTING
    }

}
