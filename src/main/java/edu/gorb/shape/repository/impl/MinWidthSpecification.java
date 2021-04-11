package edu.gorb.shape.repository.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.Specification;

public class MinWidthSpecification implements Specification {
    private final double minWidth;

    public MinWidthSpecification(double minWidth) {
        this.minWidth = minWidth;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double width = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());
        return width > minWidth;
    }
}
