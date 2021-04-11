package edu.gorb.shape.repository;

import edu.gorb.shape.entity.Ellipse;

public interface Specification {
    public boolean specify(Ellipse ellipse);
}
