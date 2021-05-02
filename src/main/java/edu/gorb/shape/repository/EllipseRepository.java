package edu.gorb.shape.repository;

import edu.gorb.shape.entity.Ellipse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public boolean contains(Ellipse o) {
        return storage.contains(o);
    }

    public boolean add(Ellipse ellipse) {
        return storage.add(ellipse);
    }

    public boolean remove(Ellipse o) {
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

    public List<Ellipse> sortStream(Comparator<? super Ellipse> comparator) {
        return storage.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Ellipse> sort(Comparator<? super Ellipse> comparator) {
        List<Ellipse> storageCopy = new ArrayList<Ellipse>(storage);
        storageCopy.sort(comparator);
        return storageCopy;
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        return storage.stream()
                .filter((specification::specify))
                .collect(Collectors.toList());
    }
}
