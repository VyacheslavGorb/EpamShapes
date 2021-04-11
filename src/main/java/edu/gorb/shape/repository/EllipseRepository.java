package edu.gorb.shape.repository;

import edu.gorb.shape.entity.Ellipse;

import java.util.*;
import java.util.stream.Collectors;

public class EllipseRepository {
    private static final EllipseRepository INSTANCE = new EllipseRepository();
    private final List<Ellipse> storage = new ArrayList<>();

    private EllipseRepository() {
    }

    public static EllipseRepository getInstance() {
        return INSTANCE;
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public boolean contains(Object o) {
        return storage.contains(o);
    }

    public boolean add(Ellipse ellipse) {
        return storage.add(ellipse);
    }

    public boolean remove(Object o) {
        return storage.remove(o);
    }

    public void clear() {
        storage.clear();
    }

    public Ellipse get(int index) {
        return storage.get(index);
    }

    public Ellipse set(int index, Ellipse element) {
        return storage.set(index, element);
    }

    public void sort(Comparator<? super Ellipse> c) {
        storage.sort(c);
    }

    public List<Ellipse> query(Specification specification) {
        return storage.stream()
                .filter((specification::specify))
                .collect(Collectors.toList());
    }
}
