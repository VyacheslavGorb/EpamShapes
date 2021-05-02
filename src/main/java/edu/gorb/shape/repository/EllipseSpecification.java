package edu.gorb.shape.repository;

import edu.gorb.shape.entity.Ellipse;

@FunctionalInterface
public interface EllipseSpecification {
    public boolean specify(Ellipse ellipse);
}
